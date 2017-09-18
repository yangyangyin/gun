package com.bill99.acs.gun.dao;

import org.springframework.stereotype.Repository;

import com.bill99.acs.gun.entity.LoginLog;
import com.bill99.acs.gun.entity.OperationLog;

@Repository
public interface ISysLogDao {
	
	 /**
	  * 
	 * @Title: queryLoginLog
	 * @Description: (查询登录日志列表)
	 * @return LoginLog 返回类型 
	  */
	 LoginLog queryLoginLog();
	 
	 /**
	  * 
	 * @Title: queryOperationLog
	 * @Description: (查询操作日志列表)
	 * @return OperationLog 返回类型 
	  */
	 OperationLog queryOperationLog();
	 
	 
}
