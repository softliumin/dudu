package cc.zody.yingxiao.controller;

import cc.zody.yingxiao.dataobject.Pass;
import cc.zody.yingxiao.dataobject.User;
import cc.zody.yingxiao.enums.DdResultCodeEnum;
import cc.zody.yingxiao.enums.PassStatusEnum;
import cc.zody.yingxiao.model.DdResult;
import cc.zody.yingxiao.model.OrderVO;
import cc.zody.yingxiao.model.PassVO;
import cc.zody.yingxiao.service.PassService;
import cc.zody.yingxiao.service.UserLevelService;
import cc.zody.yingxiao.service.UserService;
import cc.zody.yingxiao.util.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
                vo.setWeChat("微信号：" + passer.getWeChat());
                vo.setAliPay("支付宝号：" + passer.getAliPay());
                vo.setPassLevel("闯关等级：第" + ss.getLevelNum() + "关");
                vo.setGmtCreate(dateToStr(ss.gmtCreate));
                vo.setOrderId(ss.getId());
                passVOList.add(vo);
            }

            model.addAttribute("orderList", passVOList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "user/order_list";
    }

    /**
     * 订单详情页面
     *
     * @return
     */
    @RequestMapping("/order_detail/{passId}")
    public String order_detail(@PathVariable Integer passId, HttpServletRequest request, Model model) {
        try {
            Pass pass = passService.queryById(passId);
            OrderVO orderVO = new OrderVO();
            User user = userService.findUserById(pass.getPassUserId());
            orderVO.setWeChat(user.getWeChat());
            orderVO.setPassTelNum(user.getTelNum());
            orderVO.setPassUsername(user.getUsername());
            orderVO.setPassLevel("第" + pass.getLevelNum() + "关" + UserLevelService.all_level_info.get(pass.getLevelNum()));
            model.addAttribute("orderVO", orderVO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "user/order_detail";
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
                User user = userService.findUserByTelNum(EncryptUtil.getFromBase64(optionalCookie.get().getValue()));
                return user;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 审核闯关流程
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateOrderStatus", method = RequestMethod.POST)
    public DdResult updateOrderStatus(HttpServletRequest request, Integer order_id, String type, String remark) {
        DdResult<Boolean> result = DdResult.getSuccessResult();
        try {
            Pass pass = new Pass();
            pass.setId(order_id);
            switch (type) {
                case "confirm":
                    pass.setRemark(remark);
                    pass.setPassStatus(PassStatusEnum.OK.code());
                    passService.updatePassStatus(pass);
                    break;
                case "refuse":
                    pass.setRemark(remark);
                    pass.setPassStatus(PassStatusEnum.NOT_OK.code());
                    passService.updatePassStatus(pass);
                    break;
                case "":
                    // TODO
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = DdResult.getFailureResult(DdResultCodeEnum.UNKNOW_EXCEPTION.code(), DdResultCodeEnum.UNKNOW_EXCEPTION.name());
        }
        return result;

    }


    public String dateToStr(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }


}
