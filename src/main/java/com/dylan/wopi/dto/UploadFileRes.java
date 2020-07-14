package com.dylan.wopi.dto;

/**
 * Created by Administrator on 2017/1/21 0021.
 */

import java.io.Serializable;

public class UploadFileRes extends CommonRes implements Serializable {

    private static final long serialVersionUID = -3574250185385678443L;
    private UploadFileDTO uploadFileDTO;

    public UploadFileRes() {
        super();
    }

    public UploadFileRes(UploadFileDTO uploadFileDTO) {
        super();
        this.uploadFileDTO = uploadFileDTO;
    }

    public UploadFileDTO getUploadFileDTO() {
        return uploadFileDTO;
    }

    public void setUploadFileDTO(UploadFileDTO uploadFileDTO) {
        this.uploadFileDTO = uploadFileDTO;
    }

    @Override
    public String toString() {
        return "UploadFileRes [uploadFileDTO=" + uploadFileDTO + "]";
    }
}
