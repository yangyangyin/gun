package com.bill99.acs.gun.entity;

import java.io.Serializable;

import com.bill99.acs.gun.common.base.BaseEntity;

/**
 * 
* @ClassName: LoginLog
* @Description: (登录日志实体)
* @author junlin.hua
* @date 2017年9月8日 上午9:17:30
*
 */
public class LoginLog extends BaseEntity implements Serializable {

	/**
	* @Fields serialVersionUID : (用一句话描述这个变量表示什么)
	*/
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String logName;
	
	private Long userId;
	
	private String succeed;
	
	private String message;
	
	private String ip;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getSucceed() {
		return succeed;
	}

	public void setSucceed(String succeed) {
		this.succeed = succeed;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoginLog [id=").append(id).append(", logName=").append(logName).append(", userId=")
				.append(userId).append(", succeed=").append(succeed).append(", message=").append(message)
				.append(", ip=").append(ip).append("]");
		return builder.toString();
	}
	
}
