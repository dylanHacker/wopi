package com.dylan.wopi.common.util;

import com.alibaba.fastjson.JSON;
import com.dylan.wopi.dto.StringUtil;
import com.dylan.wopi.dto.UploadFileRes;
import com.xuehai.file.ClientSDK;
import com.dylan.wopi.common.code.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

//import com.xuehai.app.dto.ResultCode;
//import com.xuehai.app.dto.UploadFileRes;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;

/**
 * Created by Chenyz on 2016/12/23.
 */
public class NetUtil {
    //private final static Log log= LogFactory.getLog(NetUtil.class);


    /**
     * 下载成文件保存
     *
     * @param fileUrl
     * @param filePath
     * @return
     */
    public static String downFile(String fileUrl, String filePath) throws IOException {
        Logger log = LoggerFactory.getLogger(NetUtil.class);
        FileOutputStream fos = null;
        InputStream inputStream = null;
        if (null == filePath || "".equalsIgnoreCase(filePath)) {
            filePath = System.currentTimeMillis() + ".tmp";
        }
//        try {
            log.info("download url: " + fileUrl);
            long start = System.currentTimeMillis();
            URL url = new URL(fileUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //连接超时：60秒
            conn.setConnectTimeout(60 * 1000);
            //下载超时：300秒
            conn.setReadTimeout(300 * 1000);
            //防止屏蔽程序抓取而返回403错误  
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            inputStream = conn.getInputStream();
            byte[] dataFlow = readInputStream(inputStream);
            File saveFile = new File(filePath);
            fos = new FileOutputStream(saveFile);
            fos.write(dataFlow);
            log.info("download cost: " + (System.currentTimeMillis() - start) + " ms");

//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
        fos.close();
        if (null != inputStream) {
                    inputStream.close();
                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        return filePath;
//        return null;
    }


    /**
     * 将文件转换成流
     *
     * @param fileUrl
     * @return
     */
    public static byte[] downFlow(String fileUrl) {
        try {
            long sTime = System.currentTimeMillis();
            System.out.println("DOWN-FLOW-STATUS:START");
            System.out.println("FILE-URL:" + fileUrl);
            URL url = new URL(fileUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(60 * 1000);
            conn.setReadTimeout(60 * 1000);
            //防止屏蔽程序抓取而返回403错误  
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            InputStream inputStream = conn.getInputStream();
            byte[] dataFlow = readInputStream(inputStream);
            System.out.println("DOWN-FLOW-STATUS:END");
            long eTime = System.currentTimeMillis();
            System.out.println("DOWN-FLOW-COST：" + ((eTime - sTime)) + " ms");
            return dataFlow;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据url获取图片的信息
     *
     * @param url
     * @return
     */
    public static BufferedImage getPictureInfo(String url) {
        BufferedImage img = null;
        try {
            URL picurl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) picurl.openConnection();
            conn.setConnectTimeout(10 * 1000);
            //防止屏蔽程序抓取而返回403错误  
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            InputStream is = conn.getInputStream();
            img = ImageIO.read(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return img;
    }

    /**
     * 将字节数组base64
     *
     * @param data
     * @return
     */
    public static String base64(byte[] data) {
        // 对字节数组Base64编码  
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);// 返回Base64编码过的字节数组字符串  
    }

    /**
     *  
     * 从输入流中获取字节数组 
     *
     * @param inputStream 
     * @return 
     * @throws IOException 
     */
    private static byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }


    public static String uploadFile(String appKey, String fileUrl) {
        Logger log = LoggerFactory.getLogger(NetUtil.class);
        log.debug("appkey: " + appKey);
        log.debug("upload fileurl: " + fileUrl);
        log.info("UPLOAD-START " + fileUrl);
        ClientSDK clientSDK = new ClientSDK();
        File localfile = new File(fileUrl);
        if (localfile.exists()) {
            String url = clientSDK.uploadSingleFile(appKey, fileUrl);
            UploadFileRes uploadFileRes = JSON.parseObject(url, UploadFileRes.class);
            if (StringUtil.isNotEmpty(uploadFileRes)) {
                if (uploadFileRes.getStatus() == ResultCode.RESULT_OK) {
                    // "http://files.yunzuoye.net/XHFileServer/file/download/xhtest?fileId=";
                    //删除已经上传的文件
                    new File(fileUrl).delete();
                    if (uploadFileRes.getUploadFileDTO().getFileId().contains(".xh")) {
                        log.error(".xh extension");
                    }
                    return uploadFileRes.getUploadFileDTO().getFileId();
                }
            }
        }
        return "文件不存在！";
    }

    public static String uploadFile(String appKey, String fileUrl, String fileServer) {
        Logger log = LoggerFactory.getLogger(NetUtil.class);
        log.debug("appkey: " + appKey);
        log.debug("upload fileurl: " + fileUrl);
        log.info("UPLOAD-START " + fileUrl);
        ClientSDK clientSDK = new ClientSDK();
        File localfile = new File(fileUrl);
        if (localfile.exists()) {
            String url = clientSDK.uploadSingleFile(appKey, fileUrl, fileServer);
            UploadFileRes uploadFileRes = JSON.parseObject(url, UploadFileRes.class);
            if (StringUtil.isNotEmpty(uploadFileRes)) {
                if (uploadFileRes.getStatus() == ResultCode.RESULT_OK) {
                    //删除已经上传的文件
//                    new File(fileUrl).delete();
                    if (uploadFileRes.getUploadFileDTO().getFileId().contains(".xh")) {
                        log.error(".xh extension");
                    }
                    return uploadFileRes.getUploadFileDTO().getFileId();
                }
            }
        }
        return "文件不存在！";
    }

}
