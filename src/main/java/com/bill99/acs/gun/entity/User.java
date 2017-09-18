package com.bill99.acs.gun.entity;

import java.io.Serializable;
import java.util.Date;

import com.bill99.acs.gun.common.base.BaseEntity;

/**
 * 
 * @Description:t_gun_user表对应的实体类:用户表
 * @author yangyang.yin
 * @date 2017年9月6日 下午1:05:31
 * @company 99bill.com
 */
public class User extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 用户id
	 */
	private Long id;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 真实姓名
	 */
	private String realName;
	/**
	 * 邮件地址
	 */
	private String email;
	/**
	 * 手机号码
	 */
	private String mobilePhone;
	/**
	 * 办公座机电话
	 */
	private String officePhone;
	/**
	 * 最后成功登陆时间
	 */
	private Date lastSuccessTime;
	/**
	 * 最后失败登陆时间
	 */
	private Date lastFailTime;
	/**
	 * 最后修改密码时间
	 */
	private Date lastPasswordTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public Date getLastSuccessTime() {
		return lastSuccessTime;
	}

	public void setLastSuccessTime(Date lastSuccessTime) {
		this.lastSuccessTime = lastSuccessTime;
	}

	public Date getLastFailTime() {
		return lastFailTime;
	}

	public void setLastFailTime(Date lastFailTime) {
		this.lastFailTime = lastFailTime;
	}

	public Date getLastPasswordTime() {
		return lastPasswordTime;
	}

	public void setLastPasswordTime(Date lastPasswordTime) {
		this.lastPasswordTime = lastPasswordTime;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", realName=" + realName
				+ ", email=" + email + ", mobilePhone=" + mobilePhone + ", officePhone=" + officePhone
				+ ", lastSuccessTime=" + lastSuccessTime + ", lastFailTime=" + lastFailTime + ", lastPasswordTime="
				+ lastPasswordTime + "]";
	}

}
