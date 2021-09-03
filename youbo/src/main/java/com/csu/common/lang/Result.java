package com.csu.common.lang;

import lombok.Data;

import java.io.Serializable;


//异步加载的返回值的类：
@Data
public class Result implements Serializable {       //需要序列化


    private int status;     //状态值       // 0成功，-1失败
    private String msg;
    private Object data;        //返回结果
    private String action;  //之后可能的操作

    public static Result success() {
        return Result.success("操作成功", null);
    }

    public static Result success(Object data) {
        return Result.success("操作成功", data);
    }

    public static Result success(String msg, Object data) {
        Result result = new Result();
        result.status = 0;
        result.msg = msg;
        result.data = data;
        return result;
    }

    public static Result fail(String msg) {
        Result result = new Result();
        result.status = -1;
        result.data = null;
        result.msg = msg;
        return result;
    }

    public Result action(String action){
        this.action = action;
        return this;
    }


}
