/*
 * @Author: 丑牛
 * @Date: 2021-09-28 19:19:02
 * @LastEditors: 丑牛
 * @LastEditTime: 2021-09-28 20:18:59
 * @Description: 统一结果处理
 */
package com.blog.blogspringback.common.lang;

import java.io.Serializable;

import lombok.Data;

@Data
public class Result implements Serializable{
    private int code;
    private String msg;
    private Object data;
    public static Result success(Object data){
        return success(200);
    }
    public static Result success(int code, String msg, Object data) {
        Result res = new Result();
        res.setCode(code);
        res.setMsg(msg);
        res.setData(data);
        return res;
    }
    
    public static Result fail(String msg) {
        return fail(400, msg, null);
    }

    public static Result fail(String msg, Object data) {
        return fail(400, msg, data);
    }

    public static Result fail(int code, String msg, Object data) {
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }
}