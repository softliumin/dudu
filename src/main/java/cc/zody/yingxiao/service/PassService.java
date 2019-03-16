package cc.zody.yingxiao.service;

import cc.zody.yingxiao.dataobject.Pass;
import cc.zody.yingxiao.mapper.PassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 闯关的相关操作
 * @author liumin
 * @since 2019-03-08
 */
@Service
public class PassService {

    @Autowired
    PassMapper passMapper;


    public Integer insert(Pass pass) {
        return passMapper.insertPass(pass);
    }


    public List<Pass> listByLevel(Pass pass) {
        return passMapper.listByLevel(pass);
    }


    public List<Pass> listByUser(Pass pass) {
        return passMapper.listByUser(pass);
    }


    public Integer updatePassStatus(Pass pass) {
        return passMapper.updatePassStatus(pass);
    }

}
