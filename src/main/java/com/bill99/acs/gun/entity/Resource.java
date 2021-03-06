package com.bill99.acs.gun.entity;

import java.util.Date;

public class Resource {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_gun_resource.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_gun_resource.resource_level
     *
     * @mbg.generated
     */
    private Short resourceLevel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_gun_resource.resource_name
     *
     * @mbg.generated
     */
    private String resourceName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_gun_resource.resource_order
     *
     * @mbg.generated
     */
    private String resourceOrder;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_gun_resource.resource_url
     *
     * @mbg.generated
     */
    private String resourceUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_gun_resource.parent_resource_id
     *
     * @mbg.generated
     */
    private Long parentResourceId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_gun_resource.resource_type
     *
     * @mbg.generated
     */
    private Short resourceType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_gun_resource.create_name
     *
     * @mbg.generated
     */
    private String createName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_gun_resource.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_gun_resource.create_by
     *
     * @mbg.generated
     */
    private Long createBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_gun_resource.update_name
     *
     * @mbg.generated
     */
    private String updateName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_gun_resource.update_time
     *
     * @mbg.generated
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_gun_resource.update_by
     *
     * @mbg.generated
     */
    private Long updateBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_gun_resource.status
     *
     * @mbg.generated
     */
    private String status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_gun_resource.delete_name
     *
     * @mbg.generated
     */
    private String deleteName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_gun_resource.delete_time
     *
     * @mbg.generated
     */
    private Date deleteTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_gun_resource.delete_by
     *
     * @mbg.generated
     */
    private Long deleteBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_gun_resource.delete_flag
     *
     * @mbg.generated
     */
    private String deleteFlag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_gun_resource.is_open
     *
     * @mbg.generated
     */
    private String isOpen;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_gun_resource.id
     *
     * @return the value of t_gun_resource.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_gun_resource.id
     *
     * @param id the value for t_gun_resource.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_gun_resource.resource_level
     *
     * @return the value of t_gun_resource.resource_level
     *
     * @mbg.generated
     */
    public Short getResourceLevel() {
        return resourceLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_gun_resource.resource_level
     *
     * @param resourceLevel the value for t_gun_resource.resource_level
     *
     * @mbg.generated
     */
    public void setResourceLevel(Short resourceLevel) {
        this.resourceLevel = resourceLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_gun_resource.resource_name
     *
     * @return the value of t_gun_resource.resource_name
     *
     * @mbg.generated
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_gun_resource.resource_name
     *
     * @param resourceName the value for t_gun_resource.resource_name
     *
     * @mbg.generated
     */
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_gun_resource.resource_order
     *
     * @return the value of t_gun_resource.resource_order
     *
     * @mbg.generated
     */
    public String getResourceOrder() {
        return resourceOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_gun_resource.resource_order
     *
     * @param resourceOrder the value for t_gun_resource.resource_order
     *
     * @mbg.generated
     */
    public void setResourceOrder(String resourceOrder) {
        this.resourceOrder = resourceOrder == null ? null : resourceOrder.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_gun_resource.resource_url
     *
     * @return the value of t_gun_resource.resource_url
     *
     * @mbg.generated
     */
    public String getResourceUrl() {
        return resourceUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_gun_resource.resource_url
     *
     * @param resourceUrl the value for t_gun_resource.resource_url
     *
     * @mbg.generated
     */
    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl == null ? null : resourceUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_gun_resource.parent_resource_id
     *
     * @return the value of t_gun_resource.parent_resource_id
     *
     * @mbg.generated
     */
    public Long getParentResourceId() {
        return parentResourceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_gun_resource.parent_resource_id
     *
     * @param parentResourceId the value for t_gun_resource.parent_resource_id
     *
     * @mbg.generated
     */
    public void setParentResourceId(Long parentResourceId) {
        this.parentResourceId = parentResourceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_gun_resource.resource_type
     *
     * @return the value of t_gun_resource.resource_type
     *
     * @mbg.generated
     */
    public Short getResourceType() {
        return resourceType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_gun_resource.resource_type
     *
     * @param resourceType the value for t_gun_resource.resource_type
     *
     * @mbg.generated
     */
    public void setResourceType(Short resourceType) {
        this.resourceType = resourceType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_gun_resource.create_name
     *
     * @return the value of t_gun_resource.create_name
     *
     * @mbg.generated
     */
    public String getCreateName() {
        return createName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_gun_resource.create_name
     *
     * @param createName the value for t_gun_resource.create_name
     *
     * @mbg.generated
     */
    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_gun_resource.create_time
     *
     * @return the value of t_gun_resource.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_gun_resource.create_time
     *
     * @param createTime the value for t_gun_resource.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_gun_resource.create_by
     *
     * @return the value of t_gun_resource.create_by
     *
     * @mbg.generated
     */
    public Long getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_gun_resource.create_by
     *
     * @param createBy the value for t_gun_resource.create_by
     *
     * @mbg.generated
     */
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_gun_resource.update_name
     *
     * @return the value of t_gun_resource.update_name
     *
     * @mbg.generated
     */
    public String getUpdateName() {
        return updateName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_gun_resource.update_name
     *
     * @param updateName the value for t_gun_resource.update_name
     *
     * @mbg.generated
     */
    public void setUpdateName(String updateName) {
        this.updateName = updateName == null ? null : updateName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_gun_resource.update_time
     *
     * @return the value of t_gun_resource.update_time
     *
     * @mbg.generated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_gun_resource.update_time
     *
     * @param updateTime the value for t_gun_resource.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_gun_resource.update_by
     *
     * @return the value of t_gun_resource.update_by
     *
     * @mbg.generated
     */
    public Long getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_gun_resource.update_by
     *
     * @param updateBy the value for t_gun_resource.update_by
     *
     * @mbg.generated
     */
    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_gun_resource.status
     *
     * @return the value of t_gun_resource.status
     *
     * @mbg.generated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_gun_resource.status
     *
     * @param status the value for t_gun_resource.status
     *
     * @mbg.generated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_gun_resource.delete_name
     *
     * @return the value of t_gun_resource.delete_name
     *
     * @mbg.generated
     */
    public String getDeleteName() {
        return deleteName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_gun_resource.delete_name
     *
     * @param deleteName the value for t_gun_resource.delete_name
     *
     * @mbg.generated
     */
    public void setDeleteName(String deleteName) {
        this.deleteName = deleteName == null ? null : deleteName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_gun_resource.delete_time
     *
     * @return the value of t_gun_resource.delete_time
     *
     * @mbg.generated
     */
    public Date getDeleteTime() {
        return deleteTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_gun_resource.delete_time
     *
     * @param deleteTime the value for t_gun_resource.delete_time
     *
     * @mbg.generated
     */
    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_gun_resource.delete_by
     *
     * @return the value of t_gun_resource.delete_by
     *
     * @mbg.generated
     */
    public Long getDeleteBy() {
        return deleteBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_gun_resource.delete_by
     *
     * @param deleteBy the value for t_gun_resource.delete_by
     *
     * @mbg.generated
     */
    public void setDeleteBy(Long deleteBy) {
        this.deleteBy = deleteBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_gun_resource.delete_flag
     *
     * @return the value of t_gun_resource.delete_flag
     *
     * @mbg.generated
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_gun_resource.delete_flag
     *
     * @param deleteFlag the value for t_gun_resource.delete_flag
     *
     * @mbg.generated
     */
    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_gun_resource.is_open
     *
     * @return the value of t_gun_resource.is_open
     *
     * @mbg.generated
     */
    public String getIsOpen() {
        return isOpen;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_gun_resource.is_open
     *
     * @param isOpen the value for t_gun_resource.is_open
     *
     * @mbg.generated
     */
    public void setIsOpen(String isOpen) {
        this.isOpen = isOpen == null ? null : isOpen.trim();
    }
}