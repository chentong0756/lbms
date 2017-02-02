package com.lbms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.lbms.domain.Batch;
import com.lbms.domain.Student;

public interface StudentMapper {
    @Delete({
        "delete from student",
        "where numid = #{numid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer numid);

    @Insert({
        "insert into student (numid, name, ",
        "sex, specialization, ",
        "grade, date, contact)",
        "values (#{numid,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{sex,jdbcType=VARCHAR}, #{specialization,jdbcType=VARCHAR}, ",
        "#{grade,jdbcType=VARCHAR}, #{date,jdbcType=TIMESTAMP}, #{contact,jdbcType=VARCHAR})"
    })
    int insert(Student record);

    int insertSelective(Student record);

    @Select({
        "select",
        "numid, name, sex, specialization, grade, date, contact",
        "from student",
        "where numid = #{numid,jdbcType=INTEGER}"
    })
    @ResultMap("com.lbms.dao.StudentMapper.BaseResultMap")
    Student selectByPrimaryKey(Integer numid);

    int updateByPrimaryKeySelective(Student record);

    @Update({
        "update student",
        "set name = #{name,jdbcType=VARCHAR},",
          "sex = #{sex,jdbcType=VARCHAR},",
          "specialization = #{specialization,jdbcType=VARCHAR},",
          "grade = #{grade,jdbcType=VARCHAR},",
          "date = #{date,jdbcType=TIMESTAMP},",
          "contact = #{contact,jdbcType=VARCHAR}",
        "where numid = #{numid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Student record);
    int selectLastId();
    int getAllRecord();
    List<Student> getStudentByPage(@Param(value = "startindex") int startindex,
			@Param(value = "pagesize") int pagesize);
    List<Student> getHasOrderStudent(@Param(value="batId")int batId, @Param(value = "startindex") int startindex,
			@Param(value = "pagesize") int pagesize);
    List<Batch> getHasOrderBatch(@Param(value="numId")Integer numId, @Param(value = "startindex") int startindex,
			@Param(value = "pagesize") int pagesize);
}