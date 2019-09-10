package com.woniuxy.oa.config;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.woniuxy.oa.entity.User;
import com.woniuxy.oa.service.UserService;

/**
 * 自定义Realm类
 * @author Administrator
 *
 */
public class UserRealm extends AuthorizingRealm{
	//创建UserService对象
	@Autowired
	UserService userService;
	
	/**
	 * 执行授权的逻辑
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		/**
		 * 1.给资源进行授权(SimpleAuthorizationInfo对象调用里面的
			addStringPermission方法给当前用户添加授权)
		 */
		SimpleAuthorizationInfo inFo = new SimpleAuthorizationInfo();
		
		//2.创建集合可以将多个授权加入到用户中
		Collection<String> permissions = new ArrayList<String>();
		
		//3.获取当前用户
		Subject subject = SecurityUtils.getSubject();
		
		//4.获取从认证中已查出数据的FindUser对象
		User findUser = (User) subject.getPrincipal();
		
		//3.添加授权信息(实际是从数据库中查出来的信息)可以加多个授权
		permissions.add("expense:show");
		
			
		//5.将数据库中查出来的授权信息传授权的方法中
		inFo.addStringPermissions(permissions);
		
		//6.返回加入的授权信息
		return inFo;
	}
	/**
	 * 执行认证的逻辑
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//1.获取token中传下来身信息(就是登录用用户的username
		String principal = (String) token.getPrincipal();
		
		
		//4.调用根据账号找密码的方法(返回是找到数据的findUser对象)
		User findUser = userService.getUserByusername(principal);
		
		//5.判断是否找到密码(如果没有找到,直接返回一个空)
		if(findUser==null) {
			return null;
		}
		
		//6.取出数据库找到的密码
		String findPassword = findUser.getPassword();
		
		//7.创建SimpleAuthenticationInfo
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(findUser, findPassword, "");
		return simpleAuthenticationInfo;
	}

}
