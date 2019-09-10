package com.woniuxy.oa.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hibernate.validator.constraints.ParameterScriptAssert;

import com.woniuxy.oa.entity.AskForLeave;
import com.woniuxy.oa.entity.User;



public interface AskForLeaveMapper {
	//经理权限，查询所有请假信息
	List<AskForLeave> selectAskForLeaveByAll(@Param("pageIndex")int pageIndex,
			@Param("pageSize") int pageSize,@Param("askforleave")AskForLeave askForLeave);

	int selectTotalRecored(@Param("askforleave")AskForLeave askForLeave);

	boolean deleteAskForLeaveById(@Param("alid")int alid);

	List<User> selectAllUsers();

	void insertAskForLeave(AskForLeave askForLeave);

	int selectUidByUname(String uname);

	AskForLeave selectLeaveByAlid(int alid);

	void updateOneLeave(AskForLeave askForLeave); 

	
}
