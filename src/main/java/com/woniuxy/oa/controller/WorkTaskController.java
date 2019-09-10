package com.woniuxy.oa.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.woniuxy.oa.entity.PageIngBean;
import com.woniuxy.oa.entity.User;
import com.woniuxy.oa.entity.WorkTask;
import com.woniuxy.oa.service.WorkTaskService;

/**
 *  WorkTask视图控制器(工作计划)
 * @author Administrator
 *
 */
@RequestMapping("/worktask")
@Controller
public class WorkTaskController {
	//创建WorkTaskService对象
	@Autowired
	WorkTaskService workTaskService;
	
	@GetMapping("/show")
	public String showWorkTaskAll(HttpServletRequest request,Map<String, Object> map,User user) {
		int pageIndex=getPageIndex(request);
		int pageSize=10;
		PageInfo<WorkTask> pb = workTaskService.workTaskPage(pageIndex, pageSize, user);
		String url = getUrl(request);
		map.put("pb", pb);
		map.put("url", url);
		return "system/work";
	}
	
	
	/**判断显示页码
	 * @param request
	 * @return
	 */
	private int getPageIndex(HttpServletRequest request) {
		if(request.getParameter("pageIndex")==null||request.getParameter("pageIndex").equals("")) {
			return 1;
		}
		return Integer.parseInt(request.getParameter("pageIndex"));
	}
	
	/**
	 * 获取当前页面url
	 * @param request
	 * @return
	 */
	public static String getUrl(HttpServletRequest request) {
		String contextPath = request.getContextPath();//获取上下文路径(资源名)
		String servletPath = request.getServletPath();//获取servlet的地址
		String queryString = request.getQueryString();//获得整个请求参数，不带问号
		
		if(queryString!=null&&queryString.indexOf("&pageIndex=")!=-1){
		//请求的字符串最后一个是当前的页数，而这个页数是需要通过前端来获取的，他在整个请求字符串的最后一个&之后，所以把他拆除掉
		queryString=queryString.substring(0, queryString.lastIndexOf("&")); }
		return contextPath+servletPath+"?"+queryString;
	}
	/**
	 * 删除数据(根据创建来的wid删除整行数据)
	 * @param wtid
	 * @return
	 */
	@DeleteMapping("/delete")
	public String deleteWorkTaskBywtid(int wtid) {
		//System.out.println("删除的Id号:"+wtid);
		workTaskService.deleteworkTask(wtid);
		return "redirect:/worktask/show";
	}
	/**
	 * 添加页跳转
	 * @return
	 */
	@RequestMapping("/addjump")
	public String jumpAddhtml(Map<String, Object> map) {
		//查询所有人的姓名
		List<User> users =  workTaskService.selectUnameAll();
		map.put("users", users);
		return "system/addworktask";
	}
	/**
	 * 添加工作计划
	 * @param workTask
	 * @return
	 */
	@PostMapping("/add")
	public String addWorkTask(WorkTask workTask) {
		//重登录的session中取出
		workTask.setUid(1);
		workTask.setPid(1);
		workTask.setFlag(0);
		workTaskService.insertWorkTask(workTask);
		return "redirect:/worktask/show";
	}
	/**
	 * 点击修改按钮跳转<修改详情页面>
	 * @param model
	 * @return
	 */
	@RequestMapping("/jumpupdate")
	public String updateWorktaskJump(Model model,int wtid) {
		model.addAttribute("wtid", wtid);
		return "system/updateworktask";
	}
	/**
	 * 修改工作计划
	 * @param workTask
	 * @return
	 */
	@PutMapping("/update")
	public String updateWorkTask(WorkTask workTask) {
		workTaskService.updatWorkTask(workTask);
		return "redirect:/worktask/show";
	}
}
