package com.woniuxy.oa.mapper;

import com.woniuxy.oa.entity.User;
import com.woniuxy.oa.vo.UserData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
	/**
	 * 查询所有用户信息
	 * @return
	 */
	List<User> selectAllUser();
	/**
	 * 根据用户id查询用户名字
	 * @param uid
	 * @return
	 */
	String selectUnameByuid(int uid);
	/**
	 * 根据用户账号查询用户信息
	 * @param username
	 * @return
	 */
	User selectUserByUsername(String username);
	 
	void updatePassword(User newUser);
	
	List<Integer> selectAllUidByDid(int did);

	int deleteByPrimaryKey(Integer uid);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer uid);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	List<UserData> queryUserList(@Param("name") String name, @Param("age") Integer age);
}
