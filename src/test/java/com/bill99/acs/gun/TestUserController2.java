package com.bill99.acs.gun;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bill99.acs.gun.common.base.BaseController;
import com.bill99.acs.gun.common.base.PageInfo;
import com.bill99.acs.gun.common.shiro.PasswordHash;
import com.bill99.acs.gun.entity.User;
import com.bill99.acs.gun.entity.vo.UserVo;
import com.bill99.acs.gun.service.IUserService;

/**
 * 
 * @Description:用户控制器
 * @author yangyang.yin
 * @date 2017年9月6日 下午2:05:52
 * @company 99bill.com
 */
@Controller
@RequestMapping("/test")
public class TestUserController2 extends BaseController {

	/**
	 * user路径前缀
	 */
	private static String PREFIX = "/user/";
	/**
	 * 用户服务
	 */
	@Autowired
	private IUserService userService;
	/**
	 * 用户密码加密处理
	 */
    @Autowired
    private PasswordHash passwordHash;

	/**
	 * 跳转用户信息主页面
	 */
	@RequestMapping("/index")
	public String manager() {
		return PREFIX + "dataGrid";
	}

	/**
	 * 用户数据列表
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/dataGrid", produces = {"text/html;charset=UTF-8;", "application/json;"} )
	@ResponseBody
	public PageInfo dataGrid(UserVo userVo,
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "rows", defaultValue = "10") Integer rows, 
			String sort, String order) throws ParseException {
		PageInfo pageInfo = new PageInfo(page, rows, sort, order);
		List<User> list = new  ArrayList<>();
		User user1  =new User();
		user1.setId(001L);
		user1.setUsername("zhangsan");
		user1.setRealName("realName");
		user1.setMobilePhone("13987654567");
		user1.setEmail("7788@178.com");
		user1.setCreateBy(67898789L);
		SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
		Date date = sdf.parse( "2017-09-15 09:28:48" );
		user1.setCreateTime(date);
		
		User user2  =new User();
		user2.setId(001L);
		user2.setUsername("lisi");
		user2.setRealName("李四");
		user2.setMobilePhone("13987654567");
		user2.setEmail("7788@178.com");
		user2.setCreateBy(67898789L);
		user2.setCreateTime(date);
		
		list.add(user1);
		list.add(user2);
		
		pageInfo.setTotal(323);
		pageInfo.setRows(list);
		return pageInfo;
	}

}
