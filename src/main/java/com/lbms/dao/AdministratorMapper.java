package com.lbms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.lbms.domain.Administrator;

public interface AdministratorMapper {
    @Delete({
        "delete from administrator",
        "where admid = #{admid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer admid);

    @Insert({
        "insert into administrator (admid, itemid, ",
        "name, sex, contact,username)",
        "values (#{admid,jdbcType=INTEGER}, #{itemid,jdbcType=INTEGER}, ",
        "#{name,jdbcType=VARCHAR}, #{sex,jdbcType=VARCHAR}, #{contact,jdbcType=VARCHAR},#{username,jdbcType=VARCHAR})"
    })
    int insert(Administrator record);

    int insertSelective(Administrator record);

    @Select({
        "select",
        "admid, itemid, name, sex, contact,username",
        "from administrator",
        "where admid = #{admid,jdbcType=INTEGER}"
    })
    @ResultMap("com.lbms.dao.AdministratorMapper.BaseResultMap")
    Administrator selectByPrimaryKey(Integer admid);

    int updateByPrimaryKeySelective(Administrator record);

    @Update({
        "update administrator",
        "set itemid = #{itemid,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR},",
          "sex = #{sex,jdbcType=VARCHAR},",
          "contact = #{contact,jdbcType=VARCHAR}",
          "username = #{username,jdbcType=VARCHAR}",
        "where admid = #{admid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Administrator record);
    List<Administrator> getAdByPage(@Param(value = "startindex") int startindex,
			@Param(value = "pagesize") int pagesize);
    int getAllRecord();
    int selectLastId();
}