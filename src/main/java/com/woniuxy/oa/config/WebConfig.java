package com.woniuxy.oa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: oa
 * @description: 页面跳转
 * @author: Carl
 * @create: 2019-09-03 19:00
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("/system/index/index");
        registry.addViewController("/top").setViewName("/system/index/top");
        registry.addViewController("/menu").setViewName("/system/index/menu");
        registry.addViewController("/content").setViewName("/system/index/content");
        registry.addViewController("/addApplyManage").setViewName("/system/addApplyManage");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/user/addUser").setViewName("/system/addUser");

    }
}
