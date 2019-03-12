package cc.zody.yingxiao.mapper;

import cc.zody.yingxiao.dataobject.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 关于公告的dao层操作
 * @author liumin
 * @since  2019-03-08
 */
@Mapper
public interface UserMapper {

    Integer insertUser(User user);

    List<User> selectUserForPage(User user);

    User selectForLogin( @Param("username")String username);

    Integer updateUser(User user);

}
