package cc.zody.yingxiao.dataobject;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 首页轮播图片对象
 *
 * @author liumin
 * @since 2019-02-26
 */
@Data
public class IndexImg implements Serializable {

    private static final long serialVersionUID = 5605907073492794682L;

    /**
     * 主键id
     */
    public Integer id;

    /**
     * 图片标题
     */
    public String title;

    /**
     * 图片地址
     */
    public String picUrl;

    /**
     *跳转链接
     */
    public String hrefUrl;


    /**
     * 创建时间
     */
    public Date gmtCreate;

    /**
     * 修改时间
     */
    public Date gmtModified;






}
