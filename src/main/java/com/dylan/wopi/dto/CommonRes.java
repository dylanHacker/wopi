package com.dylan.wopi.dto;

/**
 * Created by Chenyz on 2016/12/20.
 */
public class CommonRes {

    private short status;
    private String message;


    public CommonRes() {
    }

    public CommonRes(short status, String message) {
        this.status = status;
        this.message = message;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CommonRes{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
