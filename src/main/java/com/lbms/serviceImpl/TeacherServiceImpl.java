package com.lbms.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lbms.dao.BatchMapper;
import com.lbms.dao.CipherMapper;
import com.lbms.dao.NoticeMapper;
import com.lbms.dao.StudentMapper;
import com.lbms.dao.TeacherMapper;
import com.lbms.dao.TestMapper;
import com.lbms.domain.Batch;
import com.lbms.domain.Notice;
import com.lbms.domain.Page;
import com.lbms.domain.Student;
import com.lbms.domain.Teacher;
import com.lbms.domain.Test;
import com.lbms.service.TeacherService;
import com.lbms.util.Const;

public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private TeacherMapper teacherDao;
	@Autowired
	private BatchMapper batchDao;
	@Autowired
	private StudentMapper studentDao;
	@Autowired
	private TestMapper testDao;
	@Autowired
	private NoticeMapper noticeDao;
	@Autowired
	private CipherMapper cipherDao;
	
	public boolean UpdateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		if(teacher!=null){
			teacherDao.updateByPrimaryKey(teacher);
			return true;
		}
			
		return false;
	}

	public Page GetBatchById(Integer teaId, int currentPage) {
		// TODO Auto-generated method stub
		int totalRecord=batchDao.getAllRecord();
		int pagesize=Const.INDEX_INFORMATION_PAGE_SIZE;
		Page page=new Page(currentPage,pagesize,totalRecord);
		int startindex=(currentPage-1)*pagesize;
		List<Batch> batches=batchDao.getBatchByTeaId(teaId, startindex, pagesize);
		page.setRecordList(batches);
		return page;
	}

	public Page GetHasOrderStudentByBatchId(Integer batId, int currentPage) {
		// TODO Auto-generated method stub
		int totalRecord=studentDao.getAllRecord();
		int pagesize=Const.INDEX_INFORMATION_PAGE_SIZE;
		Page page=new Page(currentPage,pagesize,totalRecord);
		int startindex=(currentPage-1)*pagesize;
		List<Student> students=studentDao.getHasOrderStudent(batId, startindex, pagesize);
		page.setRecordList(students);
		return page;
		
	}

	public boolean UpdateTest(Test test) {
		// TODO Auto-generated method stub
		if(test!=null){
			testDao.insert(test);
			return true;
		}
		return false;
	}

	public Test GetTestByStudentIdAndBatId(Integer batId, Integer numId) {
		// TODO Auto-generated method stub
		Test test=null;
		if(batId!=null&&numId!=null){
			test=testDao.selectByNumAndBatch(batId, numId);
		}
		return test;
	}

	public Page GetNoticeByPage(Integer currentPage) {
		// TODO Auto-generated method stub
		int totalRecord=noticeDao.getAllRecord();
		int pagesize=Const.INDEX_INFORMATION_PAGE_SIZE;
		Page page=new Page(currentPage,pagesize,totalRecord);
		int startindex=(currentPage-1)*pagesize;
		List<Notice> notices=noticeDao.getNoticeByPage(startindex, pagesize);
		page.setRecordList(notices);
		return page;
	}

	public boolean UpdateCipherByTeacherId(String password, Integer teaId) {
		// TODO Auto-generated method stub
		if(password!=null&&teaId!=null){
			cipherDao.updateByTeaId(password, teaId);
			return true;
		}
		return false;
	}

	public Teacher GetTeacherById(Integer teaId) {
		// TODO Auto-generated method stub
		return teacherDao.selectByPrimaryKey(teaId);
	}
	
	

}
