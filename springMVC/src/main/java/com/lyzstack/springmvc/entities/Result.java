package com.lyzstack.springmvc.entities;

import lombok.Data;

@Data
public class Result {
    // 响应体中的业务状态码：200 成功，404 用户不存在，500 操作失败。
    // 这个字段本身不会改变 HTTP 状态码。
    private Integer code;
    private String message;
    private Object data;

    public static Result success(Object data) {
        return success("success", data);
    }
    public static Result success(String message, Object data) {
        Result result = new Result();
        result.setCode(200);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public static Result failed(String message) {
        return failed(500,message);
    }

    public static Result failed(Integer code, String message) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        result.setData(null);
        return result;
    }

    public static Result failed(String message, Object data) {
        Result result = new Result();
        result.setCode(500);
        result.setMessage(message);
        result.setData(data);
        return result;
    }
}
