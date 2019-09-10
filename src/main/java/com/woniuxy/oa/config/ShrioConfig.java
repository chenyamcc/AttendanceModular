package com.woniuxy.oa.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shiro配置类
 * @author Administrator
 *
 */
//1.在shiro配置配上打上注解(让系统知道它是个配置类)
@Configuration
public class ShrioConfig {
	/**
	 * 4.创建ShiroFilterFactroyBean
	 */
	@Bean
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		//设置安全管理器
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		/**
		 * 添加Shiro内置过滤器(拦截页面)
		 */
		//2.创建一个装入过滤规则的Map集合,为了所有排序需要有序的LinkHasMap
		Map<String, String> filterMap = new LinkedHashMap<String, String>();
		//3.加入拦截页面及规则
//		filterMap.put("/user/add", "authc");
//		filterMap.put("/user/update", "authc");
		//放行test页面
		//放行login页面
		filterMap.put("/user/login", "anon");
		//放行noPermission页面(未授权跳转的方法)
		filterMap.put("/user/noPermission", "anon");
		//拦截user文件夹下的所有页面
		filterMap.put("/logout", "logout");
		filterMap.put("/**", "authc");

		/**
		 * 添加授权过滤器(报销)
		 */
		//经理权限
//		filterMap.put("/expense/show", "perms[expense:show]");
//		//<主管>权限
//		filterMap.put("/expense/show", "perms[expense:show2]");
//		//<员工>权限
//		filterMap.put("/expense/show", "perms[expense:show3]");



		//设置未授权跳转的页面
		shiroFilterFactoryBean.setUnauthorizedUrl("/user/noPermission");
		//4.添加拦截后跳转的页面
		shiroFilterFactoryBean.setLoginUrl("/login.html");

		//添加登出方法

		//1.将过滤规则装入到setFilterChainDefinitionMap方法中
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
		return shiroFilterFactoryBean;
	}
	/**
	 * 3.创建DefaultWebSecurityManager 
	 */
	@Bean(name="securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		//关联一个Realm
		securityManager.setRealm(userRealm);
		return securityManager;
	}
	/**
	 * 2.创建Realm对象
	 *
	 */
	@Bean(name="userRealm")
	public UserRealm getRealm(){
		return new UserRealm();
	}
	/**
	 * 配置ShiroDialect,用于shiro标签配合使用
	 * @return
	 */
	@Bean
	public ShiroDialect getShiroDialect() {
		return new ShiroDialect();
	}
}
