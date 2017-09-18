package com.bill99.acs.gun.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill99.acs.gun.common.base.PageInfo;
import com.bill99.acs.gun.dao.IRoleDao;
import com.bill99.acs.gun.dao.IUserRoleDao;
import com.bill99.acs.gun.dao.RoleResourceMapper;
import com.bill99.acs.gun.entity.Role;
import com.bill99.acs.gun.entity.RoleResource;
import com.bill99.acs.gun.service.IRoleService;

/**
 *
 * Role 表数据服务层接口实现类
 *
 */
@Service
public class RoleServiceImpl  implements IRoleService {

    @Autowired
    private IRoleDao roleDao;
    @Autowired
    private IUserRoleDao userRoleDao;
    @Autowired
    private RoleResourceMapper roleResourceMapper;
    
    @Override
    public void selectDataGrid(PageInfo pageInfo) {
    	//TODO 分页
      /*  Page<Role> page = new Page<Role>(pageInfo.getNowpage(), pageInfo.getSize());
        
        EntityWrapper<Role> wrapper = new EntityWrapper<Role>();
        wrapper.orderBy(pageInfo.getSort(), pageInfo.getOrder().equalsIgnoreCase("ASC"));
        selectPage(page, wrapper);
        
        pageInfo.setRows(page.getRecords());
        pageInfo.setTotal(page.getTotal());*/
    }

    @Override
    public Object selectTree() {
    	//TODO菜单树
    /*    List<Tree> trees = new ArrayList<Tree>();
        List<Role> roles = this.selectAll();
        for (Role role : roles) {
            Tree tree = new Tree();
            tree.setId(role.getId());
            tree.setText(role.getName());

            trees.add(tree);
        }*/
        return null;
    }

    @Override
    public void updateRoleResource(Long roleId, String resourceIds) {
        // 先删除后添加
        RoleResource roleResource = new RoleResource();
        roleResource.setRoleId(roleId);
        roleResourceMapper.updateByPrimaryKey(roleResource);
        
        String[] resourceIdArray = resourceIds.split(",");
        for (String resourceId : resourceIdArray) {
            roleResource = new RoleResource();
            roleResource.setRoleId(roleId);
            roleResource.setResourceId(Long.parseLong(resourceId));
            roleResourceMapper.insert(roleResource);
        }
    }

    @Override
    public List<Long> selectResourceIdListByRoleId(Long id) {
        return roleDao.selectResourceIdListByRoleId(id);
    }
    
    @Override
    public Map<String, Set<String>> selectResourceMapByUserId(Long userId) {
        Map<String, Set<String>> resourceMap = new HashMap<String, Set<String>>();
        List<Long> roleIdList = userRoleDao.selectRoleIdListByUserId(userId);
        Set<String> urlSet = new HashSet<String>();
        Set<String> roles = new HashSet<String>();
        for (Long roleId : roleIdList) {
            List<Map<Long, String>> resourceList = roleDao.selectResourceListByRoleId(roleId);
            if (resourceList != null) {
                for (Map<Long, String> map : resourceList) {
                    if (StringUtils.isNotBlank(map.get("url"))) {
                        urlSet.add(map.get("url"));
                    }
                }
            }
            Role role = roleDao.selectById(roleId);
            if (role != null) {
                roles.add(role.getRoleName());
            }
        }
        resourceMap.put("urls", urlSet);
        resourceMap.put("roles", roles);
        return resourceMap;
    }

	@Override
	public void insert(Role role) {
		this.roleDao.insert(role);
	}

	@Override
	public void deleteById(Long id) {
		Role role = this.roleDao.selectById(id);
		this.roleDao.delete(role);
	}

	@Override
	public Role selectById(Long roleId) {
		Role role = this.roleDao.selectById(roleId);
		return role;
	}

	@Override
	public void updateById(Role role) {
		this.roleDao.update(role);
	}
}