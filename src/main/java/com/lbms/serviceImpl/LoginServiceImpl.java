package com.lbms.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lbms.dao.AdministratorMapper;
import com.lbms.dao.CipherMapper;
import com.lbms.dao.StudentMapper;
import com.lbms.dao.TeacherMapper;
import com.lbms.domain.Cipher;
import com.lbms.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private CipherMapper cipherDao;
	@Autowired
	private StudentMapper studentDao;
	@Autowired
	private TeacherMapper teacherDao;
	@Autowired
	private AdministratorMapper adDao;
	
	public Object LoginByName(String id, String password, String power) {
		// TODO Auto-generated method stub
		Cipher cipher=null;
		int temp=0;
		if((cipher=cipherDao.LoginValidate(id, password, power))!=null){
			if((temp=cipher.getAdmid())!=0){
				return adDao.selectByPrimaryKey(temp);
			}else if((temp=cipher.getNumid())!=0){
				return studentDao.selectByPrimaryKey(temp);
			}else{
				return teacherDao.selectByPrimaryKey(cipher.getTeaid());
			}
		}
		return null;
	}
	
	

}
