package com.lbms.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lbms.domain.Page;
import com.lbms.domain.Item;
import com.lbms.util.ResultInfo;
@RestController
public class ItemController extends BaseController{
	@RequestMapping(value="/item" ,method=RequestMethod.POST,consumes="application/json")
	public ResultInfo Additem(@RequestBody Item item){
		ResultInfo resultInfo=new ResultInfo();
		if(item!=null){
			adService.AddNewItem(item);
			resultInfo.setCode(200);
			resultInfo.setData(ResultInfo.CREATE_SUCCESS);
			
		}else{
			resultInfo.setCode(500);
			resultInfo.setData(ResultInfo.ADD_ERROR);
		}
		return resultInfo;
	}
	
	@RequestMapping(value="/item/page/{currentPage}",method=RequestMethod.GET)
	public ResultInfo GetitemByPage(@PathVariable("currentPage")Integer currentPage){
		ResultInfo resultInfo=new ResultInfo();
		if(currentPage!=null){
			Page page=adService.GetItemByPage(currentPage);
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
	@RequestMapping(value="/item",method=RequestMethod.PUT,consumes="application/json")
	public ResultInfo Updateitem(@RequestBody Item item){
		ResultInfo resultInfo=new ResultInfo();
		if(item!=null){
			if(adService.UpdateItem(item)){
				resultInfo.setCode(200);
				resultInfo.setData(ResultInfo.UPDATE_SUCCESS);
				return resultInfo;
			}
			
		}
		resultInfo.setCode(500);
		resultInfo.setData(ResultInfo.UPDATE_ERROR);
		return resultInfo;
	}
	@RequestMapping(value="/item/{itemId}",method=RequestMethod.DELETE)
	public ResultInfo Deleteitem(@PathVariable("itemId")Integer itemId){
		ResultInfo resultInfo=new ResultInfo();
		if(itemId!=null){
			if(adService.DeleteItemById(itemId)){
				resultInfo.setCode(200);
				resultInfo.setData(ResultInfo.DELETE_SUCCESS);
				return resultInfo;
			}
			
		}
		resultInfo.setCode(500);
		resultInfo.setData(ResultInfo.DELETE_ERROR);
		return resultInfo;
		
	}
	@RequestMapping(value="/item/{itemId}",method=RequestMethod.GET)
	public ResultInfo GetitemById(@PathVariable("itemId")Integer itemId){
		ResultInfo resultInfo=new ResultInfo();
		if(itemId!=null){
			Item item=adService.GetItemById(itemId);
			if(item!=null){
				resultInfo.setCode(200);
				resultInfo.setData(item);
				return resultInfo;
			}
		}
		resultInfo.setCode(500);
		resultInfo.setData(ResultInfo.GET_ERROR);
		return resultInfo;
	}

}
