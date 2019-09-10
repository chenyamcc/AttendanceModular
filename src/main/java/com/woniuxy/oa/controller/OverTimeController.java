package com.woniuxy.oa.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.oa.entity.Attendance;
import com.woniuxy.oa.entity.OverTime;
import com.woniuxy.oa.entity.User;
import com.woniuxy.oa.service.OverTimeService;

@Controller
public class OverTimeController {
	@Autowired
	OverTimeService overtimeService;
    
	@ResponseBody
	@RequestMapping("/insertOverTime")
	public int insert(HttpServletRequest request,OverTime overtime) {
		//User user = (User) request.getSession().getAttribute("user");
		User user = new User();
		user.setUid(4);
		user.setUname("小王");
		
		return overtimeService.insert(user, overtime);
	}
	
	@ResponseBody
	@RequestMapping("/updateOverTime")
	public int update(HttpServletRequest requset, OverTime overtime) {
		overtimeService.update(overtime);
		return overtimeService.update(overtime);
	}
	
	@RequestMapping("/queryOverTimeSelf")
	public String querySelf(HttpServletRequest request,OverTime overtime,Map<String,Object> map) {
		//User user = (User) request.getSession().getAttribute("user");
		User user = new User();
		user.setUid(3);
		int pageindex=getPageIndex(request);
		String path=getUrl(request);
		PageHelper.startPage(pageindex,5);
		List<OverTime> list = overtimeService.selectSelf(user,overtime);
		PageInfo<OverTime> po=new PageInfo<>(list,5);
		map.put("po",po);
		map.put("url",path);
		
		return "/system/overtime.html";
	}
	
	@RequestMapping("/queryOverTimeAll")
	public String queryAll(HttpServletRequest request,OverTime overtime,Map<String,Object> map) {
		//User user = (User) request.getSession().getAttribute("user");
		User user = new User();
		user.setDid(2);
		int pageindex=getPageIndex(request);
		String path=getUrl(request);
		PageHelper.startPage(pageindex,5);
		List<OverTime> list = overtimeService.selectAll(user,overtime);
		PageInfo<OverTime> po=new PageInfo<>(list,5);
		
		map.put("po",po);
		map.put("url",path);
		return "/system/overtime.html";
	}
	
	
	@ResponseBody
	@RequestMapping("/deleteOverTime")
	public int delete(int oid) {
		return overtimeService.delete(oid);
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
