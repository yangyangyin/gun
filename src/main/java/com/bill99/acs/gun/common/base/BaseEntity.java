package com.bill99.acs.gun.common.base;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @Description:实体类公共的属性
 * @author yangyang.yin
 * @date 2017年9月6日 下午12:49:06
 * @company 99bill.com
 */
public abstract class BaseEntity {
	/**
	 * 更新者
	 */
	private String updateName;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 更新者id
	 */
	private long updateBy;
	/**
	 * 创建人
	 */
	private String createName;
	/**
	 * 创建时间
	 */
	@JSONField (format="yyyy-MM-dd HH:mm:ss")  
	private Date createTime;
	/**
	 * 创建人id
	 */
	private long createBy;
	/**
	 * 删除人
	 */
	private String deleteName;
	/**
	 * 删除时间
	 */
	private Date deleteTime;
	/**
	 * 删除者id
	 */
	private long deleteBy;
	/**
	 * 状态标识(1 表示可用,0 表示不可用)
	 */
	private String status;
	/**
	 * 删除标识(1 表示可用,0 表示不可用,假删除)
	 */
	private String deleteFlag;

	public String getUpdateName() {
		return updateName;
	}

	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(long updateBy) {
		this.updateBy = updateBy;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(long createBy) {
		this.createBy = createBy;
	}

	public String getDeleteName() {
		return deleteName;
	}

	public void setDeleteName(String deleteName) {
		this.deleteName = deleteName;
	}

	public Date getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}

	public long getDeleteBy() {
		return deleteBy;
	}

	public void setDeleteBy(long deleteBy) {
		this.deleteBy = deleteBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Override
	public String toString() {
		return "BaseEntity [updateName=" + updateName + ", updateTime=" + updateTime + ", updateBy=" + updateBy
				+ ", createName=" + createName + ", createTime=" + createTime + ", createBy=" + createBy
				+ ", deleteName=" + deleteName + ", deleteTime=" + deleteTime + ", deleteBy=" + deleteBy + ", status="
				+ status + ", deleteFlag=" + deleteFlag + "]";
	}

}
