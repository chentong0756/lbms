package com.lbms.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lbms.domain.Page;
import com.lbms.domain.Student;
import com.lbms.util.ResultInfo;

@RestController
public class StudentController extends BaseController{

	@RequestMapping(value="/student" ,method=RequestMethod.POST,consumes="application/json")
	public ResultInfo AddStudent(@RequestBody Student student){
		ResultInfo resultInfo=new ResultInfo();
		String userName=adService.AddStudent(student);
		if(userName!=null){
			resultInfo.setCode(200);
			resultInfo.setObject(userName);
			
		}else{
			resultInfo.setCode(500);
			resultInfo.setObject(ResultInfo.ADD_ERROR);
		}
		return resultInfo;
	}
	@RequestMapping(value="/student/{numId}" ,method=RequestMethod.GET)
	public ResultInfo GetStudentById(@PathVariable("numId")Integer numId){
		ResultInfo resultInfo=new ResultInfo();
		Student student=null;
		if(numId!=null){
			student=studentService.GetStudentById(numId);
			if(student!=null){
				resultInfo.setCode(200);
				resultInfo.setObject(student);
			}
			return resultInfo;
		}
		resultInfo.setCode(500);
		resultInfo.setObject(ResultInfo.GET_ERROR);
		return resultInfo;
		
	}
	@RequestMapping(value="/student/page/{currentPage}",method=RequestMethod.GET)
	public ResultInfo GetStudentByPage(@PathVariable("currentPage")Integer currentPage){
		ResultInfo resultInfo=new ResultInfo();
		if(currentPage!=null){
			Page page=adService.GetStudentByPage(currentPage);
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
	@RequestMapping(value="/student",method=RequestMethod.PUT,consumes="application/json")
	public ResultInfo UpdateStudent(@RequestBody Student student){
		ResultInfo resultInfo=new ResultInfo();
		if(student!=null){
			if(adService.UpdateStudent(student)){
				resultInfo.setCode(200);
				resultInfo.setObject(ResultInfo.UPDATE_SUCCESS);
				return resultInfo;
			}
			
		}
		resultInfo.setCode(500);
		resultInfo.setObject(ResultInfo.UPDATE_ERROR);
		return resultInfo;
	}
	@RequestMapping(value="/student/{numId}",method=RequestMethod.DELETE)
	public ResultInfo DeleteStudent(@PathVariable("numId")Integer numId){
		ResultInfo resultInfo=new ResultInfo();
		if(numId!=null){
			if(adService.DeleteStudentById(numId)){
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
