package com.bill99.acs.gun.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill99.acs.gun.common.base.PageInfo;
import com.bill99.acs.gun.common.contant.Const;
import com.bill99.acs.gun.common.utils.BeanUtils;
import com.bill99.acs.gun.dao.IUserDao;
import com.bill99.acs.gun.dao.IUserRoleDao;
import com.bill99.acs.gun.entity.User;
import com.bill99.acs.gun.entity.UserRole;
import com.bill99.acs.gun.entity.vo.UserVo;
import com.bill99.acs.gun.service.IUserService;
import com.bill99.cbs.page.model.CbsPage;
/**
 * 
* @Description:User 表数据服务层接口实现类
* @author yangyang.yin   
* @date 2017年9月11日 下午4:32:45
* @company 99bill.com
 */
@Service
public class UserServiceImpl implements IUserService {
	/**
	 * 用户数据层
	 */
    @Autowired
    private IUserDao userDao;
    /**
     * 用户角色数据层
     */
    @Autowired
    private IUserRoleDao userRoleDao;
    
    /**
     * 新增用户
     */
    @Override
    public void insertByVo(UserVo userVo) {
        User user = BeanUtils.copy(userVo, User.class);
        //设置创建时间和最后更新密码时间
        user.setCreateTime(new Date());
        user.setLastPasswordTime(user.getCreateTime());
        this.userDao.insert(user);
        
        //用户角色表同时插入
        Long id = user.getId();
        String[] roles = userVo.getRoleIds().split(",");
        UserRole userRole = new UserRole();
        for (String roleId : roles) {
            userRole.setUserId(id);
            userRole.setRoleId(Long.valueOf(roleId));
            userRoleDao.insert(userRole);
        }
    }
    /**
     * 查看单个用户
     */
    @Override
    public UserVo selectVoById(Long id) {
        
        UserVo userVo = userDao.selectUserVoById(id);
        if (userVo == null) {
			return null;
		}
        return userVo;
    }
    /**
     * 修改用户信息
     */
    @Override
    public void updateByVo(UserVo userVo) {
        User user = BeanUtils.copy(userVo, User.class);
        
        //不设置密码或者为空,使用默认的密码
        if (StringUtils.isBlank(user.getPassword())) {
            user.setPassword(Const.DEFAULTPASSWORD);
        }
        this.userDao.updateById(user);
        
        Long id = userVo.getId();
        List<UserRole> userRoles = userRoleDao.selectByUserId(id);
        if (userRoles != null && !userRoles.isEmpty()) {
            for (UserRole userRole : userRoles) {
                userRoleDao.deleteById(userRole.getId());
            }
        }
        
        String[] roles = userVo.getRoleIds().split(",");
        UserRole userRole = new UserRole();
        for (String string : roles) {
            userRole.setUserId(id);
            userRole.setRoleId(Long.valueOf(string));
            userRoleDao.insert(userRole);
        }
    }
    /**
     * 查询分页数据
     */
    @Override
    public void selectDataGrid(PageInfo pageInfo) {
    	Map<String, Object> map = pageInfo.getCondition();
    	UserVo userVo = new UserVo();
    	if(null!=map && !map.isEmpty()){
    		userVo.setUsername((String)map.get("username"));
    	}
    	List<UserVo> list = this.userDao.selectDataGrid(userVo.getUsername(),pageInfo.getFrom(),pageInfo.getSize());
    	Integer total = this.userDao.selectUserCount(userVo.getUsername());
    	pageInfo.setTotal(total);
    	pageInfo.setRows(list);
    }
    /**
     * 删除用户
     */
    @Override
    public void deleteUserById(Long id) {
    	//TODO 同步执行
        userDao.deleteById(id);
        userRoleDao.deleteByUserId(id);
    }
    /**
     * 根据用户名查询用户列表
     */
	@Override
	public List<User> selectByLoginName(UserVo uservo) {
		User user = new User();
		user.setUsername(uservo.getUsername());
		List<User> userList = userDao.findList(user);
		   // 账号不存在
        if (userList == null || userList.isEmpty()) {
            return null;
        }
		return userList;
	}
}