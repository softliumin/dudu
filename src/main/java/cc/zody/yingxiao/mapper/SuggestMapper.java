package cc.zody.yingxiao.mapper;

import cc.zody.yingxiao.dataobject.Suggest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 建议
 * @author liumin
 * @since  2019-03-08
 */
@Mapper
public interface SuggestMapper {

    Integer insertSuggest(Suggest suggest);

    Integer delSuggest(Suggest suggest);

    List<Suggest> querySuggest(Suggest suggest);

}
