package cc.zody.yingxiao.dataobject;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 后台管理员
 * @author liumin
 * @since 2019-02-26
 */
@Data
public class Admin implements Serializable {
    private static final long serialVersionUID = -5888219431939232358L;

    public Integer id;

    public String username;

    public String password;

    public String telNum;



    /**
     * 创建时间
     */
    public Date gmtCreate;

    /**
     * 修改时间
     */
    public Date gmtModified;
}
