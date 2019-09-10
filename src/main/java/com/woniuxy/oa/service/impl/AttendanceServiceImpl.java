package com.woniuxy.oa.service.impl;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oa.entity.Attendance;
import com.woniuxy.oa.entity.User;
import com.woniuxy.oa.mapper.AttendanceMapper;
import com.woniuxy.oa.mapper.UserMapper;
import com.woniuxy.oa.service.AttendanceService;

/**
 * 
 * 考勤表服务的具体实现类
 * @author 廖天驰
 *
 */
@Service
public class AttendanceServiceImpl implements AttendanceService{
	@Autowired
	AttendanceMapper attendanceMapper;
	@Autowired
	UserMapper userMapper;

	@Override
	public void insert(int uid, String uname) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		Attendance attendance = new Attendance();
		attendance.setUid(uid);
		attendance.setBegintime(date);
		attendance.setUname(uname);
		attendance.setDay(format.format(date));
		attendanceMapper.insert(attendance);

	}

	@Override
	public void update(int uid,String uname) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		Attendance attendance = new Attendance();
		attendance.setUid(uid);
		attendance.setEndtime(date);
		attendance.setUname(uname);
		attendance.setDay(format.format(date));
		attendanceMapper.update(attendance);
		
	}

	@Override
	public List<Attendance> selectMyself(Attendance attendance) {
		
		return attendanceMapper.selectMyself(attendance);
	}

	@Override
	public List<Attendance> selectall(int did,Attendance attendance) {
		
		List<Integer> uidList = userMapper.selectAllUidByDid(did);
		
		return attendanceMapper.selectall(uidList,attendance);
	}

	@Override
	public List<Attendance> selectallinall() {
		
		return attendanceMapper.selectallinall();
	}

}
