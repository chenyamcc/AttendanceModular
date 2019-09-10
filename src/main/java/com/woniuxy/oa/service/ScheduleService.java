package com.woniuxy.oa.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.woniuxy.oa.entity.PageBeaning;
import com.woniuxy.oa.entity.Schedule;
import com.woniuxy.oa.entity.User;

public interface ScheduleService {


	List<Schedule> selectpage(Schedule schedule);

	boolean deleteOneSchedule(int sid);

	Schedule selectOneSchedule(int sid);

	void updateOneSchedule(Schedule schedule);

	List<Schedule> selectSchedules();

	int selectSid(String uname);

	void insertOneSchedule(Schedule schedule);

	List<User> selectUsers();

	int selectUid(String uname);



	
}
