package com.bill99.acs.gun.common.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.filter.authc.UserFilter;
import org.apache.shiro.web.util.WebUtils;

/**
 * 
* @ClassName: ShiroAjaxSessionFilter
* @Description: (ajax shiro session超时统一处理)
* @author junlin.hua
* @date 2017年9月7日 下午3:53:15
*
 */
public class ShiroAjaxSessionFilter extends UserFilter {

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		HttpServletRequest req = WebUtils.toHttp(request);
		String xmlHttpRequest = req.getHeader("X-Requested-With");
		if (StringUtils.isNotBlank(xmlHttpRequest)) {
			if (xmlHttpRequest.equalsIgnoreCase("XMLHttpRequest")) {
				HttpServletResponse res = WebUtils.toHttp(response);
				// 采用res.sendError(401);在Easyui中会处理掉error，$.ajaxSetup中监听不到
				res.setHeader("oauthstatus", "401");
				return false;
			}
		}
		return super.onAccessDenied(request, response);
	}

}