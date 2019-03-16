package cc.zody.yingxiao.model;

import lombok.Data;

import java.io.Serializable;

/**
 *
 */
@Data
public class OrderVO implements Serializable {


    private static final long serialVersionUID = 7787802020223577055L;

    public Integer passUserId;



    /**
     * 头像
     */
    public String passUserImg;

    /**
     *
     */
    public String passLevel;


    public String passUsername;

    public String passTelNum;

    public String aliPay;

    public String weChat;

    /**
     * 创建时间
     */
    public String gmtCreate;

    /**
     * 修改时间
     */
    public String gmtModified;





}
