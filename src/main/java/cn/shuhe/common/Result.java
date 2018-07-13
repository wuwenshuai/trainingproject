package cn.shuhe.common;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Administrator on 2016/9/15.
 */

public class Result {
    private boolean success;
    private String msg;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Result() {
    }

    public Result(String msg) {

        this.msg = msg;
    }

    public Result(Boolean success) {

        this.success = success;
    }

    public Result(boolean success, String msg) {

        this.success = success;
        this.msg = msg;
    }
}
