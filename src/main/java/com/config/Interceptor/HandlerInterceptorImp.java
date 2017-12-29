package com.config.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class HandlerInterceptorImp implements HandlerInterceptor {

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    //进入Handler方法之前执行
    //可以用于身份认证、身份授权。如果认证没有通过表示用户没有登陆，需要此方法拦截不再往下执行，否则就放行
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        //获取请求的url
        String url = request.getRequestURI().replace(request.getContextPath(), "");

        //如果url需要跳过拦截器，使用下面代码, 示例如下
        if(url.contains("/login")){
            return true;
        }

        //判断session,se
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if(username != null) {
            return true;
        } else {
            return false;
        }
    }

}
