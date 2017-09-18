package com.bill99.acs.gun.common.base;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 
* @Description:错误页面的默认跳转
* @author yangyang.yin   
* @date 2017年8月28日 下午3:46:46
* @company 99bill.com
 */
@Component("error")
public class GlobalErrorView implements View{

    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public void render(Map<String, ?> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.getRequestDispatcher("/global/error").forward(httpServletRequest,httpServletResponse);
    }
}
