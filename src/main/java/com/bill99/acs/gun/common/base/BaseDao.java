/**
 *
 */
package com.bill99.acs.gun.common.base;

import java.util.List;

/**
 * 
* @ClassName: BaseDao
* @Description: (基础通用dao)
* @author junlin.hua
* @date 2017年9月7日 上午11:12:55
* @param <T>
 */
public interface BaseDao<T> {

	/**
	 * 获取单条数据
	 * @param id
	 * @return
	 */
	public T get(String id);
	
	/**
	 * 查询数据列表
	 * @param entity
	 * @return
	 */
	public List<T> findList(T entity);
	
	/**
	 * 插入数据
	 * @param entity
	 * @return
	 */
	public int insert(T entity);
	
	/**
	 * 更新数据
	 * @param entity
	 * @return
	 */
	public int update(T entity);
	
	/**
	 * 删除数据（一般为逻辑删除，更新del_flag字段为1）
	 * @param entity
	 * @return
	 */
	public int delete(T entity);
	
}