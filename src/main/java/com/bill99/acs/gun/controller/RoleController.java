package com.bill99.acs.gun.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bill99.acs.gun.common.base.BaseController;
import com.bill99.acs.gun.common.base.PageInfo;
import com.bill99.acs.gun.entity.Role;
import com.bill99.acs.gun.service.IRoleService;

/**
 * 
 * @Description:角色控制器
 * @author yangyang.yin
 * @date 2017年9月7日 下午2:21:46
 * @company 99bill.com
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

	@Autowired
	private IRoleService roleService;

	private static String PREFIX = "/views/role/";

	/**
	 * 权限管理页
	 *
	 * @return
	 */
	@RequestMapping("/manager")
	public String manager() {
		return PREFIX + "role";
	}

	/**
	 * 权限列表
	 *
	 * @param page
	 * @param rows
	 * @param sort
	 * @param order
	 * @return
	 */
	@RequestMapping("/dataGrid")
	@ResponseBody
	public Object dataGrid(Integer page, Integer rows, String sort, String order) {
		PageInfo pageInfo = new PageInfo(page, rows, sort, order);
		roleService.selectDataGrid(pageInfo);
		return pageInfo;
	}

	/**
	 * 权限树
	 *
	 * @return
	 */
	@RequestMapping("/tree")
	@ResponseBody
	public Object tree() {
		Object selectTree = roleService.selectTree();
		if (selectTree == null) {
			return null;
		}
		return selectTree;
	}

	/**
	 * 跳转添加权限页
	 *
	 * @return
	 */
	@RequestMapping("/toAddRolePage")
	public String toAddRolePage() {
		return PREFIX + "roleAdd";
	}

	/**
	 * 添加权限
	 *
	 * @param role
	 * @return
	 */

	@RequestMapping("/addRole")
	@ResponseBody
	public Object addRole(Role role) {
		roleService.insert(role);
		return renderSuccess("添加成功！");
	}

	   /**
     * 删除权限
     *
     * @param id
     * @return
     */
    @RequestMapping("/deleteRole")
    @ResponseBody
    public Object deleteRole(Long id) {
    	try {
    		roleService.deleteById(id);
		} catch (Exception e) {
			logger.error("delete role error!",e);
		}
        return renderSuccess("删除成功！");
    }

    /**
     * 编辑权限页
     *
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/editPage")
    public String editPage(Model model, Long id) {
        Role role = roleService.selectById(id);
        model.addAttribute("role", role);
        return "admin/role/roleEdit";
    }

    /**
     * 删除权限
     *
     * @param role
     * @return
     */
    @RequestMapping("/edit")
    @ResponseBody
    public Object edit(Role role) {
        roleService.updateById(role);
        return renderSuccess("编辑成功！");
    }

    /**
     * 授权页面
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/grantPage")
    public String grantPage(Model model, Long id) {
        model.addAttribute("id", id);
        return "admin/role/roleGrant";
    }

    /**
     * 授权页面页面根据角色查询资源
     *
     * @param id
     * @return
     */
    @RequestMapping("/findResourceIdListByRoleId")
    @ResponseBody
    public Object findResourceByRoleId(Long id) {
        List<Long> resources = roleService.selectResourceIdListByRoleId(id);
        return renderSuccess(resources);
    }

    /**
     * 授权
     *
     * @param id
     * @param resourceIds
     * @return
     */
    @RequiresRoles("admin")
    @RequestMapping("/grant")
    @ResponseBody
    public Object grant(Long id, String resourceIds) {
        roleService.updateRoleResource(id, resourceIds);
        return renderSuccess("授权成功！");
    }

}
