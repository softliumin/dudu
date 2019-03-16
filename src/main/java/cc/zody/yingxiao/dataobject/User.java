package cc.zody.yingxiao.dataobject;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 注册用户
 *
 * @author liumin
 * @since 2019-02-26
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = -5888219431939232358L;

    public Integer id;

    public String telNum;

    /**
     * 备用手机号
     */
    public String telNum2;

    public String weChat;

    public String aliPay;

    public String username;
    /**
     * 头像地址
     */
    public String picUrl;


    public String password;

    /**
     * 原密码
     */
    public String pwd;

    /**
     * 推荐人(uid)
     */
    public Integer referrerId;

    /**
     * 用户级别
     *
     * @see UserLevel
     */
    public Integer level;


    /**
     * 创建时间
     */
    public Date gmtCreate;

    /**
     * 修改时间
     */
    public Date gmtModified;

}
