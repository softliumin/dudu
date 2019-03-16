package cc.zody.yingxiao.dataobject;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户级别
 * @author liumin
 * @since 2019-02-26
 */
@Data
public class UserLevel implements Serializable {

    private static final long serialVersionUID = -5888219431939232358L;

    public Integer id;

    /**
     * 创建时间
     */
    public Date gmtCreate;

    /**
     * 修改时间
     */
    public Date gmtModified;

    public Integer levelNum;

    public String levelName;

}
