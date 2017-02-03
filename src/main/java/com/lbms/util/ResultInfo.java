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
	
	
	
	
	private int code;
	private Object object;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	
	

}
