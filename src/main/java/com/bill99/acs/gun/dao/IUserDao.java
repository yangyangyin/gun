package com.bill99.acs.gun.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.bill99.acs.gun.common.base.BaseDao;
import com.bill99.acs.gun.common.base.PageInfo;
import com.bill99.acs.gun.entity.User;
import com.bill99.acs.gun.entity.vo.UserVo;

@Repository
public interface IUserDao extends BaseDao<User> {

	UserVo selectUserVoById(Long id);

	void updateById(User user);

	void deleteById(Long id);

	List<UserVo> selectDataGrid(PageInfo pageInfo);

	List<UserVo> selectDataGrid(@Param("username")String username, @Param("from")int from, @Param("size")int size);

	Integer selectUserCount(String username);

}
