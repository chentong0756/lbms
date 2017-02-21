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
			resultInfo.setData(userName);
			
		}else{
			resultInfo.setCode(500);
			resultInfo.setData(ResultInfo.ADD_ERROR);
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
				resultInfo.setData(student);
			}
			return resultInfo;
		}
		resultInfo.setCode(500);
		resultInfo.setData(ResultInfo.GET_ERROR);
		return resultInfo;
		
	}
	@RequestMapping(value="/student/page/{currentPage}",method=RequestMethod.GET)
	public ResultInfo GetStudentByPage(@PathVariable("currentPage")Integer currentPage){
		ResultInfo resultInfo=new ResultInfo();
		if(currentPage!=null){
			Page page=adService.GetStudentByPage(currentPage);
			if(page!=null){
				resultInfo.setCode(200);
				resultInfo.setData(page);
				return resultInfo;
			}
		}
		resultInfo.setCode(500);
		resultInfo.setData(ResultInfo.GET_ERROR);
		return resultInfo;
	}
	@RequestMapping(value="/student",method=RequestMethod.PUT,consumes="application/json")
	public ResultInfo UpdateStudent(@RequestBody Student student){
		ResultInfo resultInfo=new ResultInfo();
		if(student!=null){
			if(adService.UpdateStudent(student)){
				resultInfo.setCode(200);
				resultInfo.setData(ResultInfo.UPDATE_SUCCESS);
				return resultInfo;
			}
			
		}
		resultInfo.setCode(500);
		resultInfo.setData(ResultInfo.UPDATE_ERROR);
		return resultInfo;
	}
	@RequestMapping(value="/student/{numId}",method=RequestMethod.DELETE)
	public ResultInfo DeleteStudent(@PathVariable("numId")Integer numId){
		ResultInfo resultInfo=new ResultInfo();
		if(numId!=null){
			if(adService.DeleteStudentById(numId)){
				resultInfo.setCode(200);
				resultInfo.setData(ResultInfo.DELETE_SUCCESS);
				return resultInfo;
			}
			
		}
		resultInfo.setCode(500);
		resultInfo.setData(ResultInfo.DELETE_ERROR);
		return resultInfo;
		
	}
	@RequestMapping(value="/student/{batchId}/{currentPage}",method=RequestMethod.GET)
	public ResultInfo GetStudentByBatch(@PathVariable("batchId")Integer batchId,@PathVariable("currentPage")Integer currentPage){
		ResultInfo resultInfo=new ResultInfo();
		Page page=null;
		if(batchId!=null){
			page=teacherService.GetHasOrderStudentByBatchId(batchId, currentPage);
			if(page!=null){
				resultInfo.setCode(200);
				resultInfo.setData(page);
				return resultInfo;
			}
		}
		resultInfo.setCode(500);
		resultInfo.setData(ResultInfo.GET_ERROR);
		return resultInfo;
		
	}
	@RequestMapping(value="/student/page/grade/{grade}&{currentPage}",method=RequestMethod.GET)
	public ResultInfo GetStudentByGrade(@PathVariable("grade")String grade,@PathVariable("currentPage")Integer currentPage){
		ResultInfo resultInfo=new ResultInfo();
		if(currentPage!=null){
			Page page=adService.GetStudentByGrade(grade,currentPage);
			if(page!=null){
				resultInfo.setCode(200);
				resultInfo.setData(page);
				return resultInfo;
			}
		}
		resultInfo.setCode(500);
		resultInfo.setData(ResultInfo.GET_ERROR);
		return resultInfo;
	}
	@RequestMapping(value="/student/page/special/{special}&{currentPage}",method=RequestMethod.GET)
	public ResultInfo GetStudentBySpecial(@PathVariable("special")String specail,@PathVariable("currentPage")Integer currentPage){
		ResultInfo resultInfo=new ResultInfo();
		if(currentPage!=null){
			Page page=adService.GetStudentBySpecial(specail,currentPage);
			if(page!=null){
				resultInfo.setCode(200);
				resultInfo.setData(page);
				return resultInfo;
			}
		}
		resultInfo.setCode(500);
		resultInfo.setData(ResultInfo.GET_ERROR);
		return resultInfo;
	}
}
