package cc.zody.yingxiao.service;

import cc.zody.yingxiao.dataobject.IndexImg;
import cc.zody.yingxiao.mapper.IndexImgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class IndexImgService {

    @Autowired
    IndexImgMapper indexImgMapper;


    public List<IndexImg> queryAllIndexImg() throws Exception{
        return indexImgMapper.queryAllIndexImg();
    }
}
