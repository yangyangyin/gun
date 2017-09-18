package com.bill99.acs.gun.dao;

import java.util.List;

import com.bill99.acs.gun.entity.UserRole;

/**
 * 
* @Description:UserRoleDao用户角色中间表
* @author yangyang.yin   
* @date 2017年9月11日 下午4:31:24
* @company 99bill.com
 */
public interface IUserRoleDao {

	void insert(UserRole userRole);

	List<UserRole> selectByUserId(Long id);

	void deleteById(Long id);

	void deleteByUserId(Long id);

	List<Long> selectRoleIdListByUserId(Long userId);

}
