package cc.zody.yingxiao.service;

import cc.zody.yingxiao.dataobject.User;
import cc.zody.yingxiao.mapper.UserMapper;
import cc.zody.yingxiao.model.RegisterVO;
import cc.zody.yingxiao.util.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author liumin
 * @since 2019-03-08
 */
@Service
public class UserService {



    @Autowired
    UserMapper userMapper;

    /**
     * 检查登录
     *
     * @param username
     * @param password
     * @return null表示用户不存在，false表示密码不对，true表示登录ok
     */
    public Boolean login(String username, String password) {
        password = EncryptUtil.md5(password);
        User user = userMapper.selectForLogin(username);
        if (null == user) {
            return null;
        } else {
            if (user.getPassword().equals(password)) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * 根据手机号码查找
     * @param telNum
     * @return
     */
    public User findUserByTelNum(String telNum) {
        return  userMapper.selectForLogin(telNum);
    }
    /**
     * 根据uid查找
     * @param
     * @return
     */
    public User findUserById(Integer id) {
        return  userMapper.selectById(id);
    }

    /**
     * 根据推荐人查找
     * @param
     * @return
     */
    public List<User> findUserByReferrerId(Integer id) {
        return  userMapper.findUserByReferrerId(id);
    }



    public Integer updateWeChat(Integer id,String weChat){

        return userMapper.updateWeChat(id, weChat);
    }

    // 升1级
    public Integer upLevel(Integer uid){

        return userMapper.upLevel(uid);
    }

    public Integer updateAliPay(Integer id,String aliPay){

        return userMapper.updateAliPay(id, aliPay);
    }


    /**
     * 注册用户
     *
     * @param registerVO
     * @return
     */
    public Boolean register(RegisterVO registerVO) {
        try {
            User user = new User();
            user.setLevel(0);
            user.setReferrerId(registerVO.getReferrerId());
            user.setAliPay(registerVO.getAliPay());
            user.setWeChat(registerVO.getWeChat());
            if (StringUtils.isEmpty(registerVO.getUsername())){
                user.setUsername(registerVO.getTelNum());
            }else{
                user.setUsername(registerVO.getUsername());
            }
            user.setPassword(EncryptUtil.md5(registerVO.getPassword()));
            user.setTelNum(registerVO.getTelNum());
            int dbResult = userMapper.insertUser(user);
            if (dbResult==1){
                return  true;
            }else{
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public static void main(String[] args) {
        System.out.println(EncryptUtil.md5("123456"));
    }

}
