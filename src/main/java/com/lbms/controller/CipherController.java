package com.lbms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lbms.util.ResultInfo;

@RestController
public class CipherController extends BaseController{
	
	@RequestMapping(value="/cipher/student",method=RequestMethod.POST)
	public ResultInfo UpdateCipherByStudent(@RequestParam("password")String password,@RequestParam("numId")Integer numId){
		ResultInfo resultInfo=new ResultInfo();
		if(studentService.UpdateCipherByStudentId(password, numId)){
			resultInfo.setCode(200);
			resultInfo.setData(ResultInfo.UPDATE_SUCCESS);
			return resultInfo;
		}
		resultInfo.setCode(500);
		resultInfo.setData(ResultInfo.UPDATE_ERROR);
		return resultInfo;
	}
	@RequestMapping(value="/cipher/teacher",method=RequestMethod.POST)
	public ResultInfo UpdateCipherByTeacher(@RequestParam("password")String password,@RequestParam("teaId")Integer teaId){
		ResultInfo resultInfo=new ResultInfo();
		if(teacherService.UpdateCipherByTeacherId(password, teaId)){
			resultInfo.setCode(200);
			resultInfo.setData(ResultInfo.UPDATE_SUCCESS);
			return resultInfo;
		}
		resultInfo.setCode(500);
		resultInfo.setData(ResultInfo.UPDATE_ERROR);
		return resultInfo;
	}
	
	@RequestMapping(value="/cipher/administrator",method=RequestMethod.POST)
	public ResultInfo UpdateCipherByAdministrator(@RequestParam("password")String password,@RequestParam("adId")Integer adId){
		ResultInfo resultInfo=new ResultInfo();
		if(adService.UpdateCipherByAdministratorId(password, adId)){
			resultInfo.setCode(200);
			resultInfo.setData(ResultInfo.UPDATE_SUCCESS);
			return resultInfo;
		}
		resultInfo.setCode(500);
		resultInfo.setData(ResultInfo.UPDATE_ERROR);
		return resultInfo;
	}
}
