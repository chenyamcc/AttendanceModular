package com.woniuxy.oa.mapper;

import java.util.List;

import com.woniuxy.oa.entity.AttendanceSetting;

public interface AttendanceSettingMapper {
	public int insert(AttendanceSetting attendanceSetting);
	public int update(AttendanceSetting attendanceSetting);
	public List<AttendanceSetting> selectAll();
	public AttendanceSetting selectone();
	public void setAllUseless();
	public void startone(int asid);
	public void deleteone(int asid);

}
