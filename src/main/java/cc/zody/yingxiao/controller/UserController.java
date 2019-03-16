package cc.zody.yingxiao.controller;

import cc.zody.yingxiao.dataobject.Address;
import cc.zody.yingxiao.dataobject.User;
import cc.zody.yingxiao.dataobject.UserLevel;
import cc.zody.yingxiao.enums.DdResultCodeEnum;
import cc.zody.yingxiao.model.DdResult;
import cc.zody.yingxiao.model.RegisterVO;
import cc.zody.yingxiao.model.UserVO;
import cc.zody.yingxiao.service.AddressService;
import cc.zody.yingxiao.service.UserLevelService;
import cc.zody.yingxiao.service.UserService;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebParam;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author liumin
 * @since 2019-02-26
 */
@Controller
@RequestMapping("/user")
public class UserController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserLevelService userLevelService;

    @Autowired
    UserService userService;

    @Autowired
    AddressService addressService;

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
     * 用户主页
     */
    @RequestMapping("/home")
    public String home(HttpServletRequest request, Model model) {
        try {
            User user = getUserFromCookie(request);
            if (null==user){
                return "user/index";
            }
            Map<Integer, String> levelMap = new HashMap<>();
            List<UserLevel> userLevelList = userLevelService.queryAllLevel();
            if (!CollectionUtils.isEmpty(userLevelList)) {
                for (UserLevel level : userLevelList) {
                    levelMap.put(level.getLevelNum(), level.getLevelName());
                }
            }
            UserVO vo = new UserVO();
            vo.setId(user.getId());
            vo.setLevel(user.getLevel());
            vo.setUsername(user.getUsername());
            vo.setReferrerId(user.getReferrerId());

            vo.setReferrerName(userService.findUserById(user.getReferrerId()).username);
            vo.setLevelName(levelMap.get("" + user.getLevel() + ""));

            model.addAttribute("user", vo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "user/home";
    }


    /**
     * 进行登录
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public DdResult login(String username, String password, HttpServletResponse httpResponse) {
        DdResult<Boolean> result = DdResult.getSuccessResult();
        try {
            Boolean loginResult = userService.login(username, password);
            if (null != loginResult && loginResult == true) {
                Cookie cookie = new Cookie("dudu", username);
                cookie.setPath("/");
                httpResponse.addCookie(cookie);
            } else {
                if (null == loginResult) {
                    result = DdResult.getFailureResult(DdResultCodeEnum.UNKNOW_EXCEPTION.code(), "用户不存在");
                } else {
                    result = DdResult.getFailureResult(DdResultCodeEnum.UNKNOW_EXCEPTION.code(), "密码错误");
                }
            }
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
            result = DdResult.getFailureResult(DdResultCodeEnum.UNKNOW_EXCEPTION.code(), DdResultCodeEnum.UNKNOW_EXCEPTION.name());
        }
        return result;
    }


    /**
     * 帮助注册
     *
     * @param
     * @return
     */
    @RequestMapping("/helpRegister")
    public String helpRegister() {
        try {

        } catch (Exception e) {

        }
        return "user/helpRegister";
    }

    /**
     * 团队（行会）
     *
     * @param
     * @return
     */
    @RequestMapping("/myTeam")
    public String myTeam() {
        try {

        } catch (Exception e) {

        }
        return "user/myTeam";
    }

    /**
     * 审核闯关
     *
     * @param
     * @return
     */
    @RequestMapping("/collect")
    public String collect() {
        try {

        } catch (Exception e) {

        }
        return "user/collect";
    }


    /**
     * 申请闯关
     *
     * @param
     * @return
     */
    @RequestMapping("/updateLevel")
    public String updateLevel() {
        try {

        } catch (Exception e) {

        }
        return "user/updateLevel";
    }

    /**
     * 综合信用评分
     *
     * @return
     */
    @RequestMapping("/credit")
    public String credit() {
        try {

        } catch (Exception e) {

        }
        return "user/credit";
    }


    /**
     * 收货地址管理
     *
     * @param
     * @return
     */
    @RequestMapping("/address_list")
    public String addressList(HttpServletRequest request, Model model) {
        try {
            List<Address> list = addressService.queryAddressByUid(getUserFromCookie(request).getId());
            if (!CollectionUtils.isEmpty(list)) {
                model.addAttribute("addressList", list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "user/address_list";
    }

    /**
     * 投诉建议
     *
     * @return
     */
    @RequestMapping("/suggest")
    public String suggest() {
        try {

        } catch (Exception e) {

        }
        return "user/suggest";
    }


    /**
     * 用户信息页面
     *
     * @param registerVO
     * @return
     */
    @RequestMapping("/userDetail")
    public String userDetail(HttpServletRequest request, Model model) {
        try {
            User user = getUserFromCookie(request);
            if (null!= user){
                model.addAttribute("user", user);
                return  "user/index";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "user/userDetail";
    }

    /**
     * 增加地址
     *
     * @param
     * @return
     */
    @RequestMapping("/add_address")
    public String addAddress() {
        return "user/add_address";
    }

    /**
     * 编辑地址
     *
     * @param
     * @return
     */
    @RequestMapping("/edit_address/{id}")
    public String editAddress(@PathVariable Integer id,Model model) {
        try {
            Address address =  addressService.selectById(id);
            if (null!= address){
                model.addAttribute("address",address);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "user/edit_address";
    }


    /**
     * 用户注册
     */
    @RequestMapping("/register")
    public String register(RegisterVO registerVO) {
        try {
            Boolean result = userService.register(registerVO);
            if (result) {
                // TODO 登录cookie

                return "user/index";
            } else {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "user/register";
    }

    /**
     * 主手机号
     *
     * @param
     * @return
     */
    @RequestMapping("/setMainMobile")
    public String setMainMobile() {
        try {

        } catch (Exception e) {

        }
        return "user/setMainMobile";
    }

    /**
     * 备用手机号
     *
     * @param
     * @return
     */
    @RequestMapping("/setMobile2")
    public String setMobile2() {
        try {

        } catch (Exception e) {

        }
        return "user/setMobile2";
    }


    @RequestMapping("/bindAliPay")
    public String bindAliPay(HttpServletRequest request, Model model) {
        try {
            User user = getUserFromCookie(request);
            if (null != user) {
                model.addAttribute("aliPay", user.getAliPay());
            }
        } catch (Exception e) {

        }
        return "user/bindAliPay";
    }

    @ResponseBody
    @RequestMapping("/ajax/bindAliPay")
    public DdResult ajaxBindAliPay(HttpServletRequest request, String al_account) {
        DdResult<Boolean> result = DdResult.getSuccessResult();
        try {
            userService.updateAliPay(getUserFromCookie(request).getId(), al_account);
        } catch (Exception e) {
            e.printStackTrace();
            result = DdResult.getFailureResult(DdResultCodeEnum.UNKNOW_EXCEPTION.code(), DdResultCodeEnum.UNKNOW_EXCEPTION.name());
        }
        return result;
    }

    @RequestMapping("/bindWeChat")
    public String bindWeChat(HttpServletRequest request, Model model) {
        try {
            User user = getUserFromCookie(request);
            if (null != user) {
                model.addAttribute("weChat", user.getWeChat());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "user/bindWeChat";
    }

    /**
     * 修改绑定微信号码
     *
     * @param request
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping("/ajax/bindWeChat")
    public DdResult ajaxBindWeChat(HttpServletRequest request, String newWeChat) {
        DdResult<Boolean> result = DdResult.getSuccessResult();
        try {
            userService.updateWeChat(getUserFromCookie(request).getId(), newWeChat);
        } catch (Exception e) {
            e.printStackTrace();
            result = DdResult.getFailureResult(DdResultCodeEnum.UNKNOW_EXCEPTION.code(), DdResultCodeEnum.UNKNOW_EXCEPTION.name());
        }
        return result;
    }


    @RequestMapping("/realName")
    public String realName() {
        try {

        } catch (Exception e) {

        }
        return "user/realName";
    }


    @RequestMapping("/setPassword")
    public String setPassword() {
        try {

        } catch (Exception e) {

        }
        return "user/setPassword";
    }

    /**
     * 帮助注册
     *
     * @param
     * @return
     */
    @RequestMapping("/ajax/helpRegister")
    @ResponseBody
    public DdResult ajaxHelpRegister(HttpServletRequest request, RegisterVO user) {
        DdResult<Boolean> result = DdResult.getSuccessResult();
        try {
            List<Cookie> list = Arrays.asList(request.getCookies());
            Optional<Cookie> optionalCookie = list.stream().filter(co -> co.getName().equals("dudu")).findFirst();
            if (optionalCookie.isPresent()) {
                user.setReferrerId(Integer.parseInt(optionalCookie.get().getValue()));
            }

            Boolean dbResult = userService.register(user);
            if (!dbResult) {
                result = DdResult.getFailureResult(DdResultCodeEnum.UNKNOW_EXCEPTION.code(), "注册失败!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = DdResult.getFailureResult(DdResultCodeEnum.UNKNOW_EXCEPTION.code(), DdResultCodeEnum.UNKNOW_EXCEPTION.name());
        }
        return result;
    }


    @RequestMapping("self_reg")
    public String self_reg() {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "user/self_reg";
    }

    /**
     * 解析异常
     * @param request
     * @return
     */
    public User getUserFromCookie(HttpServletRequest request) {
        try {
            if (null == request || null == request.getCookies()){
                return null;
            }
            List<Cookie> list = Arrays.asList(request.getCookies());
            Optional<Cookie> optionalCookie = list.stream().filter(co -> co.getName().equals("dudu")).findFirst();
            if (optionalCookie.isPresent()) {
                User user = userService.findUserByTelNum(optionalCookie.get().getValue());
                return user;
            } else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}


/**
 * 一些操作记录
 * <p>
 * sudo systemctl start mariadb
 * systemctl stop mariadb
 * <p>
 * sudo systemctl start mariadb
 * systemctl stop mariadb
 */


//mysql -h 47.75.197.99 -P 3306 -u root -p

//scp -P 22 /Users/hengzhen/Desktop/yingxiao-0.0.1-SNAPSHOT.jar root@47.75.197.99:/code/
//scp -P 22 /Users/hengzhen/IdeaProjects/yingxiao/target/yingxiao-0.0.1-SNAPSHOT.jar root@47.75.197.99:/code/
//
//java -jar yingxiao-0.0.1-SNAPSHOT.jar

//http://localhost/static/img/theme/login_pwd.png
//http://localhost/static/img/theme/btn_banner.png
/**
 * sudo systemctl start mariadb
 * systemctl stop mariadb
 *
 */



