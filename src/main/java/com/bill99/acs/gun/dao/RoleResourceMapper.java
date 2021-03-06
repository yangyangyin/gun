package com.bill99.acs.gun.dao;

import com.bill99.acs.gun.entity.RoleResource;
import com.bill99.acs.gun.entity.RoleResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface RoleResourceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_gun_role_resource
     *
     * @mbg.generated
     */
    long countByExample(RoleResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_gun_role_resource
     *
     * @mbg.generated
     */
    int deleteByExample(RoleResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_gun_role_resource
     *
     * @mbg.generated
     */
    @Delete({
        "delete from t_gun_role_resource",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_gun_role_resource
     *
     * @mbg.generated
     */
    @Insert({
        "insert into t_gun_role_resource (id, role_id, ",
        "resource_id)",
        "values (#{id,jdbcType=BIGINT}, #{roleId,jdbcType=BIGINT}, ",
        "#{resourceId,jdbcType=BIGINT})"
    })
    int insert(RoleResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_gun_role_resource
     *
     * @mbg.generated
     */
    int insertSelective(RoleResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_gun_role_resource
     *
     * @mbg.generated
     */
    List<RoleResource> selectByExample(RoleResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_gun_role_resource
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, role_id, resource_id",
        "from t_gun_role_resource",
        "where id = #{id,jdbcType=BIGINT}"
    })
    //@ResultMap("com.bill99.acs.gun.acs.gun.dao.RoleResourceMapper.BaseResultMap")
    RoleResource selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_gun_role_resource
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") RoleResource record, @Param("example") RoleResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_gun_role_resource
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") RoleResource record, @Param("example") RoleResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_gun_role_resource
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(RoleResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_gun_role_resource
     *
     * @mbg.generated
     */
    @Update({
        "update t_gun_role_resource",
        "set role_id = #{roleId,jdbcType=BIGINT},",
          "resource_id = #{resourceId,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(RoleResource record);
}