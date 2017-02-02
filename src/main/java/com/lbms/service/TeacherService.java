package com.lbms.service;

import com.lbms.domain.Page;
import com.lbms.domain.Teacher;
import com.lbms.domain.Test;

public interface TeacherService {
	public boolean UpdateTeacher(Teacher teacher);
	public Page GetBatchById(Integer teaId,int currentPage);
	public Page GetHasOrderStudentByBatchId(Integer batId,int currentPage);
	public boolean UpdateTest(Test test);
	public Test GetTestByStudentIdAndBatId(Integer batId,Integer numId);
	public Page GetNoticeByPage(Integer currentPage);
	public boolean UpdateCipherByTeacherId(String password,Integer teaId);
	public Teacher GetTeacherById(Integer teaId);
}
