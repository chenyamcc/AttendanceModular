package com.woniuxy.oa.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.oa.entity.Attendance;
import com.woniuxy.oa.entity.User;
import com.woniuxy.oa.service.AttendanceService;

/**
 * 
 * 操作考勤表
 * @author 廖天驰
 *
 */

@Controller
public class AttendanceController {
	@Autowired
	AttendanceService attendanceService;
	
	/*
	 * 
	 * 用于签到动作
	 * 
	 * 
	 * */
	@RequestMapping("/SignIn")
	
	public String  insert(HttpServletRequest request,HttpServletResponse response) {
		//User  user=(User) request.getSession().getAttribute("user");
		attendanceService.insert(3,"王五");
		return "forward:/queryAttendanceSelf";
		
	}
	/*
	 * 
	 * 用于签退动作
	 * 
	 * 
	 * */
	@RequestMapping("/SignOut")
	
	public String update(HttpServletRequest request,HttpServletResponse response) {
		//User  user=(User) request.getSession().getAttribute("user");
		attendanceService.update(3,"王五");
		return "forward:/queryAttendanceSelf";
	}
	
	/*
	 * 用于普通角色查询自己的考勤记录
	 */
	
	@RequestMapping("/queryAttendanceSelf")
	public String queryself(Map<String,Object> map,HttpServletRequest request){
		int pagesize=5;
		//User  user=(User) request.getSession().getAttribute("user");
		String day=(String) request.getParameter("day");
		
		Attendance attendance = new Attendance();
		attendance.setUid(3);
		attendance.setUname("王五");
		attendance.setDay(day);
		int pageindex=getPageIndex(request);
		String path=getUrl(request);
		PageHelper.startPage(pageindex,pagesize);
		List<Attendance> list = attendanceService.selectMyself(attendance);
		PageInfo<Attendance> po=new PageInfo<>(list,5);
		System.out.println(path);
		map.put("po",po);
		map.put("url",path);
		return "/system/attendance.html";
	}
	
	/*
	 * 用于主管及以上角色查询考勤记录
	 */
	@RequestMapping("/queryAttendanceAll")
	public String queryall(HttpServletRequest request,Map<String,Object> map){
		int pagesize=5;
		User  user=(User) request.getSession().getAttribute("user");
		String day=(String) request.getParameter("day");
		String name=(String) request.getParameter("name");
		
		Attendance attendance = new Attendance();
		attendance.setUid(user.getUid());
		attendance.setUname(name);
		attendance.setDay(day);
		int pageindex=getPageIndex(request);
		String path=getUrl(request);
		PageHelper.startPage(pageindex,pagesize);
		List<Attendance> list = attendanceService.selectall(user.getUid(),attendance);
		PageInfo<Attendance> po=new PageInfo<>(list,5);
		map.put("po",po);
		map.put("url",path);
		return "/system/attendance.html";
		
	}
	
	/*
	 * 在执行模糊查询时，该方法会判断当前角色的权限，并执行对应的查询操作
	 * 
	 * */
	@RequestMapping("/queryAttendance")
	public String  query(Map<String,Object> map,HttpServletRequest request){
		User  user=(User) request.getSession().getAttribute("user");
		if(user.getRid()==3) {
			//普通员工
			return queryself(map,request);
		}else {
			//主管即以上角色
			return queryall(request,map);
		}
		
		
	}
	
	/*
	 * 用于获得当前请求路径
	 * 
	 */
	private String getUrl(HttpServletRequest request){
		String contextPath = request.getContextPath();
		String servletPath = request.getServletPath();
		String queryString = request.getQueryString();
		if( queryString!=null && queryString.indexOf("&pageindex=")!=-1) {
			queryString=queryString.substring(0, queryString.indexOf("&pageindex="));
		}
		return contextPath+servletPath+"?"+queryString;
	}
	
	/*
	 * 用于处理当前页数问题
	 * 
	 */
	private int getPageIndex(HttpServletRequest request) {
		if(request.getParameter("pageindex")==null || request.getParameter("pageindex").equals("")) {
			return 1;
		}
		return Integer.parseInt(request.getParameter("pageindex"));
	}
	

}
