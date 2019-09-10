package com.woniuxy.oa.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oa.entity.Attendance;

/**
 * 
 * insert:执行签到动作，增加考勤表中信息
 * update：执行签退动作，往表中已有的项中添加endtime信息
 * selectMyself：查询自己的所有考勤记录
 * selectall：查询所有员工的考勤记录
 * @author 廖天驰
 *
 */
public interface AttendanceMapper {
	public void insert(Attendance attendance);
	public void update(Attendance attendance);
	public List<Attendance> selectMyself(@Param("attendance") Attendance attendance);
	public List<Attendance> selectall(@Param("uidList") List<Integer> uidList,
			                          @Param("attendance") Attendance attendance);
	
	public List<Attendance> selectallinall();
	
 
}
