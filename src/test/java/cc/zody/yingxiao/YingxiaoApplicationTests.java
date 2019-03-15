package cc.zody.yingxiao;

import cc.zody.yingxiao.dataobject.Admin;
import cc.zody.yingxiao.dataobject.Notice;
import cc.zody.yingxiao.dataobject.UserLevel;
import cc.zody.yingxiao.mapper.AdminMapper;
import cc.zody.yingxiao.mapper.NoticeMapper;
import cc.zody.yingxiao.mapper.UserLevelMapper;
import com.alibaba.fastjson.JSON;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class YingxiaoApplicationTests {

    @Autowired
    NoticeMapper noticeMapper;

    @Autowired
    UserLevelMapper userLevelMapper;

    @Autowired
    AdminMapper adminMapper;

    @Ignore
    @Test
    public void  testNoticeAdd(){
        Notice notice = new Notice();
        notice.setContent("test");
        notice.setTitle("tt");
        notice.setMainPic("33333");
        Integer result = noticeMapper.insertNotice(notice);
        System.out.println(result);
    }

    @Test
    @Ignore
    public void  testNoticeUpdate(){
        Notice notice = new Notice();
        notice.setId(2);
        notice.setTitle("update");
        Integer result = noticeMapper.updateNotice(notice);
        System.out.println("===================="+result);
    }

    @Ignore
    @Test
    public void testNotice() {
        List<Notice> list =  noticeMapper.selectAllNotice();
        System.out.println( "===================="+JSON.toJSON(list));
    }

    @Ignore
    @Test
    public void  testNoticeDel(){
        Notice notice = new Notice();
        notice.setId(1);
        Integer result = noticeMapper.delNotice(notice);
        System.out.println("===================="+result);
    }

    @Test
//    @Ignore
    public void  testUserLevelAdd(){
        UserLevel userLevel = new UserLevel();
        userLevel.setLevelName("傻逼");
        userLevel.setLevelNum("1");
        Integer result = userLevelMapper.insertUserLevel(userLevel);
        System.out.println("===================="+result);
    }


    @Test
    public void testUserLevelSelect(){
        List<UserLevel> list = userLevelMapper.selectAllUserLevel();
        System.out.println( "===================="+JSON.toJSON(list));

    }

    @Ignore
    @Test
    public void testUserLevelUpdate(){
        UserLevel userLevel = new UserLevel();
        userLevel.setId(1);
        userLevel.setLevelName("first");
        userLevel.setLevelNum("11111");
        Integer result = userLevelMapper.updateUserLevel(userLevel);
        System.out.println("===================="+result);
    }

    @Ignore
    @Test
    public void testUserLevelDel(){
        UserLevel userLevel = new UserLevel();

        userLevel.setId(1);
        Integer result = userLevelMapper.delUserLevel(userLevel);
        System.out.println("===================="+result);
    }


    //====================== Admin begin====================================
    @Test
    @Ignore
    public void testAdminAdd(){
        Admin admin = new Admin();
        admin.setUsername("wwew");
        admin.setPassword("wewe");
        admin.setTelNum("sfdsfsd");
        Integer result = adminMapper.inertAdmin(admin);
        System.out.println("===================="+result);
    }

    @Test
    @Ignore
    public void testAdminSelectAll(){
        List<Admin> list =  adminMapper.selectAllAdmin();
        System.out.println( "===================="+JSON.toJSON(list));

    }


    @Test
    @Ignore
    public void testAdminSelectOne(){

        Admin result = adminMapper.selectOneAdmin("123");
        System.out.println("===================="+result);
    }

    @Test
    @Ignore
    public void testAdminDel(){
        Admin admin = new Admin();
        admin.setId(2);
        Integer result = adminMapper.delAdmin(admin);
        System.out.println("===================="+result);

    }


}
