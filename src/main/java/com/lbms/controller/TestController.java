package com.lbms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lbms.domain.Test;
import com.lbms.dto.SumInformation;
import com.lbms.util.ResultInfo;

@RestController
public class TestController extends BaseController{
	@RequestMapping(value="/test/{batchId}&{numId}",method=RequestMethod.GET)
	public ResultInfo GetTestByStudentAndBatch(@PathVariable("batchId")Integer batchId,@PathVariable("numId")Integer numId){
		ResultInfo resultInfo=new ResultInfo();
		Test test=null;
		test=studentService.GetTestByNumAndBatch(batchId, numId);
		if(test!=null){
			resultInfo.setCode(200);
			resultInfo.setData(test);
			return resultInfo;
		}
		resultInfo.setCode(500);
		resultInfo.setData(ResultInfo.GET_ERROR);
		return resultInfo;
	}
	@RequestMapping(value="/test",method=RequestMethod.PUT,consumes="application/json")
	public ResultInfo UpdateTest(@RequestBody Test test){
		ResultInfo resultInfo=new ResultInfo();
		if(teacherService.UpdateTest(test)){
			resultInfo.setCode(200);
			resultInfo.setData(ResultInfo.UPDATE_SUCCESS);
			return resultInfo;
		}
		resultInfo.setCode(500);
		resultInfo.setData(ResultInfo.GET_ERROR);
		return resultInfo;
	} 
	@RequestMapping(value="/test/batch/{batchId}",method=RequestMethod.GET)
	public ResultInfo GetTestByBatch(@PathVariable("batchId")Integer batchId){
		ResultInfo resultInfo=new ResultInfo();
		List<Test> test=null;
		test=studentService.getTestByBatch(batchId);
		if(test!=null){
			resultInfo.setCode(200);
			resultInfo.setData(test);
			return resultInfo;
		}
		resultInfo.setCode(500);
		resultInfo.setData(ResultInfo.GET_ERROR);
		return resultInfo;
	}
	@RequestMapping(value="/test/suminformation/{grade}/{batchid}",method=RequestMethod.GET)
	public ResultInfo GetSumInformation(@PathVariable("grade")String grade,@PathVariable("batchid")String batchid){
		ResultInfo resultInfo=new ResultInfo();
		SumInformation informations=studentService.GetSumInformation(grade,batchid);
		System.out.println(grade+"   "+batchid);
		if(informations!=null){
			resultInfo.setCode(200);
			resultInfo.setData(informations);
			return resultInfo;
		}
		resultInfo.setCode(500);
		resultInfo.setData(ResultInfo.GET_ERROR);
		return resultInfo;
	}

}
