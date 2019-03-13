package cc.zody.yingxiao.mapper;

import cc.zody.yingxiao.dataobject.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 管理员dao
 * @author liumin
 * @since 2019-03-08
 */
@Mapper
public interface AdminMapper {

    Admin selectOneAdmin(String telNum);

    List<Admin> selectAllAdmin();

    Integer inertAdmin(Admin admin);

    Integer delAdmin(Admin admin);

}
