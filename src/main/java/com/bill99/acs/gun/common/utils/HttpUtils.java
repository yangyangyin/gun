package com.bill99.acs.gun.common.utils;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class HttpUtils {
	// 静态文件后缀
	private final static String[] staticFiles = StringUtils
			.split(".css,.js,.png,.jpg,.gif,.jpeg,.bmp,.ico,.swf,.psd,.htc,.htm,.html,.crx,.xpi,.exe,.ipa,.apk", ",");

	/**
	 * 获取所有请求的值
	 */
	public static Map<String, String> getRequestParameters() {
		HashMap<String, String> values = new HashMap<>();
		HttpServletRequest request = HttpUtils.getRequest();
		Enumeration enums = request.getParameterNames();
		while (enums.hasMoreElements()) {
			String paramName = (String) enums.nextElement();
			String paramValue = request.getParameter(paramName);
			values.put(paramName, paramValue);
		}
		return values;
	}

	/**
	 * 获取 HttpServletRequest
	 * 
	 * @return request
	 */
	public static HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		return request;
	}

	/**
	 * 判断访问URI是否是静态文件请求
	 * 
	 * @throws Exception
	 */
	public static boolean isStaticFile(String uri) {
		if (StringUtils.endsWithAny(uri, staticFiles) && !StringUtils.endsWithAny(uri, "html")
				&& !StringUtils.endsWithAny(uri, ".java")) {
			return true;
		}
		return false;
	}

}
