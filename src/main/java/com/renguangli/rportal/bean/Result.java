package com.renguangli.rportal.bean;

public class Result {

    /**
     * 0、请求成功
     */
    private int code;

    private String message = "请求成功！";

    private int count;

    private Object data;

    public Result() {}

    public Result(Object data, int count) {
        this.data = data;
        this.count = count;
    }

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }
}
