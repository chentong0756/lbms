package com.lbms.dao;

import com.lbms.domain.Batch;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface BatchMapper {
    @Delete({
        "delete from batch",
        "where batid = #{batid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer batid);

    @Insert({
        "insert into batch (batid, itemid, ",
        "teaid, laboratory, ",
        "date, segmentation, ",
        "sure)",
        "values (#{batid,jdbcType=INTEGER}, #{itemid,jdbcType=INTEGER}, ",
        "#{teaid,jdbcType=INTEGER}, #{laboratory,jdbcType=VARCHAR}, ",
        "#{date,jdbcType=TIMESTAMP}, #{segmentation,jdbcType=VARCHAR}, ",
        "#{sure,jdbcType=BIT})"
    })
    int insert(Batch record);

    int insertSelective(Batch record);

    @Select({
        "select",
        "batid, itemid, teaid, laboratory, date, segmentation, sure",
        "from batch",
        "where batid = #{batid,jdbcType=INTEGER}"
    })
    @ResultMap("com.lbms.dao.BatchMapper.BaseResultMap")
    Batch selectByPrimaryKey(Integer batid);

    int updateByPrimaryKeySelective(Batch record);

    @Update({
        "update batch",
        "set itemid = #{itemid,jdbcType=INTEGER},",
          "teaid = #{teaid,jdbcType=INTEGER},",
          "laboratory = #{laboratory,jdbcType=VARCHAR},",
          "date = #{date,jdbcType=TIMESTAMP},",
          "segmentation = #{segmentation,jdbcType=VARCHAR},",
          "sure = #{sure,jdbcType=BIT}",
        "where batid = #{batid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Batch record);
}