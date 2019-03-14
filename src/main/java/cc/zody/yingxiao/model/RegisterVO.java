package cc.zody.yingxiao.model;

import cc.zody.yingxiao.dataobject.UserLevel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户注册模型
 *
 * @author liumin
 * @since 2019-03-13
 */
@Data
public class RegisterVO implements Serializable {


    private static final long serialVersionUID = -2467163230605868532L;

    public String telNum;

    public String weChat;

    public String aliPay;

    public String username;
    /**
     * 头像地址
     */
    public String picUrl;


    public String password;

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



}
