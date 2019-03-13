package cc.zody.yingxiao.service;

import cc.zody.yingxiao.dataobject.UserLevel;
import cc.zody.yingxiao.mapper.UserLevelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author liumin
 * @since  2019-03-08
 */
@Service
public class UserLevelService {

    @Autowired
    UserLevelMapper userLevelMapper;


    public List<UserLevel> queryAllLevel(){
        return userLevelMapper.selectAllUserLevel();
    }

}
