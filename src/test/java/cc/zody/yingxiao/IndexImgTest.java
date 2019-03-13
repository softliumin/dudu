package cc.zody.yingxiao;


import cc.zody.yingxiao.dataobject.IndexImg;
import cc.zody.yingxiao.mapper.IndexImgMapper;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liumin
 * @since 2019-03-12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IndexImgTest {


    @Autowired
    IndexImgMapper indexImgMapper;

    @Test
    public void testAdd() throws Exception{
        for(int x=0;x<10;x++){
            IndexImg indexImg = new IndexImg();
            indexImg.setTitle("ttt");
            indexImg.setHrefUrl("href");
            indexImg.setPicUrl("pic");
            Integer result = indexImgMapper.insertIndexImg(indexImg);
            System.out.println("=================:"+result);
        }

    }

    @Test
    public void testSelectAll()throws Exception{
        System.out.println(JSON.toJSON(indexImgMapper.queryAllIndexImg()));
    }


    @Test
    public void testDel()throws Exception{
        IndexImg indexImg = new IndexImg();
        indexImg.setId(1);
        Integer result = indexImgMapper.delIndexImg(indexImg);
        System.out.println("=================:"+result);
    }
}
