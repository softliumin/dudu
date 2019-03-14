package cc.zody.yingxiao.model;

import cc.zody.yingxiao.dataobject.UserLevel;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户模型
 * @author liumin
 * @since  2019-03-08
 */
@Data
public class UserVO  implements Serializable {


    private static final long serialVersionUID = -526131490921396844L;


    public Integer id;

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
     * 推荐人昵称
     */
    public String referrerName;

    /**
     * 用户级别
     *
     * @see UserLevel
     */
    public Integer level;


    /**
     * 用户级别名称
     */
    public String levelName;


    /**
     * 创建时间
     */
    public String gmtCreate;

    /**
     * 修改时间
     */
    public String gmtModified;


}
