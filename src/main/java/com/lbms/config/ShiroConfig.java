package com.lbms.config;

import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
	public ShiroFilterFactoryBean shiroFilterFactoryBean(){
		ShiroFilterFactoryBean shiroFilter=new ShiroFilterFactoryBean();
		shiroFilter.setSecurityManager(new DefaultWebSecurityManager());
		shiroFilter.setLoginUrl("/login");
		shiroFilter.setUnauthorizedUrl("/");
		return shiroFilter;
	}
	@Bean
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
		return new DefaultAdvisorAutoProxyCreator();
	}
	@Bean
	public AuthorizationAttributeSourceAdvisor duthorizationAttributeSourceAdvisor(){
		AuthorizationAttributeSourceAdvisor ad=new AuthorizationAttributeSourceAdvisor();
		ad.setSecurityManager(new DefaultWebSecurityManager());
		return ad;
	}
	
}
