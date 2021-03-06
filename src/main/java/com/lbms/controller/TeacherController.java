package com.lbms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lbms.domain.Batch;
import com.lbms.domain.Page;
import com.lbms.domain.Teacher;
import com.lbms.util.ResultInfo;

@RestController
public class TeacherController extends BaseController{
	@RequestMapping(value="/teacher" ,method=RequestMethod.POST,consumes="application/json")
	public ResultInfo Addteacher(@RequestBody Teacher teacher){
		ResultInfo resultInfo=new ResultInfo();
		System.out.println(teacher.getUsername());
		String userName=adService.AddTeacher(teacher);
		if(userName!=null){
			resultInfo.setCode(200);
			resultInfo.setData(userName);
			
		}else{
			resultInfo.setCode(500);
			resultInfo.setData(ResultInfo.ADD_ERROR);
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
				resultInfo.setData(teacher);
			}
			return resultInfo;
		}
		resultInfo.setCode(500);
		resultInfo.setData(ResultInfo.GET_ERROR);
		return resultInfo;
		
	}
	@RequestMapping(value="/teacher/page/{currentPage}",method=RequestMethod.GET)
	public ResultInfo GetTeacherByPage(@PathVariable("currentPage")Integer currentPage){
		ResultInfo resultInfo=new ResultInfo();
		if(currentPage!=null){
			Page page=adService.GetTeacherByPage(currentPage);
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
	@RequestMapping(value="/teacher",method=RequestMethod.PUT,consumes="application/json")
	public ResultInfo Updateteacher(@RequestBody Teacher teacher){
		ResultInfo resultInfo=new ResultInfo();
		if(teacher!=null){
			if(teacherService.UpdateTeacher(teacher)){
				resultInfo.setCode(200);
				resultInfo.setData(ResultInfo.UPDATE_SUCCESS);
				return resultInfo;
			}
			
		}
		resultInfo.setCode(500);
		resultInfo.setData(ResultInfo.UPDATE_ERROR);
		return resultInfo;
	}
	@RequestMapping(value="/teacher/{teaId}",method=RequestMethod.DELETE)
	public ResultInfo Deleteteacher(@PathVariable("teaId")Integer teaId){
		ResultInfo resultInfo=new ResultInfo();
		if(teaId!=null){
			if(adService.DeleteTeacherById(teaId)){
				resultInfo.setCode(200);
				resultInfo.setData(ResultInfo.DELETE_SUCCESS);
				return resultInfo;
			}
			
		}
		resultInfo.setCode(500);
		resultInfo.setData(ResultInfo.DELETE_ERROR);
		return resultInfo;
		
	}
	@RequestMapping(value="/teacher/name/{name}",method=RequestMethod.GET)
	public ResultInfo GetTeacherByName(@PathVariable("name")String name){
		ResultInfo resultInfo=new ResultInfo();
		Teacher page=null;
		if(name!=null){
			page=adService.GetTeacherByName(name);
			if(page!=null){
				resultInfo.setCode(200);
				resultInfo.setData(page);
			}
			return resultInfo;
		}
		resultInfo.setCode(500);
		resultInfo.setData(ResultInfo.GET_ERROR);
		return resultInfo;
		
	}
	@RequestMapping(value="/teacher/cancel/{batchId}",method=RequestMethod.GET)
	public ResultInfo CancelOrderByBatchId(@PathVariable("batchId")String batchId){
		ResultInfo resultInfo=new ResultInfo();
	
		if(batchId!=null){
			if(teacherService.CancelOrder(Integer.valueOf(batchId))){
				resultInfo.setCode(200);
				resultInfo.setData("");
			}else{
				resultInfo.setCode(500);
				resultInfo.setData("");
			}
			
		}
		return resultInfo;
		
	}
	@RequestMapping(value="/teacher/ordered",method=RequestMethod.GET)
	public ResultInfo getOrdered(){
		ResultInfo resultInfo=new ResultInfo();
		Page page=new Page(1, 10, 10);
		List<Batch> batches=null;
		batches=teacherService.orderedBatch();
		if(batches!=null){
			page.setRecordList(batches);
			resultInfo.setCode(200);
			resultInfo.setData(page);
		}else{
			resultInfo.setCode(500);
			resultInfo.setData(ResultInfo.GET_ERROR);
		}
		return resultInfo;
		
	}
	@RequestMapping(value="/teacher/make/{teaId}/{batchId}",method=RequestMethod.GET)
	public ResultInfo OrderedBatch(@PathVariable("teaId")String teaId,@PathVariable("batchId")String batchId){
			ResultInfo resultInfo=new ResultInfo();
			if(teaId!=null&&batchId!=null){
				if(teacherService.OrderedBatches(Integer.valueOf(teaId), Integer.valueOf(batchId))){
					resultInfo.setCode(200);
					resultInfo.setData("");
				}else{
					resultInfo.setCode(500);
					resultInfo.setData("");
				}
				
				
			}
			return resultInfo;
	}
}
