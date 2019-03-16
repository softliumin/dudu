package cc.zody.yingxiao.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户闯关模型
 *
 * @author liumin
 * @since 2019-03-13
 */
@Data
public class PassVO implements Serializable {

    /**
     * 申请人
     */
    public Integer userId;

    /**
     * 审核商户人1
     */
    public Integer passUser1;

    public Integer address1;

    public Integer expressType1;

    /**
     * 审核商户人2
     */
    public Integer passUser2;

    /**
     * 地址id
     */
    public Integer address2;
    /**
     * 发货方式
     */
    public Integer expressType2;



}
