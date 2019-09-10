package com.woniuxy.oa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.oa.entity.AskForLeave;
import com.woniuxy.oa.entity.Schedule;
import com.woniuxy.oa.entity.User;
import com.woniuxy.oa.service.ScheduleService;

@Controller
@RequestMapping("/scheduleController")
public class ScheduleController {

	@Autowired
	@Qualifier("scheduleService")
	private ScheduleService scheduleService;
	
	public void setScheduleService(ScheduleService scheduleService) {
		this.scheduleService = scheduleService;
	}

	//分页查询
	@GetMapping("/dopage")
	public String selectAllSchedule(Model model,Schedule schedule,@RequestParam(value="pageIndex",defaultValue="1")Integer pageIndex ) {
		System.out.println("pageIndex----"+pageIndex);
		int pageSize = 4;
		PageHelper.startPage(pageIndex, pageSize);
		List<Schedule> schedules=scheduleService.selectpage(schedule);
		PageInfo pb=new PageInfo(schedules);
		model.addAttribute("pb", pb);
		return "/system/schedule.html";
	}

	//删除一条数据
	@DeleteMapping("/dodel/{sid}")
	public String delereSchedule(@PathVariable("sid")int sid,Model model) {
		boolean result=scheduleService.deleteOneSchedule(sid);
		return "redirect:/scheduleController/dopage";
	}
	
	//跳转至修改页面
	@GetMapping("/updateSchedule/{sid}")
	public String toUpdateSchedule(@PathVariable("sid")int sid,Model model) {
		Schedule schedule=scheduleService.selectOneSchedule(sid);
		model.addAttribute("schedule", schedule);
		return "/system/scheduleupdate.html";
	}
	
	//修改数据
	@PutMapping("/updateSchedule")
	public String updateSchedule(Schedule schedule) {
		scheduleService.updateOneSchedule(schedule);
		return "redirect:/scheduleController/dopage";
	}
	
	//跳转至添加页面
	@GetMapping("/addSchedule")
	public String toSchedulePage(Model model) {
		List<User> schedules=scheduleService.selectUsers();
		for (User user : schedules) {
			System.out.println(user+"-----");
		}
		model.addAttribute("schedules", schedules);
		return "/system/addSchedule.html";
	}
	
	//添加数据
	@PostMapping("/addSchedule")
	public String insertSchedule(Schedule schedule) {
		System.out.println(schedule.getUname()+":"+schedule.getUid());
		//int uid=scheduleService.selectUid(schedule.getUname());
		//System.out.println(uid);
		schedule.setUid(1);
		scheduleService.insertOneSchedule(schedule);
		return "redirect:/scheduleController/dopage";
	}
}
