package com.woniuxy.oa.controller;

import com.woniuxy.oa.service.UserAddressService;
import com.woniuxy.oa.utils.PageResult;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @program: WoniuOA
 * @description: 用户备忘录的控制层
 * @author: Carl
 * @create: 2019-09-06 09:42
 **/
@Controller
@RequestMapping("userAddress")
public class UserAddressController {
    @Resource
    private UserAddressService userAddressService;
    @GetMapping
    public ModelAndView list(String uname,Integer pageIndex,Integer rows){
        if (pageIndex == null) {
            pageIndex =1;
        }
        if (rows ==null) {
            rows =5;
        }
        ModelAndView modelAndView = new ModelAndView();
        PageResult<Map<String,Object>> result = userAddressService.queryUserAddressList(uname,pageIndex,rows);
        modelAndView.setStatus(HttpStatus.OK);
        modelAndView.addObject("result",result);
        modelAndView.setViewName("/system/addressList");
        return modelAndView;
    }
}
