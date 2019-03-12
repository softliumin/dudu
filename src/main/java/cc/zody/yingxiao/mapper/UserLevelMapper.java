package cc.zody.yingxiao.mapper;

import cc.zody.yingxiao.dataobject.UserLevel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *
 * @author liumin
 * @since  2019-03-08
 */
@Mapper
public interface UserLevelMapper {
    List<UserLevel> selectAllUserLevel();
    Integer insertUserLevel(UserLevel userLevel);
    Integer updateUserLevel(UserLevel userLevel);

    Integer delUserLevel(UserLevel userLevel);

}
