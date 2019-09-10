package com.woniuxy.oa.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oa.entity.Attendance;
import com.woniuxy.oa.entity.User;

/**
 * insert:对应mapper中的签到动作
 * update：对应mapper中签退动作
 * selectMysel：查询关于自己的考勤信息
 * selectall：查询所有员工的考勤信息，该动作只能为有相关权限的角色才能操作
 * 
 * 
 * @author 廖天驰
 *
 */
public interface AttendanceService {
	public void insert(int uid,String uname);
	public void update(int uid,String uname);
	public List<Attendance> selectMyself(Attendance attendance);
	public List<Attendance> selectall(int did,Attendance attendance);
	public List<Attendance> selectallinall();
	
	

}
