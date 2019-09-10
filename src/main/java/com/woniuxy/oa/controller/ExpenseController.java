package com.woniuxy.oa.controller;

import com.woniuxy.oa.entity.Expense;
import com.woniuxy.oa.entity.ExpenseFuzzySql;
import com.woniuxy.oa.entity.PageIngBean;
import com.woniuxy.oa.entity.User;
import com.woniuxy.oa.service.ExpenseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;



/**
 * Expense视图控制器(报销)
 * @author Administrator
 *
 */
@RequestMapping("/expense")
@Controller
public class ExpenseController {
	
	@Resource
	ExpenseService expenseService;
	
	/**
	 * 分页:查询所有报销数据(经理权限)
	 * @return
	 */
//	@GetMapping("/show")
//	public String showExpense(HttpServletRequest request,HttpSession session,Model model) {
//		int pageIndex=getPageIndex(request);
//		int pageSize=10;
//		//调用装配的PageBean
//		PageBean<Expense> pb = expenseService.expensePage(pageIndex, pageSize);
//		model.addAttribute("pb", pb);
//		//session.setAttribute("pb", pb);
//		return "/system/apply.html";
//	}
	
//	@GetMapping("/show")
//	public String showExpenseByUname(HttpServletRequest request,HttpSession session,User user,Model model) {
//		int pageIndex=getPageIndex(request);
//		int pageSize=10;
//		//调用装配的PageBean
//		PageBean<User> pb = expenseService.expensePageByUname(pageIndex, pageSize, user);
//		System.out.println(pb);
//		model.addAttribute("pb", pb);
//		return "/system/apply.html";
//	}
	
	@GetMapping("/show")
	public String showExpenseByUname(HttpServletRequest request,HttpSession session,User user,Model model) {
		int pageIndex=getPageIndex(request);
		int pageSize=5;
		//调用装配的PageBean
		PageIngBean<ExpenseFuzzySql> pb =expenseService.expenseFuzzySqlPageByUname(pageIndex, pageSize, user);
		pb.setUrl(getUrl(request));
		model.addAttribute("pb", pb);
		return "system/apply";
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
	 *  删除报销条目(经理权限)
	 * @param exid
	 * @return
	 */
	@DeleteMapping("/delete")
	public String deleteExpenseByExid(int exid) {
		expenseService.deleteExpenseByexid(exid);
		System.out.println("删除的ID号:"+exid);
		return "redirect:/expense/show";
	}
	/**
	 * 点击添加按钮跳转<添加详情页面>
	 * @param model
	 * @return
	 */
	@RequestMapping("/jump")
	public String AddExpenseJump(Model model) {
		List<User> users = expenseService.selectUnameByAll();
		model.addAttribute("users", users);
		return "system/addexpense";
	}
	/**
	 * 添加信息
	 * @param expense
	 * @return
	 */
	@PostMapping("/add")
	public String AddExpense(Expense expense) {
		//通过传下来的姓名找uid
		int uid = expenseService.selectUidbyUname(expense.getUname());
		expense.setUid(uid);
		expense.setUnit("元");
		expense.setAsid(1);//审批状态默认为1(未审批)
		expense.setAtid(3);//最后去数据库查
		expense.setPid(1);//权限默认为1
		expense.setFlag(0);//软删除默认为0
		expenseService.insertExpense(expense);
		System.out.println(expense);
		return "redirect:/expense/show";
	}
	/**
	 * 点击修改按钮跳转<修改详情页面>
	 * @param model
	 * @return
	 */
	@RequestMapping("/jumpupdate")
	public String updateExpenseJump(Model model,int exid) {
		System.out.println(exid);
		model.addAttribute("exid", exid);
		return "system/updateexpense";
	}
	/**
	 * 修改信息
	 * @return
	 */
	@PutMapping("/update")
	public String updateExpense(Expense expense) {
		System.out.println(expense);
		expenseService.updateExpense(expense);
		return "redirect:/expense/show";
	}
}
