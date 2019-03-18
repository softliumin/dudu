package cc.zody.yingxiao.controller;

import cc.zody.yingxiao.dataobject.UserLevel;
import cc.zody.yingxiao.mapper.UserLevelMapper;
import cc.zody.yingxiao.service.UserLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 *
 * @author liumin
 * @since 2019-03-18
 */
@Component
public class InitLevelInfo implements CommandLineRunner {


    @Autowired
    UserLevelMapper userLevelMapper;

    @Override
    public void run(String... args) throws Exception {
        List<UserLevel> levels = userLevelMapper.selectAllUserLevel();
        if (!CollectionUtils.isEmpty(levels)){
            levels.stream().forEach(le->
                UserLevelService.all_level_info.put(le.getLevelNum(),le.getLevelName())
            );
        }

    }
}
