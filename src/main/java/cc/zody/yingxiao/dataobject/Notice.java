package cc.zody.yingxiao.dataobject;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 通知
 * @author liumin
 * @since 2019-02-26
 */
@Data
public class Notice implements Serializable {


    private static final long serialVersionUID = 1247433624239148600L;

    public Integer id;

    /**
     * 通知标题
     */
    public String title;

    /**
     * 通知主图
     */
    public String mainPic;

    /**
     * 通知内容
     */
    public String content;


    /**
     * 创建时间
     */
    public Date gmtCreate;

    /**
     * 修改时间
     */
    public Date gmtModified;

}
