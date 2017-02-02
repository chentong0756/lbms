package com.lbms.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lbms.domain.Page;
import com.lbms.domain.Teacher;
import com.lbms.util.ResultInfo;

@RestController
public class TeacherController extends BaseController{
	@RequestMapping(value="/teacher" ,method=RequestMethod.POST,consumes="application/json")
	public ResultInfo Addteacher(@RequestBody Teacher teacher){
		ResultInfo resultInfo=new ResultInfo();
		String userName=adService.AddTeacher(teacher);
		if(userName!=null){
			resultInfo.setCode(200);
			resultInfo.setObject(userName);
			
		}else{
			resultInfo.setCode(500);
			resultInfo.setObject(ResultInfo.ADD_ERROR);
		}
		return resultInfo;
	}
	@RequestMapping(value="/teacher/{teaId}" ,method=RequestMethod.GET)
	public ResultInfo GetteacherById(@PathVariable("teaId")Integer teaId){
		ResultInfo resultInfo=new ResultInfo();
		Teacher teacher=null;
		if(teaId!=null){
			teacher=teacherService.GetTeacherById(teaId);
			if(teacher!=null){
				resultInfo.setCode(200);
				resultInfo.setObject(teacher);
			}
			return resultInfo;
		}
		resultInfo.setCode(500);
		resultInfo.setObject(ResultInfo.GET_ERROR);
		return resultInfo;
		
	}
	@RequestMapping(value="/teacher/page/{currentPage}",method=RequestMethod.GET)
	public ResultInfo GetteacherByPage(@PathVariable("currentPage")Integer currentPage){
		ResultInfo resultInfo=new ResultInfo();
		if(currentPage!=null){
			Page page=adService.GetTeacherByPage(currentPage);
			if(page!=null){
				resultInfo.setCode(200);
				resultInfo.setObject(page);
				return resultInfo;
			}
		}
		resultInfo.setCode(500);
		resultInfo.setObject(ResultInfo.GET_ERROR);
		return resultInfo;
	}
	@RequestMapping(value="/teacher",method=RequestMethod.PUT,consumes="application/json")
	public ResultInfo Updateteacher(@RequestBody Teacher teacher){
		ResultInfo resultInfo=new ResultInfo();
		if(teacher!=null){
			if(teacherService.UpdateTeacher(teacher)){
				resultInfo.setCode(200);
				resultInfo.setObject(ResultInfo.UPDATE_SUCCESS);
				return resultInfo;
			}
			
		}
		resultInfo.setCode(500);
		resultInfo.setObject(ResultInfo.UPDATE_ERROR);
		return resultInfo;
	}
	@RequestMapping(value="/teacher/{teaId}",method=RequestMethod.DELETE)
	public ResultInfo Deleteteacher(@PathVariable("numId")Integer teaId){
		ResultInfo resultInfo=new ResultInfo();
		if(teaId!=null){
			if(adService.DeleteTeacherById(teaId)){
				resultInfo.setCode(200);
				resultInfo.setObject(ResultInfo.DELETE_SUCCESS);
				return resultInfo;
			}
			
		}
		resultInfo.setCode(500);
		resultInfo.setObject(ResultInfo.DELETE_ERROR);
		return resultInfo;
		
	}
}
