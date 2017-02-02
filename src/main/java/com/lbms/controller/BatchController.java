package com.lbms.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lbms.domain.Batch;
import com.lbms.domain.Page;
import com.lbms.util.ResultInfo;

@RestController
public class BatchController extends BaseController{
	@RequestMapping(value="/batch" ,method=RequestMethod.POST,consumes="application/json")
	public ResultInfo Addbatch(@RequestBody Batch batch){
		ResultInfo resultInfo=new ResultInfo();
		if(batch!=null){
			adService.AddNewBatch(batch);
			resultInfo.setCode(200);
			resultInfo.setObject(ResultInfo.CREATE_SUCCESS);
			
		}else{
			resultInfo.setCode(500);
			resultInfo.setObject(ResultInfo.ADD_ERROR);
		}
		return resultInfo;
	}
	
	@RequestMapping(value="/batch/page/{currentPage}",method=RequestMethod.GET)
	public ResultInfo GetbatchByPage(@PathVariable("currentPage")Integer currentPage){
		ResultInfo resultInfo=new ResultInfo();
		if(currentPage!=null){
			Page page=adService.GetBatchByPage(currentPage);
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
	@RequestMapping(value="/batch",method=RequestMethod.PUT,consumes="application/json")
	public ResultInfo Updatebatch(@RequestBody Batch batch){
		ResultInfo resultInfo=new ResultInfo();
		if(batch!=null){
			if(adService.UpdateBatch(batch)){
				resultInfo.setCode(200);
				resultInfo.setObject(ResultInfo.UPDATE_SUCCESS);
				return resultInfo;
			}
			
		}
		resultInfo.setCode(500);
		resultInfo.setObject(ResultInfo.UPDATE_ERROR);
		return resultInfo;
	}
	@RequestMapping(value="/batch/{batchId}",method=RequestMethod.DELETE)
	public ResultInfo Deletebatch(@PathVariable("batchId")Integer batchId){
		ResultInfo resultInfo=new ResultInfo();
		if(batchId!=null){
			if(adService.DeleteBatchById(batchId)){
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
