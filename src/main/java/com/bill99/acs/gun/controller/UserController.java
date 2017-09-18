package com.bill99.acs.gun.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bill99.acs.gun.common.base.BaseController;
import com.bill99.acs.gun.common.base.PageInfo;
import com.bill99.acs.gun.common.shiro.PasswordHash;
import com.bill99.acs.gun.entity.Role;
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
@RequestMapping("/user")
public class UserController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
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
    private PasswordHash passwordHash;
    

	public PasswordHash getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(PasswordHash passwordHash) {
		this.passwordHash = passwordHash;
	}

	/**
	 * 跳转用户信息主页面
	 */
	@RequestMapping("/index")
	public String manager() {
		return PREFIX + "userlist";
	}

	/**
	 * 用户数据列表
	 */
	@RequestMapping(value="/dataGrid",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public PageInfo dataGrid(UserVo userVo,
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "rows", defaultValue = "10") Integer rows, 
			String sort, String order) {
		logger.info("query user list start , query params is {}", userVo);
		PageInfo pageInfo = new PageInfo(page, rows, sort, order);
		//查询条件
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("username", userVo.getUsername());
		pageInfo.setCondition(condition);
		
		userService.selectDataGrid(pageInfo);
		logger.info("query user list end!");
		return pageInfo;
	}

	/**
	 * 
	 * @Description: 跳转添加用户页 
	 * @return String 
	 * @throws
	 */
	@RequestMapping("/toAddUserPage")
	public String toAddUserPage() {
		return PREFIX + "userAdd";
	}

	/**
	 * 
	 * @Description: 添加用户 
	 * @return Object 
	 * @throws
	 */
	@RequestMapping("/addUser")
	@ResponseBody
	public Object addUser(UserVo userVo) {
	    List<User> userList = userService.selectByLoginName(userVo);

	    if (userList != null && !userList.isEmpty()) {
            return renderError("登录名已存在!");
        }
		//密码加密处理,使用用户名和密码加密
	    String pwd = passwordHash.toHex(userVo.getPassword(), userVo.getUsername());
	    userVo.setPassword(pwd);
		try {
			userService.insertByVo(userVo);
		} catch (Exception e) {
			logger.error("add user error!", e);
			return renderError("添加失败!");
		}
		return renderSuccess("添加成功!");
	}

	/**
	 * 
	 * @Description:跳转编辑用户页 
	 * @param model 
	 * @param id 
	 * @return String 
	 * @throws
	 */
	@RequestMapping("/toEditUserPage")
	public String toEditUserPage(Model model, Long id) {
		UserVo userVo = userService.selectVoById(id);
		List<Role> rolesList = userVo.getRolesList();
		//获取对应的角色信息的id
		List<Long> roleIdList = new ArrayList<Long>();
		for (Role role : rolesList) {
			roleIdList.add(role.getId());
		}
		model.addAttribute("roleIds", roleIdList);
		model.addAttribute("user", userVo);
		return PREFIX + "userEdit";
	}
	@RequestMapping("/toEditPage")
	public String toEditPage(Model model, Long id) {
		return PREFIX + "userEdit";
	}

	/**
	 * 编辑用户页
	 * @param userVo
	 * @return
	 */
	@RequestMapping("/editUser")
	@ResponseBody
	public Object edit(UserVo userVo) {
		logger.info("edit user Condition = {}", userVo);
	     List<User> list = userService.selectByLoginName(userVo);
	     if (list != null && !list.isEmpty()) {
	            return renderError("登录名已存在!");
	      }
		// 更新密码
		if (StringUtils.isNotBlank(userVo.getPassword())) {
			//密码加密
            String pwd = passwordHash.toHex(userVo.getPassword(), userVo.getUsername());
            userVo.setPassword(pwd); 
		}
		//TODO 数据库非空字段,更新字段,当前登录用户,目前写死
		userVo.setCreateTime(new Date());
		userVo.setCreateBy(6789L);
		userVo.setCreateName("admin");
		userVo.setUpdateBy(6789L);
		userVo.setUpdateName("admin");
		userVo.setUpdateTime(new Date());
		
		try {
			userService.updateByVo(userVo);
		} catch (Exception e) {
			logger.error("edit user error!",e);
			return renderSuccess("修改失败！");
		}
		logger.info("edit user end!");
		return renderSuccess("修改成功！");
	}

	/**
	 * 删除用户
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
    public Object delete(@RequestParam(value = "id", required = true)Long id) {
		logger.info("delete user start ,userId = {}", id);
		//TODO获取登录用户,不能删除自己
        Long currentUserId = null;
        if (id == currentUserId) {
            return renderError("不可以删除自己！");
        }
        UserVo userVo = userService.selectVoById(id);
        userVo.setStatus("0");
        userService.deleteUserById(id);
        return renderSuccess("删除成功！");
    }

}
