package com.bill99.acs.gun.service;

import java.util.List;

import com.bill99.acs.gun.common.base.PageInfo;
import com.bill99.acs.gun.entity.User;
import com.bill99.acs.gun.entity.vo.UserVo;

/**
 * 
 * @Description:User 表数据服务层接口
 * @author yangyang.yin
 * @date 2017年9月8日 上午10:56:11
 * @company 99bill.com
 */
public interface IUserService{
    /**
     * 新增用户
     */
    void insertByVo(UserVo userVo);
    /**
     * 根据主键id查询Vo用户
     */
    UserVo selectVoById(Long id);
    /**
     * 编辑用户
     */ 
    void updateByVo(UserVo userVo);
    /**
     * 查询用户分页信息
     */
    void selectDataGrid(PageInfo pageInfo);
    /**
     * 删除单个用户
     */
    void deleteUserById(Long id);
    /**
     * 根据用户名查询用户
     */
	List<User> selectByLoginName(UserVo uservo);
}