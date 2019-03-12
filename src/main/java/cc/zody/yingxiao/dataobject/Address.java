package cc.zody.yingxiao.dataobject;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户收获地址
 *
 * @author liumin
 * @since 2019-03-12
 */
@Data
public class Address implements Serializable {

    private static final long serialVersionUID = 2687592326626198738L;

    /**
     * 地址管理（编辑删除）
     * <p>
     * 收货人
     * 手机号码
     * 省市区（要有自己的数据库）
     * 详细地址
     */

    public Integer id;

    /**
     * 地址拥有人id
     */
    public Integer userId;
    /**
     * 收货人
     */
    public String name;

    /**
     * 手机号码
     */
    public String telNum;

    /**
     * 省市区（TODO）
     */
    public String mainAddress;

    /**
     * 具体地址
     */
    public String detailAddress;


    /**
     * 创建时间
     */
    public Date gmtCreate;

    /**
     * 修改时间
     */
    public Date gmtModified;


}
