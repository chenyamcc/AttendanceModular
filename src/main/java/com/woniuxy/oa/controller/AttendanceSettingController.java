package com.woniuxy.oa.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.oa.entity.AttendanceSetting;
import com.woniuxy.oa.service.AttendanceSettingService;

/**
 * 
 * 
 * 考勤设置：
 * 设置考勤时间
 * 启用历史考勤记录
 * 删除历史考勤记录
 * @author 廖天驰
 *
 */
@Controller
public class AttendanceSettingController {
	
	@Autowired
	AttendanceSettingService attendanceSettingService;
	
	@ResponseBody
	@RequestMapping("/insertAttendanceSetting")
	public int insert(AttendanceSetting attendanceSetting) {
		
		return attendanceSettingService.insert(attendanceSetting);
	}
	
	@ResponseBody
	@RequestMapping("/updateAttendanceSetting")
	public int update(AttendanceSetting attendanceSetting) {
		
		return attendanceSettingService.update(attendanceSetting);
	}
	
	@RequestMapping("/queryAttendanceSettingOne")
	public String queryone(Map<String,Object> map) {
		AttendanceSetting attendanceSetting=attendanceSettingService.selectone();
		map.put("attendanceSetting",attendanceSetting);
		return "/system/attendanceSetting.html";
	}
	
	@ResponseBody
	@RequestMapping("/queryAttendanceSettingAll")
	public Object queryAll(int pageindex) {
		PageHelper.startPage(pageindex,5);	
		List<AttendanceSetting> list = attendanceSettingService.selectAll();
		PageInfo<AttendanceSetting> po = new PageInfo<>(list,5);
		return po;
	}
	
	
	@RequestMapping("/startone")
	public String startone(int asid) {
		attendanceSettingService.startone(asid);
		return "forward:/queryAttendanceSettingOne";
	}
	
	@RequestMapping("/deleteone")
	public String deleteone(int asid) {
		attendanceSettingService.deleteone(asid);
		return "forward:/queryAttendanceSettingOne";
	}


}
