package com.lbms.dao;

import com.lbms.domain.Notice;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface NoticeMapper {
    @Delete({
        "delete from notice",
        "where noticeid = #{noticeid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer noticeid);

    @Insert({
        "insert into notice (noticeid, noticetile, ",
        "noticecontent, date)",
        "values (#{noticeid,jdbcType=INTEGER}, #{noticetile,jdbcType=VARCHAR}, ",
        "#{noticecontent,jdbcType=VARCHAR}, #{date,jdbcType=TIMESTAMP})"
    })
    int insert(Notice record);

    int insertSelective(Notice record);

    @Select({
        "select",
        "noticeid, noticetile, noticecontent, date",
        "from notice",
        "where noticeid = #{noticeid,jdbcType=INTEGER}"
    })
    @ResultMap("com.lbms.dao.NoticeMapper.BaseResultMap")
    Notice selectByPrimaryKey(Integer noticeid);

    int updateByPrimaryKeySelective(Notice record);

    @Update({
        "update notice",
        "set noticetile = #{noticetile,jdbcType=VARCHAR},",
          "noticecontent = #{noticecontent,jdbcType=VARCHAR},",
          "date = #{date,jdbcType=TIMESTAMP}",
        "where noticeid = #{noticeid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Notice record);
}