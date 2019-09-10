package com.woniuxy.oa.controller;

import java.util.List;

import javax.annotation.PostConstruct;
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

import com.woniuxy.oa.entity.ApplyManage;
import com.woniuxy.oa.entity.PageBean;
import com.woniuxy.oa.entity.User;
import com.woniuxy.oa.service.ApplyManageService;
import com.woniuxy.oa.service.UserService;
import com.woniuxy.oa.utils.PageUtils;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Controller
//定义成会话级别的controller 这样保证线程安全使用rid变量
@Scope("session")
public class ApplyManageController {
	private int rid; 
	
	@Autowired
	ApplyManageService applyManageService;
	@Autowired
	UserService userService;
	
	//@PostConstruct当bean加载完之后，就会执行init方法，并且将list实例化；  
    @PostConstruct  
    public void init(){  
        
    }  

	/**
	 * 查询所有申领信息
	 * @param model
	 * @return
	 */
	@GetMapping("/applyManage")
	public String getALLApplyManages( Model model,HttpServletRequest request,ApplyManage applyManage,int rid) {
		this.rid=rid;
		int pageSize=10;
		int pageIndex= PageUtils.getPageIndex(request);
		PageBean<ApplyManage> pageBean= applyManageService.getAllApplyManageByCondition(applyManage, pageIndex, pageSize,rid);
    	pageBean.setUrl(PageUtils.getUrl(request));		
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("applyManage", applyManage);
		return "system/officeApply";
	}
	/**
	 * 删除某个人的申领信息
	 * @param model
	 * @param amid
	 * @return
	 */
	@DeleteMapping("/applyManage/{amid}")
	public String deleteApplyManage(Model model,@PathVariable("amid") int amid) {
		applyManageService.deleteApplyManage(amid);
		return "redirect:/applyManage?rid="+rid;
	}
	
	/**
	 * 跳转至添加页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/toAddPage")
	public String toAddpage(Model model) {
		List<User> users =userService.getAllUsers();
		model.addAttribute("users", users);
		
		return "system/addApplyManage";
	}
	/**
	 * 添加用户申领信息
	 * @param applyManage
	 * @return
	 */
	@PostMapping("/applyManage")
	public String addApplyManage(ApplyManage applyManage) {
		applyManageService.addApplyManage(applyManage);
		return "redirect:/applyManage?rid="+rid;
	}
	
	/**
	 * 跳转至修改页面
	 * @param model
	 * @param amid
	 * @return
	 */
	@RequestMapping("/toModifyPage/{amid}")
	public String toModifyPage(Model model,@PathVariable("amid") int amid) {
		ApplyManage applyManage=applyManageService.getApplyManageByamid(amid);
		model.addAttribute("applyManage", applyManage);
		return "system/modifyApplyManage";
	}
	
	/**
	 * 修改申领信息
	 * @param applyManage
	 * @return
	 */
	@PutMapping("/applyManage")
	public String modifyApplyManage(ApplyManage applyManage) {
		applyManageService.modifyApplyManage(applyManage);
		return "redirect:/applyManage?rid="+rid;
	}
}
