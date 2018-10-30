package com.wewin.power_manage.configure;

import com.wewin.power_manage.interceptor.LoginInterceptor;
import com.wewin.power_manage.interceptor.SwaggerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: William
 * @Description:
 * @Date: 2018/10/26 17:02
 **/
@Configuration
public class WebMvcConfigure extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        List<String> list = new ArrayList<>();
//        list.add("/Manager/addManager");
//        list.add("/Manager/deleteManager");
//        list.add("/Manager/updateManager");
//        list.add("Manager/quit");
//        list.add("/Manager/selectAll");
        list.add("/Manager/*");
        list.add("/Device/*");

        //注册拦截器 拦截规则
        //多个拦截器时 以此添加 执行顺序按添加顺序
        registry.addInterceptor(new SwaggerInterceptor()).addPathPatterns("/swagger-ui.html");
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns(list);
        super.addInterceptors(registry);
    }

}
