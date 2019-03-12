package cc.zody.yingxiao.controller;

import cc.zody.yingxiao.model.RegisterVO;
import cc.zody.yingxiao.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @author liumin
 * @since 2019-02-26
 */
@Controller
@RequestMapping("/user")
public class UserController {

    Logger log = LoggerFactory.getLogger(this.getClass());


    @Autowired
    UserService userService;

    /**
     * 用户登录首页
     */
    @RequestMapping("/index")
    public String index() {
        try {


        } catch (Exception e) {
            e.printStackTrace();
        }
        return "user/index";
    }

    /**
     * 进行登录
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/login")
    public String login(String username, String password, HttpServletResponse httpResponse) {
        try {
            log.error("login");
            Boolean result = userService.login(username, password);
            if (result== true){
                //
                Cookie cookie = new Cookie("ticket",username);
                cookie.setPath("/");
                httpResponse.addCookie(cookie);
            }else{

            }
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 用户注册
     */
    @RequestMapping("/register")
    public String register(RegisterVO registerVO) {
        try {
            Boolean result = userService.register(registerVO);
            if (result){
                // TODO 登录cookie

                return "user/index";
            }else{

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "user/register";
    }
}





/**
 * 一些操作记录
 *
 *
 *
 */


//mysql -h 47.75.197.99 -P 3306 -u root -p

//scp -P 22 /Users/hengzhen/Desktop/yingxiao-0.0.1-SNAPSHOT.jar root@47.75.197.99:/code/
//
//java -jar yingxiao-0.0.1-SNAPSHOT.jar

//http://localhost/static/img/theme/login_pwd.png
//http://localhost/static/img/theme/btn_banner.png
