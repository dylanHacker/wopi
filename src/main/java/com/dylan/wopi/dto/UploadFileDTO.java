package com.dylan.wopi.dto;

/**
 * Created by Administrator on 2017/1/21 0021.
 */
import java.io.Serializable;

public class UploadFileDTO implements Serializable {

    private static final long serialVersionUID = -6090850592240265531L;
    private String fileId;

    public UploadFileDTO() {
        super();
    }

    public UploadFileDTO(String fileId) {
        super();
        this.fileId = fileId;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    @Override
    public String toString() {
        return "UploadFileDTO [fileId=" + fileId + "]";
    }
}

