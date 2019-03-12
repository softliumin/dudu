package cc.zody.yingxiao.dataobject;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 闯关记录
 *
 * @author liumin
 * @since 2019-02-28
 */
@Data
public class Pass implements Serializable {

    private static final long serialVersionUID = -5642319215027446534L;

    public Integer id;


    /**
     * 闯关人id
     */
    public String passOwner;


    /**
     * 审核状态
     */
    public Integer status;


    //==================商家信息begin==================================
    /**
     * 审核人名称
     */
    public String passName;

    /**
     * 审核人手机号
     */
    public String passTel;

    /**
     * 备用手机号
     */
    public String passTel2;

    /**
     * 审核人微信号
     */
    public String passWeChat;
    //===================商家信息end=================================





    //==================发货信息begin=============================
    /**
     * 发货方式
     */
    public String  expressType;

    /**
     * 发货状态
     */
    public String  expressStatus;

    /**
     * 收货地址
     */
    public String  receiverAddress;
    /**
     *收件人
     */
    public String  receiverName;
    /**
     *收件人手机号
     */
    public String  receiverTel;
    /**
     * 发货凭证
     */
    public String  expressPic;



    //==================发货信息end=============================

    /**
     * 创建时间
     */
    public Date gmtCreate;

    /**
     * 修改时间
     */
    public Date gmtModified;

}
