package com.xuehai.wopi.controller.api;

/**
 * @Author: chenyj
 * @Description:
 * @Date: Create in 2018-03-01 9:47
 */
public class IWopiController {

    /**
     * GET api/wopi/files/{name}?access_token={access_token}
     * GET api/wopi/files/{name}/contents?access_token={access_token}
     * POST api/wopi/files/{name}/contents?access_token={access_token}
     **/

    public static final String GET_FILE_INFO = "/wopi/files/{name}";

    public static final String GET_FILE_CONTENT = "/wopi/files/{name}/contents";

    public static final String POST_FILE_CONTENT = "/wopi/files/{name}/contents";


}
