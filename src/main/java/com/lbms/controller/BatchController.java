package com.lbms.controller;

import java.util.List;

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
			resultInfo.setData(ResultInfo.CREATE_SUCCESS);
			
		}else{
			resultInfo.setCode(500);
			resultInfo.setData(ResultInfo.ADD_ERROR);
		}
		return resultInfo;
	}

	@RequestMapping(value="/batch/{batId}",method=RequestMethod.GET)
	public ResultInfo GetbatchById(@PathVariable("batId")Integer batId){
		ResultInfo resultInfo=new ResultInfo();
		if(batId!=null){
			Batch batch=teacherService.GetBatById(batId);
			if(batch!=null){
				resultInfo.setCode(200);
				resultInfo.setData(batch);
				return resultInfo;
			}
		}
		resultInfo.setCode(500);
		resultInfo.setData(ResultInfo.GET_ERROR);
		return resultInfo;
	}
	
	@RequestMapping(value="/batch/page/{currentPage}",method=RequestMethod.GET)
	public ResultInfo GetbatchByPage(@PathVariable("currentPage")Integer currentPage){
		ResultInfo resultInfo=new ResultInfo();
		if(currentPage!=null){
			Page page=adService.GetBatchByPage(currentPage);
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
	@RequestMapping(value="/batch",method=RequestMethod.PUT,consumes="application/json")
	public ResultInfo Updatebatch(@RequestBody Batch batch){
		ResultInfo resultInfo=new ResultInfo();
		if(batch!=null){
			if(adService.UpdateBatch(batch)){
				resultInfo.setCode(200);
				resultInfo.setData(ResultInfo.UPDATE_SUCCESS);
				return resultInfo;
			}
			
		}
		resultInfo.setCode(500);
		resultInfo.setData(ResultInfo.UPDATE_ERROR);
		return resultInfo;
	}
	@RequestMapping(value="/batch/{batchId}",method=RequestMethod.DELETE)
	public ResultInfo Deletebatch(@PathVariable("batchId")Integer batchId){
		ResultInfo resultInfo=new ResultInfo();
		if(batchId!=null){
			if(adService.DeleteBatchById(batchId)){
				resultInfo.setCode(200);
				resultInfo.setData(ResultInfo.DELETE_SUCCESS);
				return resultInfo;
			}
			
		}
		resultInfo.setCode(500);
		resultInfo.setData(ResultInfo.DELETE_ERROR);
		return resultInfo;
		
	}
	@RequestMapping(value="/batch/student/{batchId}&{numId}",method=RequestMethod.PUT)
	public ResultInfo OrderBatch(@PathVariable("batchId")Integer batchId,@PathVariable("numId")Integer numId){
		ResultInfo resultInfo=new ResultInfo();
		if(batchId!=null&&numId!=null){
			if(studentService.OrderBatchById(batchId, numId)){
				resultInfo.setCode(200);
				resultInfo.setData(ResultInfo.CREATE_SUCCESS);
				return resultInfo;
			}
		}
		resultInfo.setCode(500);
		resultInfo.setData(ResultInfo.ORDER_ERROR);
		return resultInfo;
				
	}
	@RequestMapping(value="/batch/student/{numId}",method=RequestMethod.GET)
	public ResultInfo GetBatchByStudent(@PathVariable("numId")Integer numId){
		ResultInfo resultInfo=new ResultInfo();
		List<Batch> batches=null;
		if(numId!=null){
			batches=studentService.GetHasOrderBatch(numId);
			if(batches!=null){
				resultInfo.setCode(200);
				resultInfo.setData(batches);
				return resultInfo;
			}
		}
		resultInfo.setCode(500);
		resultInfo.setData(ResultInfo.GET_ERROR);
		return resultInfo;
				
	}
	@RequestMapping(value="/batch/teacher/{teaId}&{currentPage}",method=RequestMethod.GET)
	public ResultInfo GetBatchByTeacher(@PathVariable("teaId")Integer teaId,@PathVariable("currentPage")Integer currentPage){
		ResultInfo resultInfo=new ResultInfo();
		Page batches=null;
		if(teaId!=null){
			batches=teacherService.GetBatchById(teaId, currentPage);
			if(batches!=null){
				resultInfo.setCode(200);
				resultInfo.setData(batches);
				return resultInfo;
			}
		}
		resultInfo.setCode(500);
		resultInfo.setData(ResultInfo.GET_ERROR);
		return resultInfo;
				
	}
	@RequestMapping(value="/batch/itemname/{name}",method=RequestMethod.GET)
	public ResultInfo GetBatchByName(@PathVariable("name")String name){
		ResultInfo resultInfo=new ResultInfo();
		List<Batch> batches=null;
		if(name!=null){
			batches=teacherService.GetBatchByName(name);
			if(batches!=null){
				resultInfo.setCode(200);
				resultInfo.setData(batches);
				return resultInfo;
			}
		}
		resultInfo.setCode(500);
		resultInfo.setData(ResultInfo.GET_ERROR);
		return resultInfo;
	}
	
	@RequestMapping(value="/batch/date/{time}",method=RequestMethod.GET)
	public ResultInfo GetBatchByDate(@PathVariable("time")String date){
		ResultInfo resultInfo=new ResultInfo();
		List<Batch> batches=null;
		if(date!=null){
			batches=teacherService.GetBatchByDate(date);
			if(batches!=null){
				resultInfo.setCode(200);
				resultInfo.setData(batches);
				return resultInfo;
			}
		}
		resultInfo.setCode(500);
		resultInfo.setData(ResultInfo.GET_ERROR);
		return resultInfo;
	}
	
	@RequestMapping(value="/batch/needapprove",method=RequestMethod.GET)
	public ResultInfo GetNeedApprove(){
		ResultInfo resultInfo=new ResultInfo();
		List<Batch> batches=null;
		batches=adService.getNeedApprove();
		if(batches!=null){
			resultInfo.setCode(200);
			resultInfo.setData(batches);
		}else{
			resultInfo.setCode(500);
			resultInfo.setData(ResultInfo.GET_ERROR);
		}
		return resultInfo;
	}
	@RequestMapping(value="/batch/approve/{batchId}",method=RequestMethod.GET)
	public ResultInfo ApproveApply(@PathVariable("batchId")String batchId){
		ResultInfo resultInfo=new ResultInfo();
		if(adService.approveApp(Integer.valueOf(batchId))){
			resultInfo.setCode(200);
			resultInfo.setData("");
		}else{
			resultInfo.setCode(500);
			resultInfo.setData("");
		}
		return resultInfo;
	}
	@RequestMapping(value="/batch/teacherorder",method=RequestMethod.GET)
	public ResultInfo TeacherHasOrder(){
		ResultInfo resultInfo=new ResultInfo();
		List<Batch> batches=null;
		batches=adService.getStudentNeedOrder();
		if(batches!=null){
			resultInfo.setCode(200);
			resultInfo.setData(batches);
		}else{
			resultInfo.setCode(500);
			resultInfo.setData(ResultInfo.GET_ERROR);
		}
		return resultInfo;
	}
}
