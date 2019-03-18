package cc.zody.yingxiao.service;

import cc.zody.yingxiao.dataobject.UserLevel;
import cc.zody.yingxiao.mapper.UserLevelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author liumin
 * @since  2019-03-08
 */
@Service
public class UserLevelService {

    /**
     * 所有的级别信息
     */
    public static Map<Integer, String> all_level_info = new HashMap<>();

    @Autowired
    UserLevelMapper userLevelMapper;


    public List<UserLevel> queryAllLevel(){
        return userLevelMapper.selectAllUserLevel();
    }

}
