package com.lbms.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.lbms.domain.Cipher;

public interface CipherMapper {
    @Delete({
        "delete from cipher",
        "where cipid = #{cipid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer cipid);

    @Insert({
        "insert into cipher (cipid, admid, ",
        "teaid, numid, cipher, ",
        "power, username)",
        "values (#{cipid,jdbcType=INTEGER}, #{admid,jdbcType=INTEGER}, ",
        "#{teaid,jdbcType=INTEGER}, #{numid,jdbcType=INTEGER}, #{cipher,jdbcType=VARCHAR}, ",
        "#{power,jdbcType=VARCHAR}, #{username,jdbcType=VARCHAR})"
    })
    int insert(Cipher record);

    int insertSelective(Cipher record);

    @Select({
        "select",
        "cipid, admid, teaid, numid, cipher, power, username",
        "from cipher",
        "where cipid = #{cipid,jdbcType=INTEGER}"
    })
    @ResultMap("com.lbms.dao.CipherMapper.BaseResultMap")
    Cipher selectByPrimaryKey(Integer cipid);

    int updateByPrimaryKeySelective(Cipher record);

    @Update({
        "update cipher",
        "set admid = #{admid,jdbcType=INTEGER},",
          "teaid = #{teaid,jdbcType=INTEGER},",
          "numid = #{numid,jdbcType=INTEGER},",
          "cipher = #{cipher,jdbcType=VARCHAR},",
          "power = #{power,jdbcType=VARCHAR},",
          "username = #{username,jdbcType=VARCHAR}",
        "where cipid = #{cipid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Cipher record);
    

	 @Update({
	        "update cipher",
	        "set cipher = #{cipher,jdbcType=VARCHAR} ",
	        "where admid = #{adId,jdbcType=INTEGER}"
	    })
	    int updateByAdId(@Param("cipher")String cipher, @Param("adId")Integer adId);
	    @Update({
	        "update cipher",
	        "set cipher = #{cipher,jdbcType=VARCHAR} ",
	        "where numid = #{numid,jdbcType=INTEGER}"
	    })
	    int updateByNumId(@Param("cipher")String cipher, @Param("numid")Integer numId);
	    @Update({
	        "update cipher",
	        "set cipher = #{cipher,jdbcType=VARCHAR} ",
	        "where teaid = #{teaId,jdbcType=INTEGER}"
	    })
	    int updateByTeaId(@Param("cipher")String cipher, @Param("teaId")Integer teaId);
	    
	    Cipher LoginValidate(@Param("userName")String userName,@Param("password")String password);
	    Cipher GetUserByUserName(@Param("userName")String userName);
	    
}