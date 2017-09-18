package com.bill99.acs.gun.common.base;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
* @Description:全局的控制器
* @author yangyang.yin   
* @date 2017年8月28日 下午3:45:27
* @company 99bill.com
 */
@Controller
@RequestMapping("/global")
public class GlobalController {

    /**
     * 跳转到404页面
     */
    @RequestMapping(value = "/error")
    public String errorPage() {
        return "/404.html";
    }

    /**
     * 跳转到session超时页面
     */
    @RequestMapping(value = "/sessionError")
    public String errorPageInfo(Model model) {
        model.addAttribute("tips", "session超时");
        return "/login.html";
    }
}
