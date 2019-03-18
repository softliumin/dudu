package cc.zody.yingxiao.mapper;

import cc.zody.yingxiao.dataobject.Pass;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 闯关的相关操作
 * @author liumin
 * @since  2019-03-08
 */
@Mapper
public interface PassMapper {

    Integer insertPass(Pass pss);

    List<Pass> listByUser(Pass pss);
    List<Pass> listByPassUserId(Integer  id);

    List<Pass> listByLevel(Pass pss);

    Pass listById(Integer id);


    Integer updatePassStatus(Pass pss);

}
