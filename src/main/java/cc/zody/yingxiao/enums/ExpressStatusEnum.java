package cc.zody.yingxiao.enums;

/**
 * 发货状态
 *
 * @author liumin
 * @since 2018-02-28
 */
public enum ExpressStatusEnum {
    NO_NEED(0, "不需要发货"),
    READY(1, "等待发货"),
    ING(2, "已经发货"),
    OK(3, "确认收获");

    private Integer code;
    private String desc;

    public Integer code() {
        return code;
    }

    public String desc() {
        return desc;
    }

    ExpressStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
