package cc.zody.yingxiao.mapper;

import cc.zody.yingxiao.dataobject.IndexImg;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 首页轮播对象
 * @author liumin
 * @since  2019-03-08
 */
@Mapper
public interface IndexImgMapper {

    Integer insertIndexImg(IndexImg indexImg)throws Exception;

    Integer delIndexImg(IndexImg indexImg)throws Exception;

    List<IndexImg> queryAllIndexImg()throws Exception;
}
