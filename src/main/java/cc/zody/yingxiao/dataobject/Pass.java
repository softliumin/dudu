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
    public Integer userId;

    /**
     * 闯关人id
     */
    public Integer passUserId;

    /**
     * 创第几关
     */
    public Integer levelNum;


    /**
     * 审核状态
     */
    public Integer passStatus;


    /**
     * 发货方式
     */
    public Integer  expressType;

    /**
     * 发货状态
     */
    public Integer  expressStatus;




    /**
     * 创建时间
     */
    public Date gmtCreate;

    /**
     * 修改时间
     */
    public Date gmtModified;

}
