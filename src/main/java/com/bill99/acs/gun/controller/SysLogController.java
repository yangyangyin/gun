package com.bill99.acs.gun.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bill99.acs.gun.common.base.BaseController;

/**
 * 
* @ClassName: SysLogController
* @Description: (日志管理)
* @author junlin.hua
* @date 2017年9月4日 下午7:41:23
*
 */
@Controller
@RequestMapping("/log")
public class SysLogController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(SysLogController.class);
	private static String PREFIX = "/log/";
    /**
     * 登录日志主界面
     */
    @RequestMapping("loginIndex")
    public String loginIndex() {
        return PREFIX + "loginlogindex";
    }
    
    /**
     * 操作日志主界面
     */
    @RequestMapping("operationIndex")
    public String operationIndex() {
        return null;
    }
    
}
