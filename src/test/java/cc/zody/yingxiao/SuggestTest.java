package cc.zody.yingxiao;

import cc.zody.yingxiao.dataobject.Suggest;
import cc.zody.yingxiao.mapper.SuggestMapper;
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
public class SuggestTest {

    @Autowired
    SuggestMapper suggestMapper;

    @Test
    public  void testAdd(){
        for(int x=0;x<100;x++){
            Suggest suggest = new Suggest();
            suggest.setTitle("ttt");
            suggest.setContent("cccc");
            suggest.setPicUrl("url");

            suggest.setUserId(1);
            suggest.setUserTel("12233");

            Integer result = suggestMapper.insertSuggest(suggest);
            System.out.println("=================:"+result);
        }
    }

    @Test
    public  void testSelectAll(){
        System.out.println("=================:"+JSON.toJSON(suggestMapper.querySuggest()));
    }


    @Test
    public  void testDel(){
        Suggest suggest = new Suggest();
        suggest.setId(1);
        Integer result =suggestMapper.delSuggest(suggest);
        System.out.println("=================:"+result);

    }



}
