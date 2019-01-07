package com.wewin.power_manage.interceptor;

import com.alibaba.dubbo.common.json.JSON;
import com.wewin.power_manage.util.SendMsgUitil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: William
 * @Description: 登陆拦截器
 * @Date: 2018/10/26 17:24
 **/
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println(">>>LoginInterceptor>>>>>>>在请求处理之前进行调用（Controller方法调用之前）");
        System.out.println("session: " +  request.getSession().getAttribute("user"));

        if (request.getRequestURL().indexOf("login") > 0 )
            return true;

        if (request.getSession().getAttribute("user") == null) {
            System.out.println("拦截器拦截，用户没有登陆");
            SendMsgUitil.sendJsonMsg(response, "拦截器拦截，用户没有登陆");
            return false;
        }
        return true;// 只有返回true才会继续向下执行，返回false取消当前请求
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println(">>>LoginInterceptor>>>>>>>请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println(">>>LoginInterceptor>>>>>>>在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
    }

}
