package cc.zody.yingxiao.service;

import cc.zody.yingxiao.dataobject.IndexImg;
import cc.zody.yingxiao.mapper.IndexImgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 首页轮播相关操作
 */
@Service
public class IndexImgService {

    @Autowired
    IndexImgMapper indexImgMapper;


    public List<IndexImg> queryAllIndexImg() throws Exception{
        return indexImgMapper.queryAllIndexImg();
    }


    public Integer insertIndexImg(IndexImg indexImg)throws Exception{
        return indexImgMapper.insertIndexImg(indexImg);
    }

    public Integer delIndexImg(IndexImg indexImg)throws Exception{
        return indexImgMapper.delIndexImg(indexImg);
    }




}
