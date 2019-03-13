package cc.zody.yingxiao.enums;

/**
 *
 * @author  liumin
 * @since  2019-03-13
 */
public enum  DdResultCodeEnum {
    SUCCESS(1, "成功"),
    UNKNOW_EXCEPTION(-1, "未知错误"),
    DB_ERROR_EXCEPTION(-2, "数据库错误"),;

    private Integer code;
    private String msg;

    DdResultCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer code() {
        return code;
    }

    public String msg() {
        return msg;
    }

}
