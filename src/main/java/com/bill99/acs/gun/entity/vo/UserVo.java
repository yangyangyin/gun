package com.bill99.acs.gun.entity.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.bill99.acs.gun.common.base.BaseEntity;
import com.bill99.acs.gun.entity.Role;
import com.bill99.acs.gun.entity.User;

/**
 * 
 * @Description:User视图层
 * @author yangyang.yin
 * @date 2017年9月8日 上午10:20:34
 * @company 99bill.com
 */
public class UserVo extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 用户id
	 */
	private Long id;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 真实姓名
	 */
	private String realName;
	/**
	 * 邮件地址
	 */
	private String email;
	/**
	 * 手机号码
	 */
	private String mobilePhone;
	/**
	 * 办公座机电话
	 */
	private String officePhone;
	/**
	 * 最后成功登陆时间
	 */
	private Date lastSuccessTime;
	/**
	 * 最后失败登陆时间
	 */
	private Date lastFailTime;
	/**
	 * 最后修改密码时间
	 */
	private Date lastPasswordTime;
	/**
	 * 冗余字段 角色列表
	 */
	private List<Role> rolesList;
	/**
	 * 用户对应的角色id
	 */
	private String roleIds;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public Date getLastSuccessTime() {
		return lastSuccessTime;
	}

	public void setLastSuccessTime(Date lastSuccessTime) {
		this.lastSuccessTime = lastSuccessTime;
	}

	public Date getLastFailTime() {
		return lastFailTime;
	}

	public void setLastFailTime(Date lastFailTime) {
		this.lastFailTime = lastFailTime;
	}

	public Date getLastPasswordTime() {
		return lastPasswordTime;
	}

	public void setLastPasswordTime(Date lastPasswordTime) {
		this.lastPasswordTime = lastPasswordTime;
	}

	public List<Role> getRolesList() {
		return rolesList;
	}

	public void setRolesList(List<Role> rolesList) {
		this.rolesList = rolesList;
	}

	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	/**
	 * 比较vo和数据库中的用户是否同一个user，采用id比较
	 * 
	 * @param user
	 * @return 是否同一个人
	 */
	public boolean equalsUser(User user) {
		if (user == null) {
			return false;
		}
		Long userId = user.getId();
		if (id == null || userId == null) {
			return false;
		}
		return id.equals(userId);
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}