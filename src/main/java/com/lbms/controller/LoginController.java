package com.lbms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lbms.util.ResultInfo;

public class LoginController extends BaseController{
	
	@RequestMapping(value="/login",method=RequestMethod.POST,consumes="application/json")
	public ResultInfo Login(@RequestParam("userName")String userName,@RequestParam("password")String password,@RequestParam("power")String power){
			ResultInfo resultInfo=new ResultInfo();
			if(userName!=null&&password!=null&&power!=null){
				Object object=loginService.LoginByName(userName, password, power);
				if(object!=null){
					resultInfo.setCode(200);
					resultInfo.setObject(object);
					return resultInfo;
				}
			}
			resultInfo.setCode(500);
			resultInfo.setObject(ResultInfo.PASSWORD_ERROR);
			return resultInfo;
	}

}
