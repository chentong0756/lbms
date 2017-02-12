package com.lbms.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lbms.domain.Test;
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

}
