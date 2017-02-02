package com.lbms.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lbms.domain.Page;
import com.lbms.domain.Administrator;
import com.lbms.util.ResultInfo;

@RestController
public class AdministratorController extends BaseController{
	@RequestMapping(value="/administrator" ,method=RequestMethod.POST,consumes="application/json")
	public ResultInfo AddAdministrator(@RequestBody Administrator administrator){
		ResultInfo resultInfo=new ResultInfo();
		String userName=adService.AddNewAdministrator(administrator);
		if(userName!=null){
			resultInfo.setCode(200);
			resultInfo.setObject(userName);
			
		}else{
			resultInfo.setCode(500);
			resultInfo.setObject(ResultInfo.ADD_ERROR);
		}
		return resultInfo;
	}
	@RequestMapping(value="/administrator/{adId}" ,method=RequestMethod.GET)
	public ResultInfo GetAdministratorById(@PathVariable("adId")Integer adId){
		ResultInfo resultInfo=new ResultInfo();
		Administrator administrator=null;
		if(adId!=null){
			administrator=adService.GetAdById(adId);
			if(administrator!=null){
				resultInfo.setCode(200);
				resultInfo.setObject(administrator);
			}
			return resultInfo;
		}
		resultInfo.setCode(500);
		resultInfo.setObject(ResultInfo.GET_ERROR);
		return resultInfo;
		
	}
	@RequestMapping(value="/administrator/page/{currentPage}",method=RequestMethod.GET)
	public ResultInfo GetAdministratorByPage(@PathVariable("currentPage")Integer currentPage){
		ResultInfo resultInfo=new ResultInfo();
		if(currentPage!=null){
			Page page=adService.GetAdministratorByPage(currentPage);
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
	@RequestMapping(value="/administrator",method=RequestMethod.PUT,consumes="application/json")
	public ResultInfo UpdateAdministrator(@RequestBody Administrator administrator){
		ResultInfo resultInfo=new ResultInfo();
		if(administrator!=null){
			if(adService.UpdateAdministrator(administrator)){
				resultInfo.setCode(200);
				resultInfo.setObject(ResultInfo.UPDATE_SUCCESS);
				return resultInfo;
			}
			
		}
		resultInfo.setCode(500);
		resultInfo.setObject(ResultInfo.UPDATE_ERROR);
		return resultInfo;
	}
	@RequestMapping(value="/administrator/{adId}",method=RequestMethod.DELETE)
	public ResultInfo DeleteAdministrator(@PathVariable("adId")Integer adId){
		ResultInfo resultInfo=new ResultInfo();
		if(adId!=null){
			if(adService.DeleteAdministratorById(adId)){
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
