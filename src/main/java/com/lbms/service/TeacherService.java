package com.lbms.service;

import java.util.List;

import com.lbms.domain.Batch;
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
	public Batch GetBatById(Integer Id);
	public List<Batch> GetBatchByName(String name);
	public List<Batch> GetBatchByDate(String date);
	public boolean CancelOrder(Integer batchId);
	public List<Batch> orderedBatch();
	public boolean OrderedBatches(Integer teaId,Integer batchId);
}
