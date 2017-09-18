package com.bill99.acs.gun.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bill99.acs.gun.common.base.PageInfo;
import com.bill99.acs.gun.entity.Role;

/**
 * 
* @Description:Role 表数据服务层接口
* @author yangyang.yin   
* @date 2017年9月7日 下午5:24:53
* @company 99bill.com
 */
public interface IRoleService{

    void selectDataGrid(PageInfo pageInfo);

    Object selectTree();

    List<Long> selectResourceIdListByRoleId(Long id);

    void updateRoleResource(Long id, String resourceIds);

    Map<String, Set<String>> selectResourceMapByUserId(Long userId);

	void insert(Role role);

	void deleteById(Long id);

	Role selectById(Long id);

	void updateById(Role role);

}