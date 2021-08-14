package com.cxd.config;

import org.springframework.stereotype.Controller;

import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

@Controller
public class MyMvcconfig implements WebMvcConfigurer {

//视图解析器 viewresover  用@bean放入spring  自动装配
//    dispatcherservelet    mvc的核心
    //视图跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/user/emp").setViewName("userChange");
    }
}
