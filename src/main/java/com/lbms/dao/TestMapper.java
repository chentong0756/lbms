package com.lbms.dao;

import com.lbms.domain.Test;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TestMapper {
    @Delete({
        "delete from test",
        "where testid = #{testid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer testid);

    @Insert({
        "insert into test (testid, batid, ",
        "numid, grade, results, ",
        "date)",
        "values (#{testid,jdbcType=INTEGER}, #{batid,jdbcType=INTEGER}, ",
        "#{numid,jdbcType=INTEGER}, #{grade,jdbcType=VARCHAR}, #{results,jdbcType=INTEGER}, ",
        "#{date,jdbcType=TIMESTAMP})"
    })
    int insert(Test record);

    int insertSelective(Test record);

    @Select({
        "select",
        "testid, batid, numid, grade, results, date",
        "from test",
        "where testid = #{testid,jdbcType=INTEGER}"
    })
    @ResultMap("com.lbms.dao.TestMapper.BaseResultMap")
    Test selectByPrimaryKey(Integer testid);

    int updateByPrimaryKeySelective(Test record);

    @Update({
        "update test",
        "set batid = #{batid,jdbcType=INTEGER},",
          "numid = #{numid,jdbcType=INTEGER},",
          "grade = #{grade,jdbcType=VARCHAR},",
          "results = #{results,jdbcType=INTEGER},",
          "date = #{date,jdbcType=TIMESTAMP}",
        "where testid = #{testid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Test record);
}