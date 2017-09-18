package com.bill99.acs.gun.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bill99.acs.gun.common.base.BaseDao;
import com.bill99.acs.gun.entity.Resource;
import com.bill99.acs.gun.entity.Role;

/**
 * 
* @Description:Role 表数据库控制层接口
* @author yangyang.yin   
* @date 2017年9月12日 下午12:48:57
* @company 99bill.com
 */
public interface IRoleDao extends BaseDao<Role> {

    List<Long> selectResourceIdListByRoleId(@Param("id") Long id);

    List<Resource> selectResourceListByRoleIdList(@Param("list") List<Long> list);

    List<Map<Long, String>> selectResourceListByRoleId(@Param("id") Long id);

	Role selectById(Long roleId);

}