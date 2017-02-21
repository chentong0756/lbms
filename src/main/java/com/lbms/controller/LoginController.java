package com.lbms.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lbms.dto.UserDto;
import com.lbms.util.ResultInfo;
@RestController
public class LoginController extends BaseController{
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ResultInfo Login(@RequestParam("userName")String userName,@RequestParam("password")String password){
			ResultInfo resultInfo=new ResultInfo();
		    UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
		    token.setRememberMe(true);
		    Subject subject = SecurityUtils.getSubject();
		    try {
	            subject.login(token);
	            if (subject.isAuthenticated()) {
	            	resultInfo.setCode(200);
	            	resultInfo.setData(ResultInfo.LOGIN_SUCCESS);
	                return resultInfo;
	            } else {
	            	resultInfo.setCode(500);
	            	resultInfo.setData(ResultInfo.PASSWORD_ERROR);
	                return resultInfo;
	            }
	        } catch (IncorrectCredentialsException e) {
	        	resultInfo.setCode(500);
            	resultInfo.setData(ResultInfo.PASSWORD_ERROR);
                return resultInfo;
	        } catch (ExcessiveAttemptsException e) {
	        	resultInfo.setCode(501);
            	resultInfo.setData(ResultInfo.LOGIN_MANY);
                return resultInfo;
	        } catch (LockedAccountException e) {
	        	resultInfo.setCode(502);
            	resultInfo.setData(ResultInfo.USER_LOCK);
                return resultInfo;
	        } catch (DisabledAccountException e) {
	        	resultInfo.setCode(502);
            	resultInfo.setData(ResultInfo.USER_LOCK);
                return resultInfo;
	        } catch (ExpiredCredentialsException e) {
	        	resultInfo.setCode(502);
            	resultInfo.setData(ResultInfo.USER_LOCK);
                return resultInfo;
	        } catch (UnknownAccountException e) {
	        	resultInfo.setCode(502);
            	resultInfo.setData(ResultInfo.USER_LOCK);
                return resultInfo;
	        } catch (UnauthorizedException e) {
	        	resultInfo.setCode(503);
            	resultInfo.setData(ResultInfo.USER_LOCK);
                return resultInfo;
	        }
	}
	@RequestMapping(value="/login/{userName}",method=RequestMethod.GET)
	public ResultInfo GetUserInfoByUserName(@PathVariable("userName")String userName){
		ResultInfo resultInfo=new ResultInfo();
		if(userName!=null){
			UserDto userDto=loginService.GetUserInfoByUserName(userName);
			resultInfo.setCode(200);
			resultInfo.setData(userDto);
			return resultInfo;
		}
		resultInfo.setCode(500);
		resultInfo.setData(ResultInfo.GET_ERROR);
		return resultInfo;
	}

}
