/**
 *
 */
package com.bill99.acs.gun.common.base;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.bill99.acs.gun.common.utils.HttpUtils;

/**
 * 
 * @ClassName: BaseController
 * @Description: (控制器支持类)
 * @author junlin.hua
 * @date 2017年9月4日 下午7:28:00
 *
 */
public abstract class BaseController {

	protected static String REDIRECT = "redirect:";

	/**
	 * 初始化数据绑定
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		/**
		 * 自动转换日期类型的字段格式
		 */
		binder.registerCustomEditor(Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}

	protected HttpSession getSession() {
		return HttpUtils.getRequest().getSession();
	}

	protected HttpSession getSession(Boolean flag) {
		return HttpUtils.getRequest().getSession(flag);
	}

	protected String getPara(String name) {
		return HttpUtils.getRequest().getParameter(name);
	}

	protected void setAttr(String name, Object value) {
		HttpUtils.getRequest().setAttribute(name, value);
	}

	/**
	 * 添加Model消息
	 * 
	 * @param message
	 */
	protected void addMessage(Model model, String... messages) {
		StringBuilder sb = new StringBuilder();
		for (String message : messages) {
			sb.append(message).append(messages.length > 1 ? "<br/>" : "");
		}
		model.addAttribute("message", sb.toString());
	}

	/**
	 * 客户端返回字符串
	 * 
	 * @param response
	 * @param string
	 * @return
	 */
	protected String renderString(HttpServletResponse response, String string, String type) {
		try {
			response.reset();
			response.setContentType(type);
			response.setCharacterEncoding("utf-8");
			response.getWriter().print(string);
			return null;
		} catch (IOException e) {
			return null;
		}
	}

	/**
	 * ajax失败
	 * 
	 * @param msg
	 *            失败的消息
	 * @return {Object}
	 */
	public Object renderError(String msg) {
		OperationResult result = new OperationResult();
		result.setMsg(msg);
		return result;
	}

	/**
	 * ajax成功
	 * 
	 * @return {Object}
	 */
	public Object renderSuccess() {
		OperationResult result = new OperationResult();
		result.setSuccess(true);
		return result;
	}

	/**
	 * ajax成功
	 * 
	 * @param msg
	 *            消息
	 * @return {Object}
	 */
	public Object renderSuccess(String msg) {
		OperationResult result = new OperationResult();
		result.setSuccess(true);
		result.setMsg(msg);
		return result;
	}

	/**
	 * ajax成功
	 * 
	 * @param obj
	 *            成功时的对象
	 * @return {Object}
	 */
	public Object renderSuccess(Object obj) {
		OperationResult result = new OperationResult();
		result.setSuccess(true);
		result.setObj(obj);
		return result;
	}

}
