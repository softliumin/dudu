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

    List<User> selectAllUser();

    User selectForLogin( @Param("telNum")String telNum);

    Integer updateUserLevel(User user);

}
