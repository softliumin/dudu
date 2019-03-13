package cc.zody.yingxiao.model;

import cc.zody.yingxiao.enums.DdResultCodeEnum;

import java.io.Serializable;

/**
 * 系统的结果包装类
 * @author liumin
 * @since 2018-02-28
 */
public class DdResult<T> implements Serializable {

    private static final long serialVersionUID = 3208898783205656272L;

    private Integer code;
    private String message;
    private Throwable throwable;
    private T data;

    private DdResult() {
    }

    public boolean is(DdResultCodeEnum e) {
        return (code != null && code.equals(e.code()));
    }

    public static DdResult getResult(DdResultCodeEnum resultCodeEnum) {
        return getResult(resultCodeEnum.code(), resultCodeEnum.msg(), null, null);
    }
    private static <T> DdResult getResult(Integer code, String message, T data, Throwable t) {
        DdResult result = new DdResult();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        result.setThrowable(t);
        return result;
    }

    public static DdResult getFailureResult(Integer failureCode, String failureMessage) {
        return getResult(failureCode, failureMessage, null, null);
    }


    public static DdResult getSuccessResult() {
        return getResult(DdResultCodeEnum.SUCCESS);
    }

    public boolean success() {
        return is(DdResultCodeEnum.SUCCESS);
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

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
