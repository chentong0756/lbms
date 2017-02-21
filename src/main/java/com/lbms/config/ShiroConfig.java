package com.lbms.config;

import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lbms.filter.UserRealm;

@Configuration
public class ShiroConfig {
	@Bean
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
		return new LifecycleBeanPostProcessor();
	}
	@Bean 
	public MemoryConstrainedCacheManager memoryConstrainedCacheManager(){
		return new MemoryConstrainedCacheManager();
	}
	@Bean
	public DefaultWebSecurityManager securityManager(UserRealm userRealm,MemoryConstrainedCacheManager cacheManager){
		DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
		securityManager.setRealm(userRealm);
		securityManager.setCacheManager(cacheManager);
		return securityManager;
	}
	@Bean
	public UserRealm userRealm(){
		return new UserRealm();
	}
	@Bean(name="shiroFilter")
	public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager){
		ShiroFilterFactoryBean shiroFilter=new ShiroFilterFactoryBean();
		shiroFilter.setSecurityManager(securityManager);
		shiroFilter.setLoginUrl("/login");
		shiroFilter.setUnauthorizedUrl("/");
//		String shiroFilterChainDefinitions="/login=anon\n"
//				+ "/administrator=authc,perms[root:0]\n"
//				+ "/student/**=authc,perms[admin:1]\n"
//				+ "/student=perms[user:UPDATE]\n"
//				+ "/student=perms[user:GET]";
//		shiroFilter.setFilterChainDefinitions(shiroFilterChainDefinitions);
		return shiroFilter;
	}
//	@Bean
//	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
//		return new DefaultAdvisorAutoProxyCreator();
//	}
//	@Bean
//	public AuthorizationAttributeSourceAdvisor duthorizationAttributeSourceAdvisor(){
//		AuthorizationAttributeSourceAdvisor ad=new AuthorizationAttributeSourceAdvisor();
//		ad.setSecurityManager(new DefaultWebSecurityManager());
//		return ad;
//	}
	
}
