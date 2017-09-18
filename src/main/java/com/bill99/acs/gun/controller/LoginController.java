package com.bill99.acs.gun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bill99.acs.gun.common.base.BaseController;
import com.bill99.acs.gun.common.utils.ShiroUtils;

/**
 * 
* @ClassName: LoginController
* @Description: (登录控制器)
* @author junlin.hua
* @date 2017年9月12日 下午4:13:05
*
 */
@Controller
public class LoginController extends BaseController {

    /**
     * 跳转到主页
     */
    @RequestMapping(value = "/index")
    public String index(Model model) {

        return "/index";
    }

    /**
     * 跳转到登录页面
     */
    @RequestMapping(value = "/login", method = {RequestMethod.GET,RequestMethod.POST})
    public String login() {
    	return REDIRECT + "/index";
       /* if (ShiroUtils.isAuthenticated() || ShiroUtils.getUser() != null) {
            return REDIRECT + "/index";
        } else {
            return "/login";
        }*/
    }
    /**
     * 退出登录
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logOut() {
        ShiroUtils.getSubject().logout();
        return REDIRECT + "/login";
    }
}
