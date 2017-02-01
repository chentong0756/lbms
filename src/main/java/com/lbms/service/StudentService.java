package com.lbms.service;

import com.lbms.domain.Page;
import com.lbms.domain.Student;
import com.lbms.domain.Test;

public interface StudentService {
	
	public boolean UpdateStudent(Student student);
	public Page GetHasOrderBatch(Integer num,int currentPage);
	public boolean OrderBatchById(Integer batchId);
	public Test GetTestByNumAndBatch(Integer batchId,Integer numId);
	public Page GetNoticeByPage(Integer currentPage);
	public boolean UpdateCipherByStudentId(String password,Integer numId);
	

}
