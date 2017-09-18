package com.bill99.acs.gun.entity;

import java.io.Serializable;

import com.bill99.acs.gun.common.base.BaseEntity;

/**
 * 
 * @Description:t_gun_role表对应的实体类Role:角色表
 * @author yangyang.yin
 * @date 2017年9月6日 下午1:11:30
 * @company 99bill.com
 */
public class Role extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 角色id
	 */
	private Long id;
	/**
	 * 角色名称
	 */
	private String roleName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + "]";
	}

}
