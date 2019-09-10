package com.woniuxy.oa.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.oa.entity.User;
import com.woniuxy.oa.entity.UserInfo;
import com.woniuxy.oa.enums.ExceptionEnum;
import com.woniuxy.oa.exception.UserException;
import com.woniuxy.oa.mapper.UserInfoMapper;
import com.woniuxy.oa.mapper.UserMapper;
import com.woniuxy.oa.service.UserService;
import com.woniuxy.oa.utils.PageResult;
import com.woniuxy.oa.vo.UserData;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	@Resource
	private UserInfoMapper userInfoMapper;
	
	@Override
	public List<User> getAllUsers() {
		
		return userMapper.selectAllUser();
	}
	
	@Override
	public String getUnameByUid(int uid) {
		
		return userMapper.selectUnameByuid(uid);
	}

	/**
	 * 如果没有查找到用户时会抛出NullPointerException异常，
	 * 在controller中处理
	 */
	@Override
	public User loginUser(User loginUser) {
		String username =loginUser.getUsername();
		User user= userMapper.selectUserByUsername(username);
		if(user.getPassword().equals(loginUser.getPassword())) {
			return user;
		}
		return null;
	}

	/**
	 * 更改用户密码
	 */
	@Override
	public void modifyUserPassword(User newUser) {
		
		userMapper.updatePassword(newUser);
		
	}

	@Override
	public User getUserByusername(String username) {
		
		return userMapper.selectUserByUsername(username);
	}
	@Override
	public PageResult<UserData> queryUserList(String name, Integer age, Integer pageIndex, Integer rows) {
		PageHelper.startPage(pageIndex,rows);
		List<UserData> list =  userMapper.queryUserList(name,age);
		if (CollectionUtils.isEmpty(list)){
			throw new UserException(ExceptionEnum.USER_NOT_FIND);
		}
		PageResult<UserData> result = new PageResult<>();
		PageInfo<UserData> userDataPageInfo = new PageInfo<>(list);
		long dataCount = userDataPageInfo.getTotal();
		result.setList(list);
		result.setPageIndex(pageIndex);
		result.setRows(rows);
		result.setDataCount(dataCount);
		result.setPageCount((int)(dataCount%rows==0?dataCount/rows:dataCount/rows+1));
		return result;
	}

	@Override
	public void insertUser(User user, UserInfo userInfo) throws Exception{
		SimpleHash md5Password = new SimpleHash("MD5", "123456", user.getUsername(), 100);
		user.setPassword(md5Password.toString());
		user.setSalt(user.getUsername());
		userMapper.insertSelective(user);
		userInfo.setUiid(user.getUid());
		userInfoMapper.insertSelective(userInfo);
	}
	

}
