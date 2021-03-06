package cc.zody.yingxiao.mapper;

import cc.zody.yingxiao.dataobject.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *公告相关操作
 */
@Mapper
public interface NoticeMapper {

    List<Notice> selectAllNotice();

    Integer insertNotice(Notice notice);

    Integer delNotice(Notice notice);

    Integer updateNotice(Notice notice);


}
