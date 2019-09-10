package com.woniuxy.oa.controller;

import com.woniuxy.oa.service.UserInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @program: WoniuOA
 * @description: 用户详情的控制层
 * @author: Carl
 * @create: 2019-09-05 16:26
 **/
@Controller
@RequestMapping("userInfo")
public class UserInfoController {
    @Resource
    private UserInfoService userInfoService;
    @GetMapping("{id}")
    public ModelAndView userInfo(@PathVariable("id") Integer uid){
        ModelAndView modelAndView = new ModelAndView();
        Map<String,Object> userInfo = userInfoService.queryUserInfoByUid(uid);
        modelAndView.setStatus(HttpStatus.OK);
        modelAndView.addObject("userInfo",userInfo);
        modelAndView.setViewName("system/userInfo");
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateUserInfo(@PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView();
        Map<String, Object> map = userInfoService.queryUserInfoByUid(id);
        modelAndView.addObject("userInfo",map);
        modelAndView.setStatus(HttpStatus.OK);
        modelAndView.setViewName("system/updateUserInfo");
        return modelAndView;
    }
}
