package cc.zody.yingxiao.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

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

    /**
     * 级别
     */
    public Integer user1Level;

    /**
     * 级别
     */
    public String user1LevelName;

    public Integer address1;

    public Integer expressType1;

    public String telNum1;

    public String aliPay1;
    public String weChat1;


    /**
     * 审核商户人2
     */
    public Integer passUser2;

    /**
     * 级别
     */
    public Integer user2Level;

    /**
     * 级别
     */
    public String user2LevelName;

    /**
     * 地址id
     */
    public Integer address2;
    /**
     * 发货方式
     */
    public Integer expressType2;

    public String aliPay2;
    public String weChat2;
    public String telNum2;

    /**
     * 创建时间
     */
    public Date gmtCreate;

    /**
     * 修改时间
     */
    public Date gmtModified;




}
