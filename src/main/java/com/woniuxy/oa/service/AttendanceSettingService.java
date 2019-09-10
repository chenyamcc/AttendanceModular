package com.woniuxy.oa.service;

import java.util.List;

import com.woniuxy.oa.entity.AttendanceSetting;

public interface AttendanceSettingService {
	public int insert(AttendanceSetting attendanceSetting);
	public int update(AttendanceSetting attendanceSetting);
	public List<AttendanceSetting> selectAll();
	public AttendanceSetting selectone();
	public void startone(int asid);
	public void deleteone(int asid);

}
