package com.woniuxy.oa.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.oa.entity.ExamineManage;
import com.woniuxy.oa.entity.PageBean;
import com.woniuxy.oa.entity.SubscribManage;
import com.woniuxy.oa.entity.User;

import com.woniuxy.oa.service.SubscribManageService;
import com.woniuxy.oa.utils.PageUtils;

@Controller
public class SubscribExamineController {

	@Autowired
	SubscribManageService subscribManageService;

	@GetMapping("/subscribExamine")
	public String getALLSubscribExamine( Model model,HttpServletRequest request,SubscribManage subscribManage,int rid) {
		int pageSize=10;
		int pageIndex= PageUtils.getPageIndex(request);
		PageBean<SubscribManage> pageBean= subscribManageService.getAllSubscribManageByCondition(subscribManage, pageIndex, pageSize,rid);
    	pageBean.setUrl(PageUtils.getUrl(request));		
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("subscribManage", subscribManage);
		return "system/subscribExamine";
	}
	
	/**
	 * 前端点击详情，弹出模态框，向后台发出ajax请求，根据id获取该用户的审批信息
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getsubscribExamine")
	public Object getSubscribExamineByid(int id) {
		return subscribManageService.getSubscribManageBysmid(id);
	}
	
	@ResponseBody
	@RequestMapping("/modifysubscribExamine")
	public Object modifySubscribExamineByid(int smid,int asid,int rid) {
		subscribManageService.modifySubscribManagesAsidBySmid(smid, asid);
		return rid;
	}
}


	





