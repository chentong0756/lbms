package com.lbms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lbms.dao.CipherMapper;
import com.lbms.dao.NoticeMapper;
import com.lbms.dao.StudentMapper;
import com.lbms.dao.TestMapper;
import com.lbms.domain.Batch;
import com.lbms.domain.Notice;
import com.lbms.domain.Page;
import com.lbms.domain.Student;
import com.lbms.domain.Test;
import com.lbms.dto.SumInformation;
import com.lbms.service.StudentService;
import com.lbms.util.Const;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentMapper studentDao;
	@Autowired
	private TestMapper testDao;
	@Autowired
	private NoticeMapper noticeDao;
	@Autowired
	private CipherMapper cipherDao;
	
	public boolean UpdateStudent(Student student) {
		// TODO Auto-generated method stub
		if(studentDao.updateByPrimaryKey(student)!=0)
			return true;
		return false;
	}

	public List<Batch> GetHasOrderBatch(Integer num) {
		// TODO Auto-generated method stub
		List<Batch> batches=studentDao.getHasOrderBatch(num);
		return batches;
	}

	public boolean OrderBatchById(Integer batchId,Integer numId) {
		// TODO Auto-generated method stub
		if(batchId!=null&&numId!=null){
			Test test=new Test();
			test.setBatid(batchId);
			test.setNumid(numId);
			testDao.insert(test);
			return true;
			
		}
		return false;
	}

	public Test GetTestByNumAndBatch(Integer batchId, Integer numId) {
		// TODO Auto-generated method stub
		Test test=null;
		test=testDao.selectByNumAndBatch(batchId, numId);
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

	public boolean UpdateCipherByStudentId(String password, Integer numId) {
		// TODO Auto-generated method stub
		if(password!=null&&numId!=null){
			cipherDao.updateByNumId(password, numId);
			return true;
		}
			
		
		return false;
	}

	public Student GetStudentById(Integer numId) {
		// TODO Auto-generated method stub
		return studentDao.selectByPrimaryKey(numId);
		
	}

	public List<Test> getTestByBatch(Integer batId){
		return testDao.selectByBatch(batId);
	}

	public SumInformation GetSumInformation(String grade,String batchid) {
		// TODO Auto-generated method stub
		SumInformation sumInformation=null;
		if(grade!=null){
			sumInformation=new SumInformation();
			sumInformation.setAverage(testDao.getAverageByGrade(grade,batchid));
			sumInformation.setGrade(grade);
			sumInformation.setHigh(testDao.getHighByGrade(grade,batchid));
			sumInformation.setLow(testDao.getLowByGrade(grade,batchid));
		}
		
		return sumInformation;
	}
	

}
