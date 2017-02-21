package com.lbms.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lbms.dao.AdministratorMapper;
import com.lbms.dao.CipherMapper;
import com.lbms.dao.StudentMapper;
import com.lbms.dao.TeacherMapper;
import com.lbms.domain.Cipher;
import com.lbms.dto.UserDto;
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
		if((cipher=cipherDao.LoginValidate(id, password))!=null){
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

	public String GetUserByUserLoginName(String userName){
		if(userName!=null){
			Cipher cipher=cipherDao.GetUserByUserName(userName);
			if(cipher.getPower().equals("0")){
				return "root";
			}else if(cipher.getPower().equals("1")){
				return "admin";
			}else if(cipher.getPower().equals("2")){
				return "teacher";
			}else if(cipher.getPower().equals("3")){
				return "student";
			}
		}
		return null;
	}

	public UserDto GetUserInfoByUserName(String userName) {
		// TODO Auto-generated method stub
		UserDto userDto=null;
		if(userName!=null){
			Cipher cipher=cipherDao.GetUserByUserName(userName);
			if(cipher!=null){
				userDto=new UserDto();
				if(cipher.getPower().equals("0")){
					userDto.setUserId(cipher.getAdmid());
					userDto.setPower("root");
				}else if(cipher.getPower().equals("1")){
					userDto.setUserId(cipher.getAdmid());
					userDto.setPower("admin");
				}else if(cipher.getPower().equals("2")){
					userDto.setUserId(cipher.getTeaid());
					userDto.setPower("teacher");
				}else if(cipher.getPower().equals("3")){
					userDto.setUserId(cipher.getNumid());
					userDto.setPower("student");
				}
			
			userDto.setUserName(userName);
			}
			
		}
		return userDto;
	}
	
	

}
