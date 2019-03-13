package cc.zody.yingxiao.service;

import cc.zody.yingxiao.dataobject.Admin;
import cc.zody.yingxiao.dataobject.User;
import cc.zody.yingxiao.mapper.AdminMapper;
import cc.zody.yingxiao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author liumin
 * @since  2019-03-08
 */
@Service
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据手机号码登录
     * @param telNum
     * @param password
     * @return
     */
    public Boolean login(String telNum,String password) {
        Admin dbAdmin = adminMapper.selectOneAdmin(telNum);
        if (null == dbAdmin){
            return null;
        }else{
            if (dbAdmin.getPassword().equals(password)){
                return true;
            }else{
                return  false;
            }
        }
    }

    public List<User> queryUserForPage(){
        User user = new User();
        return userMapper.selectUserForPage(user);
    }


    public List<User> queryAllUser(){
        return userMapper.selectAllUser();
    }




}

