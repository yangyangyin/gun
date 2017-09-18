package com.bill99.acs.gun.common.base;

import java.util.List;

/**
 * 
* @Description:公共的service方法
* @author yangyang.yin   
* @date 2017年9月12日 上午10:34:41
* @company 99bill.com
 */
public interface IBaseService<T> {
	/*
	 * 新增
	 */
	void insert(T entity);
	/*
	 * 根据主键id删除
	 */
	void deleteById(Long id);
	/*
	 * 根据主键查询
	 */
	T selectById(Long id);
	/*
	 * 根据主键id更新
	 */
	void updateById(T Eentity);
	/*
	 * 查询所有
	 */
	List<T> selectAll();
	
}
