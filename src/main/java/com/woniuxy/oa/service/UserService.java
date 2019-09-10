package com.woniuxy.oa.service;

import com.woniuxy.oa.entity.User;
import com.woniuxy.oa.entity.UserInfo;
import com.woniuxy.oa.utils.PageResult;
import com.woniuxy.oa.vo.UserData;

import java.util.List;

public interface UserService {
	/**
	 * 查询所有用户信息
	 * @return
	 */
	List<User> getAllUsers();
	/**
	 * 根据uid查用户名字
	 * @param uid
	 * @return
	 */
	String getUnameByUid(int uid);
	/**
	 * 根据uid进行登录
	 * @param uid
	 * @return
	 */
	User loginUser(User loginUser);
	
	/**
	 * 根据用户名查询用户
	 */
	User getUserByusername(String username);
	
	/**
	 * 更改用户密码
	 * @param newUser
	 */
	void modifyUserPassword(User newUser);
	/**
	 * 分页查询用户的主要数据
	 * @param name 过滤条件(模糊查询)
	 * @param age 过滤条件(年龄)
	 * @param pageIndex 当前页数
	 * @param rows 当前页面显示的页数
	 * @return 用户数据(主要数据)
	 */
	PageResult<UserData> queryUserList(String name, Integer age, Integer pageIndex, Integer rows);

	/**
	 * 添加用户信息
	 * @param user  用户主要数据
	 * @param userInfo 用户详细信息
	 */
	void insertUser(User user, UserInfo userInfo) throws Exception;
}
