package com.lbms.filter;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.lbms.dao.CipherMapper;
import com.lbms.domain.Cipher;
import com.lbms.service.LoginService;

public class UserRealm extends AuthorizingRealm{
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private CipherMapper cipherDao;
    /* 
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) { 
    	String user=(String)super.getAvailablePrincipal(principals);
        String currentUserName=loginService.GetUserByUserLoginName(user);
    	SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();  
        if(null!=currentUserName){
        	if(currentUserName.equals("student")){
        		info.addRole("student");
        		info.addStringPermission("student:3");
        	}else if(currentUserName.equals("teacher")){
        		info.addRole("teacher");
        		info.addStringPermission("teacher:2");
        	}else if(currentUserName.equals("admin")){
        		info.addRole("admin");
        		info.addStringPermission("admin:1");
        	}else if(currentUserName.equals("root")){
        		info.addRole("root");
        		info.addStringPermission("root:0");
        	}
        }
        return info;  
    }

    /* 
     * 登录验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        Cipher cipher=cipherDao.LoginValidate(token.getUsername(), token.getUsername());
        if(cipher!=null){
        	if(cipher.getPower().equals("0"))
        		this.setSession("user","root");
        	else if(cipher.getPower().equals("1")){
        		this.setSession("user","admin");
        	}else if(cipher.getPower().equals("2")){
        		this.setSession("user","teacher");
        	}else if(cipher.getPower().equals("3")){
        		this.setSession("user","student");
        	}
        	AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(cipher.getUsername(), cipher.getUsername(), this.getName());
            authcInfo.getCredentials();
            return authcInfo;
        }
        return null;
          
    }
    private void setSession(Object key, Object value){
        Subject currentUser = SecurityUtils.getSubject();
        if(null != currentUser){
            Session session=currentUser.getSession();
            if(null != session){
                session.setAttribute(key, value);
            }
        }
    }

}
