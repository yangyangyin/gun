package com.bill99.acs.gun.entity;

import com.alibaba.fastjson.JSON;

/**
 * 
* @Description:用户角色中间表
* @author yangyang.yin   
* @date 2017年9月11日 下午1:29:50
* @company 99bill.com
 */
public class UserRole {
	/**
	 * id,主键
	 */
	private Long id;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 角色id
	 */
	private Long roleId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
	
	
	
}
