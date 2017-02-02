package com.lbms.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lbms.dao.AdministratorMapper;
import com.lbms.dao.BatchMapper;
import com.lbms.dao.CipherMapper;
import com.lbms.dao.ItemMapper;
import com.lbms.dao.NoticeMapper;
import com.lbms.dao.StudentMapper;
import com.lbms.dao.TeacherMapper;
import com.lbms.domain.Administrator;
import com.lbms.domain.Batch;
import com.lbms.domain.Item;
import com.lbms.domain.Notice;
import com.lbms.domain.Page;
import com.lbms.domain.Student;
import com.lbms.domain.Teacher;
import com.lbms.service.AdministratorService;
import com.lbms.util.Const;

@Service
public class AdministratorServiceImpl implements AdministratorService{
	
	@Autowired
	private ItemMapper itemDao;
	@Autowired
	private BatchMapper batchDao;
	@Autowired
	private TeacherMapper teacherDao;
	@Autowired
	private StudentMapper studentDao;
	@Autowired
	private NoticeMapper noticeDao;
	@Autowired
	private AdministratorMapper adDao;
	@Autowired
	private CipherMapper cipherDao;
	
	public boolean AddNewItem(Item item) {
		// TODO Auto-generated method stub
		if(itemDao.insert(item)!=0)
			return true;
		return false;
	}

	public boolean UpdateItem(Item item) {
		// TODO Auto-generated method stub
		if(itemDao.updateByPrimaryKey(item)!=0)
			return true;
		return false;
	}

	public boolean DeleteItemById(Integer itemId) {
		// TODO Auto-generated method stub
		if(itemDao.deleteByPrimaryKey(itemId)!=0)
			return true;
		return false;
	}

	public Page GetItemByPage(int currentPage) {
		// TODO Auto-generated method stub
		int totalRecord=itemDao.getAllRecord();
		int pagesize=Const.INDEX_INFORMATION_PAGE_SIZE;
		Page page=new Page(currentPage,pagesize,totalRecord);
		int startindex=(currentPage-1)*pagesize;
		List<Item> items=itemDao.getItemByPage(startindex, pagesize);
		page.setRecordList(items);
		return page;
	}

	public boolean AddNewBatch(Batch batch) {
		// TODO Auto-generated method stub
		if(batchDao.insert(batch)!=0)
			return true;
		return false;
	}

	public boolean UpdateBatch(Batch batch) {
		// TODO Auto-generated method stub
		if(batchDao.updateByPrimaryKey(batch)!=0)
			return true;
		return false;
	}

	public boolean DeleteBatchById(Integer batchId) {
		// TODO Auto-generated method stub
		if(batchDao.deleteByPrimaryKey(batchId)!=0)
			return true;
		return false;
	}

	public Page GetBatchByPage(int currentPage) {
		// TODO Auto-generated method stub
		int totalRecord=batchDao.getAllRecord();
		int pagesize=Const.INDEX_INFORMATION_PAGE_SIZE;
		Page page=new Page(currentPage,pagesize,totalRecord);
		int startindex=(currentPage-1)*pagesize;
		List<Batch> batches=batchDao.getBatchByPage(startindex, pagesize);
		page.setRecordList(batches);
		return page;
	}

	public boolean AddTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		if(teacherDao.insert(teacher)!=0)
			return true;
		return false;
	}

	public boolean UpdateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		if(teacherDao.updateByPrimaryKey(teacher)!=0)
			return true;
		return false;
	}

	public boolean DeleteTeacherById(Integer teacherId) {
		// TODO Auto-generated method stub
		if(teacherDao.deleteByPrimaryKey(teacherId)!=0)
			return true;
		return false;
	}

	public Page GetTeacherByPage(int currentPage) {
		// TODO Auto-generated method stub
		int totalRecord=teacherDao.getAllRecord();
		int pagesize=Const.INDEX_INFORMATION_PAGE_SIZE;
		Page page=new Page(currentPage,pagesize,totalRecord);
		int startindex=(currentPage-1)*pagesize;
		List<Teacher> teacheres=teacherDao.getTeacherByPage(startindex, pagesize);
		page.setRecordList(teacheres);
		return page;
	}

	public boolean AddStudent(Student student) {
		// TODO Auto-generated method stub
		if(studentDao.insert(student)!=0)
			return true;
		return false;
	}

	public boolean DeleteStudentById(Integer numId) {
		// TODO Auto-generated method stub
		if(studentDao.deleteByPrimaryKey(numId)!=0)
			return true;
		return false;
	}

	public boolean UpdateStudent(Student student) {
		// TODO Auto-generated method stub
		if(studentDao.updateByPrimaryKey(student)!=0)
			return true;
		return false;
	}

	public Page GetStudentByPage(int currentPage) {
		// TODO Auto-generated method stub
		int totalRecord=studentDao.getAllRecord();
		int pagesize=Const.INDEX_INFORMATION_PAGE_SIZE;
		Page page=new Page(currentPage,pagesize,totalRecord);
		int startindex=(currentPage-1)*pagesize;
		List<Student> students=studentDao.getStudentByPage(startindex, pagesize);
		page.setRecordList(students);
		return page;
	}

	public Page GetHasOrderStudent(Integer batId, int currentPage) {
		// TODO Auto-generated method stub
		int totalRecord=studentDao.getAllRecord();
		int pagesize=Const.INDEX_INFORMATION_PAGE_SIZE;
		Page page=new Page(currentPage,pagesize,totalRecord);
		int startindex=(currentPage-1)*pagesize;
		List<Student> students=studentDao.getHasOrderStudent(batId, startindex, pagesize);
		page.setRecordList(students);
		return page;
		
	}

	public boolean AddNotice(Notice notice) {
		// TODO Auto-generated method stub
		if(noticeDao.insert(notice)!=0)
			return true;
		
		return false;
	}

	public boolean DeleteNoticeById(Integer noticeId) {
		// TODO Auto-generated method stub
		if(noticeDao.deleteByPrimaryKey(noticeId)!=0)
			return true;
		return false;
	}

	public boolean UpdateNotice(Notice notice) {
		// TODO Auto-generated method stub
		if(noticeDao.updateByPrimaryKey(notice)!=0)
			return false;
		return false;
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

	public boolean AddNewAdministrator(Administrator ad) {
		// TODO Auto-generated method stub
		if(adDao.insert(ad)!=0)
			return true;
		return false;
	}

	public boolean UpdateAdministrator(Administrator ad) {
		// TODO Auto-generated method stub
		if(adDao.updateByPrimaryKey(ad)!=0)
			return true;
		return false;
	}

	public boolean DeleteAdministratorById(Integer adId) {
		// TODO Auto-generated method stub
		if(adDao.deleteByPrimaryKey(adId)!=0)
			return true;
		return false;
	}

	public Page GetAdministratorByPage(int currentPage) {
		// TODO Auto-generated method stub
		int totalRecord=adDao.getAllRecord();
		int pagesize=Const.INDEX_INFORMATION_PAGE_SIZE;
		Page page=new Page(currentPage,pagesize,totalRecord);
		int startindex=(currentPage-1)*pagesize;
		List<Administrator> administrators=adDao.getAdByPage(startindex, pagesize);
		page.setRecordList(administrators);
		return page;
	}

	public boolean UpdateCipherByAdministratorId(String password, Integer adId) {
		// TODO Auto-generated method stub
		if(cipherDao.updateByAdId(password, adId)!=0)
			return true;
		return false;
	}
	
	
	

}
