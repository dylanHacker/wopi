package com.dylan.wopi.service.impl;

import com.dylan.wopi.common.code.TypeCode;
import com.dylan.wopi.common.util.NetUtil;
import com.dylan.wopi.dto.FileBasicInfoRes;
import com.dylan.wopi.dto.StringUtil;
import com.dylan.wopi.service.api.WopiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;

/**
 * @Author: chenyj
 * @Description:
 * @Date: Create in 2018-03-01 9:48
 */
@Service
public class WopiServiceImpl implements WopiService {

    private Logger logger = LoggerFactory.getLogger(WopiServiceImpl.class);

    @Override
    public FileBasicInfoRes getFileBasicInfo(String name, HashMap params) {
        String fileUrl = (String) params.get("url");
        FileBasicInfoRes info = new FileBasicInfoRes();
        File resourceDir = new File("resource");
        if (!resourceDir.exists()) {
            resourceDir.mkdir();
        }
        String filePath = "resource/" + name;
        // 判断是否有文件地址传入，没有的话直接读取本地文件，有的话下载更新本地文件
        if (StringUtils.isEmpty(fileUrl)) {
            info = getFileInfo(filePath, params);
        } else {
            try {
                NetUtil.downFile(fileUrl, filePath);
                info = getFileInfo(filePath, params);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return info;
    }

    @Override
    public HttpServletResponse getFileContent(String name, HttpServletResponse res) {
        logger.info("name: " + name);
        logger.info(ByteOrder.nativeOrder().toString());
        String path = "resource/" + name;
        InputStream ins = null;
        OutputStream outs = null;
        try {

            File file = new File(path);
            ins = new FileInputStream(path);
            logger.info("file.length() " + file.length());
            outs = res.getOutputStream();
            res.setContentType("application/octet-stream");
            ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[Math.toIntExact(file.length())]);
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
            if (ins.read(byteBuffer.array()) != -1) {

                outs.write(byteBuffer.array(), 0, byteBuffer.array().length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ins != null) {
                    ins.close();
                    logger.info("ins closed");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (outs != null) {
                    outs.close();
                    logger.info("outs closed");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return res;
    }

    @Override
    public void saveFileContent(String name, byte[] content) {
        System.out.println("------------ save file ------------ ");
        // 文件的路径
        String path = "resource/" + name;
        File file = new File(path);
        FileOutputStream fop = null;
        try {
            if (!file.exists()) {
                if (!file.createNewFile()) {
                    throw new IOException("创建本地文件失败！");
                }//构建文件
            }
            fop = new FileOutputStream(file);
            fop.write(content);
            fop.flush();
            fop.close();

            System.out.println("--------- save file done! --------- ");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fop != null) {
                    fop.close();
                } else {
                    throw new IOException("文件关闭失败！");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private FileBasicInfoRes getFileInfo(String filePath, HashMap params) {
        File file = new File(filePath);
        FileBasicInfoRes info = new FileBasicInfoRes();
        try {
            if (file.exists()) {
                // 取得文件名
                info.setBaseFileName(file.getName());
                info.setSize(file.length());
                info.setOwnerId("admin");
                info.setVersion(String.valueOf(file.lastModified()));
//                    info.setSha256(HashUtil.md5HashCode("resource/" + name, "SHA-256"));
                info.setAllowExternalMarketplace(false);
                info.setUserCanWrite(true);
                info.setSupportsUpdate(true);
                info.setUserFriendlyName("admin");
                // 默认为不可在线编辑
                if(StringUtil.isNotEmpty(params.get("editable")) && params.get("editable").equals(TypeCode.EDIT_AVAILABLE_SIGNAL)){
                    info.setWebEditingDisabled(TypeCode.EDIT_AVAILABLE);
                } else {
                    info.setWebEditingDisabled(TypeCode.EDIT_DISABLE);
                }

            } else {
                throw new FileNotFoundException();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return info;
    }
}
