package cc.zody.yingxiao.dataobject;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户建议
 *
 * @author liumin
 * @since 2019-03-12
 */
@Data
public class Suggest implements Serializable {

    private static final long serialVersionUID = -1736697486224238898L;

    public Integer id;

    /**
     * 提出者uid
     */
    public Integer userId;


    /**
     * 提出者手机号
     */
    public String userTel;

    /**
     * 建议标题
     */
    public String title;

    /**
     * 建议内容
     */
    public String content;

    /**
     * 建议的附属图片
     */
    public String picUrl;

    /**
     * 创建时间
     */
    public Date gmtCreate;

    /**
     * 修改时间
     */
    public Date gmtModified;



}
