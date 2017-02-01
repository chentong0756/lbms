package com.lbms.dao;

import com.lbms.domain.Item;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ItemMapper {
    @Delete({
        "delete from item",
        "where itemid = #{itemid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer itemid);

    @Insert({
        "insert into item (itemid, itemname, ",
        "term, coursename)",
        "values (#{itemid,jdbcType=INTEGER}, #{itemname,jdbcType=VARCHAR}, ",
        "#{term,jdbcType=VARCHAR}, #{coursename,jdbcType=VARCHAR})"
    })
    int insert(Item record);

    int insertSelective(Item record);

    @Select({
        "select",
        "itemid, itemname, term, coursename",
        "from item",
        "where itemid = #{itemid,jdbcType=INTEGER}"
    })
    @ResultMap("com.lbms.dao.ItemMapper.BaseResultMap")
    Item selectByPrimaryKey(Integer itemid);

    int updateByPrimaryKeySelective(Item record);

    @Update({
        "update item",
        "set itemname = #{itemname,jdbcType=VARCHAR},",
          "term = #{term,jdbcType=VARCHAR},",
          "coursename = #{coursename,jdbcType=VARCHAR}",
        "where itemid = #{itemid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Item record);
}