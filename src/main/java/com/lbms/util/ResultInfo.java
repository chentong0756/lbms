package com.lbms.util;

public class ResultInfo {
	public final static String PASSWORD_ERROR="密码错误";
	public final static String ADD_ERROR="添加失败";
	public final static String GET_ERROR="获取失败";
	public final static String UPDATE_ERROR="更新失败";
	public final static String UPDATE_SUCCESS="更新成功";
	public final static String DELETE_ERROR="删除失败";
	public final static String DELETE_SUCCESS="删除成功";
	public final static String CREATE_SUCCESS="创建成功";
	public final static String ORDER_ERROR="预约失败";
	public final static String LOGIN_SUCCESS="登录成功";
	public final static String LOGIN_MANY="登录失败次数过多";
	public final static String USER_LOCK="用户已被锁定";
	public final static String ADD_SUCCESS="添加成功";
	
	
	
	private int code;
	private Object data;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
	

}
