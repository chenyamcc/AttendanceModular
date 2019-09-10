package com.woniuxy.oa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.oa.entity.Schedule;
import com.woniuxy.oa.entity.User;
import com.woniuxy.oa.mapper.ScheduleMapper;
import com.woniuxy.oa.service.ScheduleService;

@Service("scheduleService")
public class ScheduleServiceImp implements ScheduleService{

	@Autowired
	@Qualifier("scheduleMapper")
	ScheduleMapper scheduleMapper;
	
	public void setScheduleMapper(ScheduleMapper scheduleMapper) {
		this.scheduleMapper = scheduleMapper;
	}


	@Override
	public List<Schedule> selectpage(Schedule schedule) {
		List<Schedule> schedules=scheduleMapper.selectAll(schedule);
		return schedules;
	}

	//删除一条数据
	@Override
	public boolean deleteOneSchedule(int sid) {
		boolean result=scheduleMapper.deleteScheduleBySid(sid);
		if(result) {
			return true;
		}
		return false;
	}

	//修改一条数据，先查询该数据id
	@Override
	public Schedule selectOneSchedule(int sid) {
		Schedule schedule=scheduleMapper.selectScheduleBySid(sid);
		return schedule;
	}

	//修改一条数据
	@Override
	public void updateOneSchedule(Schedule schedule) {
		scheduleMapper.updateScheduleOne(schedule);
	}

	//查询
	@Override
	public List<Schedule> selectSchedules() {
		List<Schedule> schedules=scheduleMapper.selectSchedulesAll();
		return schedules;
	}

	//查询姓名获取id，添加一条数据
	@Override
	public int selectSid(String uname) {
		int sid=scheduleMapper.selectSidByUname(uname);
		return sid;
	}

	//添加一条数据
	@Override
	public void insertOneSchedule(Schedule schedule) {
		scheduleMapper.insertScheduleOne(schedule);
	}


	@Override
	public List<User> selectUsers() {
		List<User> users=scheduleMapper.selectAllUsers();
		return users;
	}


	@Override
	public int selectUid(String uname) {
		int uid=scheduleMapper.selectUidByUname(uname);
		return uid;
	}
	

	


}
