package com.lbms.service;

import com.lbms.domain.Administrator;
import com.lbms.domain.Batch;
import com.lbms.domain.Item;
import com.lbms.domain.Notice;
import com.lbms.domain.Page;
import com.lbms.domain.Student;
import com.lbms.domain.Teacher;

public interface AdministratorService {
	
	public boolean AddNewItem(Item item);
	public boolean UpdateItem(Item item);
	public boolean DeleteItemById(Integer itemId);
	public Page GetItemByPage(int currentPage);
	public Item GetItemById(int itemId);
	
	
	public boolean AddNewBatch(Batch batch);
	public boolean UpdateBatch(Batch batch);
	public boolean DeleteBatchById(Integer batchId);
	public Page GetBatchByPage(int currentPage);
	
	
	public String AddTeacher(Teacher teacher);
	public boolean UpdateTeacher(Teacher teacher);
	public boolean DeleteTeacherById(Integer teacherId);
	public Page GetTeacherByPage(int currentPage);
	public Teacher GetTeacherByName(String name);
	
	
	public String AddStudent(Student student);
	public boolean DeleteStudentById(Integer numId);
	public boolean UpdateStudent(Student student);
	public Page GetStudentByPage(int currentPage);
	public Page GetHasOrderStudent(Integer batId,int currentPage);
	public Page GetStudentByGrade(String grade,int currentPage);
	public Page GetStudentBySpecial(String special,int currentPage);
	
	public boolean AddNotice(Notice notice);
	public boolean DeleteNoticeById(Integer noticeId);
	public boolean UpdateNotice(Notice notice);
	public Page GetNoticeByPage(Integer currentPage);
	
	public String AddNewAdministrator(Administrator ad);
	public boolean UpdateAdministrator(Administrator ad);
	public boolean DeleteAdministratorById(Integer adId);
	public Page GetAdministratorByPage(int currentPage);
	
	public boolean UpdateCipherByAdministratorId(String password,Integer adId);
	public Administrator GetAdById(Integer adId);
	
	
	
	
	
}
