package com.woniuxy.oa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniuxy.oa.entity.SubscribManage;
import com.woniuxy.oa.entity.PageBean;
import com.woniuxy.oa.entity.User;
import com.woniuxy.oa.mapper.SubscribManageMapper;
import com.woniuxy.oa.service.SubscribManageService;
import com.woniuxy.oa.service.UserService;
import com.woniuxy.oa.utils.PageUtils;
@Controller
//定义成会话级别的controller 这样保证线程安全使用rid变量
@Scope("session")
public class SubscribManageController {	
		private int rid;
		@Autowired
		SubscribManageService subscribManageService;
		@Autowired
		UserService userService;
		

		/**
		 * 查询所有申领信息
		 * @param model
		 * @return
		 */
		@GetMapping("/subscribManage")
		public String getALLSubscribManages( Model model,HttpServletRequest request,SubscribManage subscribManage,int rid) {
			this.rid=rid;
			int pageSize=10;
			int pageIndex= PageUtils.getPageIndex(request);
			PageBean<SubscribManage> pageBean= subscribManageService.getAllSubscribManageByCondition(subscribManage, pageIndex, pageSize,rid);
	    	pageBean.setUrl(PageUtils.getUrl(request));		
			model.addAttribute("pageBean", pageBean);
			model.addAttribute("subscribManage", subscribManage);
			return "system/subscribManage";
		}
		/**
		 * 删除某个人的申领信息
		 * @param model
		 * @param amid
		 * @return
		 */
		@DeleteMapping("/subscribManage/{amid}")
		public String deleteSubscribManage(Model model,@PathVariable("amid") int amid) {
			subscribManageService.deleteSubscribManage(amid);
			return "redirect:/subscribManage?rid="+rid;
		}
		
		/**
		 * 跳转至添加页面
		 * @param model
		 * @return
		 */
		@RequestMapping("/subscribManage/toAddPage")
		public String toAddpage(Model model) {
			List<User> users =userService.getAllUsers();
			model.addAttribute("users", users);
			return "system/addSubscribManage";
		}
		/**
		 * 添加用户申领信息
		 * @param SubscribManage
		 * @return
		 */
		@PostMapping("/subscribManage")
		public String addSubscribManage(SubscribManage SubscribManage) {
			subscribManageService.addSubscribManage(SubscribManage);
			return "redirect:/subscribManage?rid="+rid;
		}
		
		/**
		 * 跳转至修改页面
		 * @param model
		 * @param amid
		 * @return
		 */
		@RequestMapping("/subscribManage/toModifyPage/{smid}")
		public String toModifyPage(Model model,@PathVariable("smid") int smid) {
			SubscribManage subscribManage=subscribManageService.getSubscribManageBysmid(smid);
			model.addAttribute("subscribManage", subscribManage);
			return "system/modifySubscribManage";
		}
		
		/**
		 * 修改申领信息
		 * @param SubscribManage
		 * @return
		 */
		@PutMapping("/subscribManage")
		public String modifySubscribManage(SubscribManage SubscribManage) {
			subscribManageService.modifySubscribManage(SubscribManage);
			return "redirect:/subscribManage?rid="+rid;
		}
		
	
		
		
}
