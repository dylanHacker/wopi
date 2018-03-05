package com.xuehai.wopi.controller.impl;

import com.alibaba.fastjson.JSON;
import com.xuehai.wopi.common.util.UrlUtil;
import com.xuehai.wopi.controller.api.IWopiController;
import com.xuehai.wopi.dto.FileBasicInfoRes;
import com.xuehai.wopi.dto.StringUtil;
import com.xuehai.wopi.service.api.WopiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * @Author: chenyj
 * @Description:
 * @Date: Create in 2018-03-01 9:48
 */

@RestController
public class WopiController {

    /**
     * GET api/wopi/files/{name}?access_token={access_token}
     * GET api/wopi/files/{name}/contents?access_token={access_token}
     * POST api/wopi/files/{name}/contents?access_token={access_token}
     **/

    @Autowired
    private WopiService wopiService;

    private Logger logger = LoggerFactory.getLogger(WopiController.class);

    @RequestMapping(value = IWopiController.GET_FILE_INFO, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Object getFileInfo(@PathVariable String name, HttpServletRequest req, HttpServletResponse res) {
        logger.info(req.getRequestURI());
        name = req.getRequestURI().split("/")[req.getRequestURI().split("/").length - 1];
        logger.info(name);
        logger.info(req.getQueryString());
        HashMap params;
        if (StringUtil.isNotEmpty(req.getQueryString())) {
            params = UrlUtil.getQueryStringMapping(req.getQueryString());
        } else {
            params = new HashMap();
        }
        FileBasicInfoRes infoRes = wopiService.getFileBasicInfo(name, params);
        logger.info(String.valueOf(infoRes.toString().length()));
        return infoRes;
    }

    @RequestMapping(value = IWopiController.GET_FILE_CONTENT, method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public void getFileContent(@PathVariable String name, HttpServletRequest req, HttpServletResponse res) {
        logger.info(req.getRequestURI());
        wopiService.getFileContent(name, res);
    }

    @RequestMapping(value = IWopiController.POST_FILE_CONTENT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void saveEditedFile(@PathVariable String name, @RequestBody byte[] content, HttpServletRequest req) {
        logger.info(req.getRequestURI());
        wopiService.saveFileContent(name, content);
    }
}
