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

import com.woniuxy.oa.entity.AskForLeave;
import com.woniuxy.oa.entity.PageBeaning;
import com.woniuxy.oa.entity.User;
import com.woniuxy.oa.service.AskForLeaveService;

@Controller
@RequestMapping("/askForLeaveController")
public class AskForLeaveController {

	@Autowired
	@Qualifier("askForLeaveService")
	private AskForLeaveService askForLeaveService;

	public void setAskForLeaveService(AskForLeaveService askForLeaveService) {
		this.askForLeaveService = askForLeaveService;
	}

	// 拼接URL路径
	private String getUrl(HttpServletRequest request) {
		String contextPath = request.getContextPath();
		String servletPath = request.getServletPath();
		String queryString = request.getQueryString();
		if (queryString != null && queryString.indexOf("&pageIndex=") != -1) {
			queryString = queryString.substring(0, queryString.indexOf("&"));
		}
		return contextPath + servletPath + "?" + queryString;
	}

	// 获取当前页
	private int getPageIndex(HttpServletRequest request) {
		if (request.getParameter("pageIndex") == null || request.getParameter("pageIndex").equals("")) {
			return 1;
		}
		return Integer.parseInt(request.getParameter("pageIndex"));
	}

	//查询及分页
	@GetMapping("/doask")
	public String findAskForLeaveByPage(HttpServletRequest request, HttpServletResponse response,
			Model model,AskForLeave askForLeave) {
		// 获取当前页
		int pageIndex = getPageIndex(request);
		int pageSize = 10;
		PageBeaning<AskForLeave> pb = askForLeaveService.getAskForLeaveByPage(pageIndex, pageSize, askForLeave);
		// 获取路径
		pb.setUrl(getUrl(request));
		model.addAttribute("pb", pb);
		model.addAttribute("askForleave", askForLeave);
		return "/system/leave.html";

	}
	
	//删除一条请假信息
	@DeleteMapping("/dodel/{alid}")
	public String deleteLeave(@PathVariable("alid")int alid,Model model) {
		System.out.println("alid"+alid);
		boolean  result=askForLeaveService.deleteAskForLeave(alid);
		if(result==false) {
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "redirect:/askForLeaveController/doask";
	}
	
	//添加跳转至添加页面
	@GetMapping("/addleave")
	public String toLeavePage(Model model) {
		List<User> users=askForLeaveService.selectUsers();
		model.addAttribute("users", users);
		return "/system/askforleave.html";
	}
	
	//添加请假
	@PostMapping("/addleave")
	public String insertLeaveRow(AskForLeave askForLeave) {
		int uid=askForLeaveService.selectUid(askForLeave.getUname());
		askForLeave.setUid(uid);
		askForLeaveService.insertLeave(askForLeave);
		return "redirect:/askForLeaveController/doask";
	}
	
	//修改跳转至请假页面
	@GetMapping("/updateleave/{alid}")
	public String toUpdateLeavePage(@PathVariable("alid")int alid,Model model) {
		AskForLeave leave=askForLeaveService.selectOneLevae(alid);
		model.addAttribute("leave", leave);
		return "/system/askforleaveupdate.html";
	}
	
	//修改请假条
	@PutMapping("/updateleave")
	public String updateOneLeave(AskForLeave askForLeave) {
		askForLeaveService.updateLevae(askForLeave);
		return "redirect:/askForLeaveController/doask";
	}
}
