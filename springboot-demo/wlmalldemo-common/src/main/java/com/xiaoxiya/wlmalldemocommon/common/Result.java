package com.xiaoxiya.wlmalldemocommon.common;

/**
 * @author luopeng
 * @date 2019/8/8 17:40
 * 通用返回结果对象
 */
public class Result<T> {
    /**
     * 状态 true代表成功 false代表失败
     */
    private boolean status;
    /**
     * 结果代码
     */
    private Integer code;
    /**
     * 返回信息
     */
    private String message;
    /**
     * 返回数据
     */
    private T data;

    public static <T> Result<T> success(Integer code, String message, Object data){
        return new Result<T>(true,code,message, (T) data);
    }

    public static Result success(String message, Object data){
        return success(0,message,data);
    }

    public static <T> Result<T> success(Object data){
        return success(0,"成功",data);
    }

    public static Result success(){
        return success(0,"成功",null);
    }

    public static Result error(Integer code, String message){
        return new Result(false,code,message,null);
    }
    public static Result error(String message){
        return new Result(false,-1,message,null);
    }

    public static Result error(){
        return new Result(false,-1,"失败",null);
    }
    /**
     * 未登录返回结果
     */
    public static <T> Result<T> unauthorized(T data) {
        return new Result<T>(false,-1, "暂未登录或token已经过期", data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> Result<T> forbidden(T data) {
        return new Result<T>(false,-1,"没有相关权限",data);
    }

    public static <T> Result<T> validateFailed(String s) {
        return new Result<T>(false,-1, s, null);
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result() {
    }

    public Result(boolean status, Integer code, String message, T data) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
