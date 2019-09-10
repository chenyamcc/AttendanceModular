package com.woniuxy.oa.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;
import com.woniuxy.oa.entity.Schedule;
import com.woniuxy.oa.entity.User;


public interface ScheduleMapper {

	
	 List<Schedule> selectAllSchedules(@Param("pageIndex")int pageIndex,
			 @Param("pageSize") int pageSize,@Param("schedule") Schedule schedule);
	
	
	int selectTotalRecored(@Param("schedule") Schedule schedule);
	
	List<Schedule> selectAll(@Param("schedule") Schedule schedule);


	boolean deleteScheduleBySid(int sid);


	Schedule selectScheduleBySid(int sid);


	void updateScheduleOne(Schedule schedule);


	List<Schedule> selectSchedulesAll();


	int selectSidByUname(String uname);


	void insertScheduleOne(Schedule schedule);


	List<User> selectAllUsers();


	int selectUidByUname(String uname);

}
