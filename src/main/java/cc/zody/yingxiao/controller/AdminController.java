package cc.zody.yingxiao.controller;

import cc.zody.yingxiao.dataobject.IndexImg;
import cc.zody.yingxiao.dataobject.User;
import cc.zody.yingxiao.dataobject.UserLevel;
import cc.zody.yingxiao.enums.DdResultCodeEnum;
import cc.zody.yingxiao.model.DdResult;
import cc.zody.yingxiao.model.UserVO;
import cc.zody.yingxiao.service.AdminService;
import cc.zody.yingxiao.service.IndexImgService;
import cc.zody.yingxiao.service.UserLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liumin
 * @since 2019-02-26
 */
@RequestMapping("/admin")
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;


    @Autowired
    private UserLevelService userLevelService;

    @Autowired
    IndexImgService indexImgService;


    /**
     * 管理员登录
     */
    @RequestMapping("/login")
    public String login(String telNum, String password) {

        try {
            Boolean re = adminService.login(telNum, password);
//

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "login";
    }


    /**
     * 查询所有用户信息
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/query/all/user")
    public DdResult queryAllUser() {
        DdResult<List<UserVO>> result = DdResult.getSuccessResult();
        List<UserVO> listVO = new ArrayList<>();
        try {

            List<User> list = adminService.queryAllUser();
            if (!CollectionUtils.isEmpty(list)) {
                Map<Integer, String> levelMap = new HashMap<>();
                List<UserLevel> userLevelList = userLevelService.queryAllLevel();
                if (!CollectionUtils.isEmpty(userLevelList)) {
                    for (UserLevel level : userLevelList) {
                        levelMap.put(level.getId(), level.getLevelName());
                    }
                }

                for (User user : list) {
                    UserVO vo = new UserVO();
                    vo.setId(user.getId());
                    vo.setWeChat(user.getWeChat());
                    vo.setAliPay(user.getAliPay());
                    vo.setUsername(user.getUsername());
                    vo.setTelNum(user.getTelNum());
                    vo.setLevel(user.getLevel());
                    vo.setLevelName(levelMap.get(user.getLevel()));
                    vo.setGmtCreate(dateToStr(user.getGmtCreate()));
                    vo.setGmtModified(dateToStr(user.getGmtModified()));
                    listVO.add(vo);
                }
                result.setData(listVO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = DdResult.getFailureResult(DdResultCodeEnum.UNKNOW_EXCEPTION.code(), DdResultCodeEnum.UNKNOW_EXCEPTION.name());
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/query/page/user")
    public Object queryPageUser() {
        try {

        } catch (Exception e) {

        }
        return null;
    }

    @RequestMapping("/indexImg/page")
    public String addIndexImgPage(){
        return "admin/indexImgPage";
    }


    /**
     * 增加主要轮播对象
     *
     * @return
     */
    @RequestMapping(value = "/indexImg/add")
    @ResponseBody
    public DdResult<Boolean> addIndexImg() {
        DdResult<Boolean> result = DdResult.getSuccessResult();
        try {
            IndexImg indexImg = new IndexImg();
//            indexImg.setTitle();
//            indexImg.setHrefUrl();
//            indexImg.setPicUrl();

            Integer dbResult =  indexImgService.insertIndexImg(indexImg);
            if (null == dbResult || dbResult != 1){
                result = DdResult.getFailureResult(DdResultCodeEnum.DB_ERROR_EXCEPTION.code(), DdResultCodeEnum.DB_ERROR_EXCEPTION.name());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }

    /**
     * 删除主要轮播对象
     *
     * @return
     */
    @RequestMapping(value = "/indexImg/del")
    @ResponseBody
    public DdResult delIndexImg(Integer id) {
        DdResult<Boolean> result = DdResult.getSuccessResult();
        try {
            IndexImg indexImg = new IndexImg();
            indexImg.setId(id);
            Integer dbResult = indexImgService.delIndexImg(indexImg);
            if (null == dbResult || dbResult != 1){
                result = DdResult.getFailureResult(DdResultCodeEnum.DB_ERROR_EXCEPTION.code(), DdResultCodeEnum.DB_ERROR_EXCEPTION.name());
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = DdResult.getFailureResult(DdResultCodeEnum.UNKNOW_EXCEPTION.code(), DdResultCodeEnum.UNKNOW_EXCEPTION.name());
        }
        return result;
    }


    private String dateToStr(Date date) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }


}
