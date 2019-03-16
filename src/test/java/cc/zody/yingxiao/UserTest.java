package cc.zody.yingxiao;

import cc.zody.yingxiao.dataobject.User;
import cc.zody.yingxiao.mapper.UserMapper;
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
public class UserTest {

    @Autowired
    UserMapper userMapper;


    @Test
    public void testInsertUser() {
        for (int x=10;x<14;x++){
            User user = new User();
            user.setTelNum("150217770"+x);
            user.setPassword("e10adc3949ba59abbe56e057f20f883e");
            user.setUsername("柳敏"+x);
            user.setWeChat("150217770"+x);
            user.setAliPay("150217770"+x);
            user.setReferrerId(9);
            user.setLevel(x);
            Integer result = userMapper.insertUser(user);
            System.out.println(result);
        }

    }

    @Test
    public void testLogin() {
        User user = userMapper.selectForLogin("11111");
        System.out.println(JSON.toJSON(user));
    }

    @Test
    public void testUpdateUserLevel() {
        User user = new User();
        user.setId(2);
        user.setLevel(2);
        Integer result = userMapper.updateUserLevel(user);
        System.out.println(result);

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
