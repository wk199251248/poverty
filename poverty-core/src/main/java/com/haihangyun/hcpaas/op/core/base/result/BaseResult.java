package com.haihangyun.hcpaas.op.core.base.result;

/**
 * Created by miracle on 2017/3/1.
 */
public class BaseResult implements java.io.Serializable {

    private boolean isSuccess;
    private String message;
    private String data;
    private String type;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
