package com.lbms.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lbms.domain.Notice;
import com.lbms.domain.Page;
import com.lbms.util.ResultInfo;
@RestController
public class NoticeController extends BaseController{
	@RequestMapping(value="/notice" ,method=RequestMethod.POST,consumes="application/json")
	public ResultInfo Addnotice(@RequestBody Notice notice){
		ResultInfo resultInfo=new ResultInfo();
		boolean flag=adService.AddNotice(notice);
		if(flag!=false){
			resultInfo.setCode(200);
			resultInfo.setData(ResultInfo.ADD_SUCCESS);
			
		}else{
			resultInfo.setCode(500);
			resultInfo.setData(ResultInfo.ADD_ERROR);
		}
		return resultInfo;
	}
	
	@RequestMapping(value="/notice/page/{currentPage}",method=RequestMethod.GET)
	public ResultInfo GetNoticeByPage(@PathVariable("currentPage")Integer currentPage){
		ResultInfo resultInfo=new ResultInfo();
		if(currentPage!=null){
			Page page=adService.GetNoticeByPage(currentPage);
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
	@RequestMapping(value="/notice",method=RequestMethod.PUT,consumes="application/json")
	public ResultInfo Updatenotice(@RequestBody Notice notice){
		ResultInfo resultInfo=new ResultInfo();
		if(notice!=null){
			if(adService.UpdateNotice(notice)){
				resultInfo.setCode(200);
				resultInfo.setData(ResultInfo.UPDATE_SUCCESS);
				return resultInfo;
			}
			
		}
		resultInfo.setCode(500);
		resultInfo.setData(ResultInfo.UPDATE_ERROR);
		return resultInfo;
	}
	@RequestMapping(value="/notice/{noticeId}",method=RequestMethod.DELETE)
	public ResultInfo Deletenotice(@PathVariable("noticeId")Integer noticeId){
		ResultInfo resultInfo=new ResultInfo();
		if(noticeId!=null){
			if(adService.DeleteNoticeById(noticeId)){
				resultInfo.setCode(200);
				resultInfo.setData(ResultInfo.DELETE_SUCCESS);
				return resultInfo;
			}
			
		}
		resultInfo.setCode(500);
		resultInfo.setData(ResultInfo.DELETE_ERROR);
		return resultInfo;
		
	}

}
