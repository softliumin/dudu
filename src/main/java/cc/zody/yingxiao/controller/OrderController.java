package cc.zody.yingxiao.controller;

import cc.zody.yingxiao.dataobject.Pass;
import cc.zody.yingxiao.dataobject.User;
import cc.zody.yingxiao.model.OrderVO;
import cc.zody.yingxiao.model.PassVO;
import cc.zody.yingxiao.service.PassService;
import cc.zody.yingxiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * 闯关记录
 *
 * @author liumin
 * @since 2019-02-26
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    PassService passService;

    @Autowired
    UserService userService;

    @RequestMapping("/order_list")
    public String orderList(HttpServletRequest request, Model model) {
        try {
            User user = getUserFromCookie(request);
            Pass pass = new Pass();
            pass.setUserId(user.getId());
            List<Pass> list = passService.listByUser(pass);
            List<OrderVO> passVOList = new ArrayList<>();
            for (Pass ss : list) {
                OrderVO vo = new OrderVO();
                User passer = userService.findUserById(ss.getPassUserId());
                vo.setPassUserId(pass.getPassUserId());
                vo.setPassTelNum(passer.getTelNum());
                vo.setWeChat("微信号："+passer.getWeChat());
                vo.setAliPay("支付宝号："+passer.getAliPay());
                vo.setPassLevel("闯关等级：第"+ss.getLevelNum()+"关");
                vo.setGmtCreate(dateToStr(ss.gmtCreate));
                passVOList.add(vo);
            }

            model.addAttribute("orderList", passVOList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/user/order_list";
    }


    /**
     * 解析异常
     *
     * @param request
     * @return
     */
    public User getUserFromCookie(HttpServletRequest request) {
        try {
            if (null == request || null == request.getCookies()) {
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
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public String dateToStr(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }


}
