package com.woniuxy.oa.controller;

import com.woniuxy.oa.entity.User;
import com.woniuxy.oa.entity.UserInfo;
import com.woniuxy.oa.service.UserService;
import com.woniuxy.oa.utils.PageResult;
import com.woniuxy.oa.vo.UserData;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/**
 * 用户控制器
 * @author 40473
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	/**
	 * 登录方法
	 * @param loginUser
	 * @return string
	 */
	@PostMapping("/login")
	public ModelAndView login(User loginUser,HttpSession session) {
		UsernamePasswordToken token = new UsernamePasswordToken(loginUser.getUsername(),loginUser.getPassword());
		Subject subject = SecurityUtils.getSubject();
		//如果用户没有认证，进行认证
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		if (!subject.isAuthenticated()){
			subject.login(token);
			session.setAttribute("user",subject.getPrincipal());
		}
		return modelAndView;
	}
//		try {
//			User user =userService.loginUser(loginUser);
//			user.setLogintime(new Date());
//			if(user==null) {
//				model.addAttribute("msg", "登陆失败");
//				return "login";
//			}
//			session.setAttribute("user", user);
//			return "redirect:/index";
//		} catch (NullPointerException e) {
//			model.addAttribute("msg", "登陆失败");
//			return "login";
//		}
//	}
	
	/**
	 * 修改密码
	 * @param user
	 * @param model
	 * @return
	 */
	@PostMapping("/modifyPassword")
	public void modifyPassword(User user,Model model,HttpServletResponse response) {		
		
		try {
			userService.modifyUserPassword(user);
			response.getWriter().write("<script type='text/javascript'>window.parent.location.href='/';</script>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@GetMapping("list")
	public ModelAndView list(String name ,Integer age,Integer pageIndex,Integer rows){
		System.out.println(1);
		if (pageIndex == null) {
			pageIndex = 1;
		}
		if (rows ==null) {
			rows =5;
		}
		PageResult<UserData> result = userService.queryUserList(name,age,pageIndex,rows);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("system/userList");
		modelAndView.addObject("result",result);
		return modelAndView;
	}

	@PostMapping("insert")
	public ModelAndView insertUser(User user, UserInfo userInfo) throws Exception {
		userService.insertUser(user,userInfo);
		return list(user.getUname(),null,null,null);
	}
}
