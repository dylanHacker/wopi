package com.xuehai.wopi.common.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: chenyj
 * @Description:
 * @Date: Create in 2018-03-02 13:58
 */
public class UrlUtil {
    /**
     * convert query string to map
     **/
    public static HashMap getQueryStringMapping(String queryString) {

        HashMap map = new HashMap();

        String[] params = queryString.split("&");
        for(String param : params){
            String key = param.split("=")[0];
            String val = param.split("=")[1];
            map.put(key,val);
        }

        return map;
    }
}
