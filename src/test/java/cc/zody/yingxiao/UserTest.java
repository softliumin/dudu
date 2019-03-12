package cc.zody.yingxiao;

import cc.zody.yingxiao.mapper.UserMapper;
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
public class UserTest {

    @Autowired
    UserMapper userMapper;


    @Test
    public void testInsertUser(){

    }

    @Test
    public void testLogin(){

    }

    @Test
    public void testUpdateUser(){

    }


    /**
     * 为他人注册
     * 手机号 验证码 登录密码 确认密码 昵称 微信号码 支付宝号码
     *
     *
     *
     *
     */


    /**
     * 实名验证
     *
     * 姓名 身份证号码   两张图片
     */

    /**
     * 地址管理（编辑删除）
     *
     * 收货人
     * 手机号码
     * 省市区（要有自己的数据库）
     * 详细地址
     *
     */

    /**
     * 首页轮播图案
     */


    /**
     * 自己注册
     */





}
