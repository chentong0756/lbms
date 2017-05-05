package com.lbms.service;

import java.util.List;

import com.lbms.domain.Batch;
import com.lbms.domain.Page;
import com.lbms.domain.Student;
import com.lbms.domain.Test;
import com.lbms.dto.SumInformation;

public interface StudentService {
	
	public boolean UpdateStudent(Student student);
	public List<Batch> GetHasOrderBatch(Integer num);
	public boolean OrderBatchById(Integer batchId,Integer numId);
	public Test GetTestByNumAndBatch(Integer batchId,Integer numId);
	public Page GetNoticeByPage(Integer currentPage);
	public boolean UpdateCipherByStudentId(String password,Integer numId);
	public Student GetStudentById(Integer numId);
	public List<Test> getTestByBatch(Integer batId);
	public SumInformation GetSumInformation(String grade,String batchid);
	

}
