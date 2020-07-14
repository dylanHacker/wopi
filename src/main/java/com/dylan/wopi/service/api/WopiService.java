package com.dylan.wopi.service.api;

import com.dylan.wopi.dto.FileBasicInfoRes;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * @Author: chenyj
 * @Description:
 * @Date: Create in 2018-03-01 9:48
 */
public interface WopiService {
    FileBasicInfoRes getFileBasicInfo(String name, HashMap params);

    HttpServletResponse getFileContent(String name, HttpServletResponse res);

    void saveFileContent(String name, byte[] content);
}
