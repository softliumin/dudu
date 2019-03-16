package cc.zody.yingxiao.enums;

/**
 * 物流方式
 *
 * @author liumin
 * @since 2018-02-28
 */
public enum ExpressTypeEnum {
    NO_Express(0, "自提"),
    Express(1, "快递");


    private Integer code;
    private String desc;

    public Integer code() {
        return code;
    }

    public String desc() {
        return desc;
    }

    ExpressTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
