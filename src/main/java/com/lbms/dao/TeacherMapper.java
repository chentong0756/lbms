package com.lbms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.lbms.domain.Teacher;

public interface TeacherMapper {
    @Delete({
        "delete from teacher",
        "where teaid = #{teaid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer teaid);

    @Insert({
        "insert into teacher (teaid, name, ",
        "sex, title, education, ",
        "date, contact)",
        "values (#{teaid,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{sex,jdbcType=VARCHAR}, #{title,jdbcType=VARCHAR}, #{education,jdbcType=VARCHAR}, ",
        "#{date,jdbcType=TIMESTAMP}, #{contact,jdbcType=VARCHAR})"
    })
    int insert(Teacher record);

    int insertSelective(Teacher record);

    @Select({
        "select",
        "teaid, name, sex, title, education, date, contact",
        "from teacher",
        "where teaid = #{teaid,jdbcType=INTEGER}"
    })
    @ResultMap("com.lbms.dao.TeacherMapper.BaseResultMap")
    Teacher selectByPrimaryKey(Integer teaid);

    int updateByPrimaryKeySelective(Teacher record);

    @Update({
        "update teacher",
        "set name = #{name,jdbcType=VARCHAR},",
          "sex = #{sex,jdbcType=VARCHAR},",
          "title = #{title,jdbcType=VARCHAR},",
          "education = #{education,jdbcType=VARCHAR},",
          "date = #{date,jdbcType=TIMESTAMP},",
          "contact = #{contact,jdbcType=VARCHAR}",
        "where teaid = #{teaid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Teacher record);
    int getAllRecord();
    List<Teacher> getTeacherByPage(@Param(value = "startindex") int startindex,
			@Param(value = "pagesize") int pagesize);
}