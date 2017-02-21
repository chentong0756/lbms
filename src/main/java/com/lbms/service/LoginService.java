package com.lbms.service;

import com.lbms.dto.UserDto;

public interface LoginService {
	public Object LoginByName(String id,String password,String power);
	public String GetUserByUserLoginName(String userName);
	public UserDto GetUserInfoByUserName(String userName);
	

}
