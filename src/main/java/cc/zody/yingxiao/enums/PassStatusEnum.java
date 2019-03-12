package cc.zody.yingxiao.enums;

/**
 * 用户升级审核状态
 * @author liumin
 * @since 2018-02-28
 */
public enum PassStatusEnum {

    READY(1, "等待审核"),
    OK(2, "审核通过"),
    NOT_OK(3, "审核不通过");

    private Integer code;
    private String desc;

    public Integer code() {
        return code;
    }

    public String desc() {
        return desc;
    }

    PassStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
