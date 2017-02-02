package com.lbms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.lbms.service.AdministratorService;
import com.lbms.service.LoginService;
import com.lbms.service.StudentService;
import com.lbms.service.TeacherService;

public class BaseController {
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;
	
	@Autowired
	protected StudentService studentService;
	@Autowired
	protected TeacherService replyService;
	@Autowired
	protected AdministratorService adService;
	@Autowired
	protected LoginService loginService;
	
	@ModelAttribute
	public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
		
		this.request = request;
		this.response = response;
		this.session = request.getSession();
	}

}
