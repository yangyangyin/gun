package com.bill99.acs.gun.entity;

import java.io.Serializable;

import com.bill99.acs.gun.common.base.BaseEntity;

/**
 * 
* @ClassName: OperationLog
* @Description: (操作日志实体)
* @author junlin.hua
* @date 2017年9月8日 上午9:17:30
*
 */
public class OperationLog extends BaseEntity implements Serializable {

	/**
	* @Fields serialVersionUID : (用一句话描述这个变量表示什么)
	*/
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String logType;
	
	private String logName;
	
	private Long userId;
	
	private String className;
	
	private String method;
	
	private String message;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogType() {
		return logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}

	public String getLogName() {
		return logName;
	}

	public void setLogName(String logName) {
		this.logName = logName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OperationLog [id=").append(id).append(", logType=").append(logType).append(", logName=")
				.append(logName).append(", userId=").append(userId).append(", className=").append(className)
				.append(", method=").append(method).append(", message=").append(message).append("]");
		return builder.toString();
	}
	
}
