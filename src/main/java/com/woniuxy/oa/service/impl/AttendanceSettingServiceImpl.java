package com.woniuxy.oa.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.woniuxy.oa.entity.AttendanceSetting;
import com.woniuxy.oa.mapper.AttendanceSettingMapper;
import com.woniuxy.oa.service.AttendanceSettingService;


@Service
public class AttendanceSettingServiceImpl implements AttendanceSettingService{
	
	@Autowired
	AttendanceSettingMapper attendanceSettingMapper;

	@Override
	public int insert(AttendanceSetting attendanceSetting) {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		attendanceSetting.setSettime(format.format(date));
		attendanceSettingMapper.setAllUseless();
		return attendanceSettingMapper.insert(attendanceSetting);
	}

	@Override
	public int update(AttendanceSetting attendanceSetting) {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		attendanceSetting.setSettime(format.format(date));
		return attendanceSettingMapper.update(attendanceSetting);
	}

	@Override
	public List<AttendanceSetting> selectAll() {
		return attendanceSettingMapper.selectAll();
	}

	@Override
	public AttendanceSetting selectone() {
		
		return attendanceSettingMapper.selectone();
	}

	@Override
	public void startone(int asid) {
		attendanceSettingMapper.setAllUseless();
		attendanceSettingMapper.startone(asid);
		
	}

	@Override
	public void deleteone(int asid) {
		attendanceSettingMapper.deleteone(asid);
		
	}

	

}
