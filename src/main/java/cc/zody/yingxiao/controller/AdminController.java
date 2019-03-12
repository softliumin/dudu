package cc.zody.yingxiao.controller;

import cc.zody.yingxiao.dataobject.Admin;
import cc.zody.yingxiao.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author liumin
 * @since 2019-02-26
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminMapper adminMapper;


    /**
     * 管理员登录
     */
    @RequestMapping("/login")
    public String login() {
        try {
//            Admin admin = adminRepository.findAdminByEmail("sharper@gmail.com");
//            System.out.println(admin.getEmail());
//            return admin.getEmail();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "login";
    }

}
