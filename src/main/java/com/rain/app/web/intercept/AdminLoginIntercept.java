package com.rain.app.web.intercept;

import com.rain.app.web.bean.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminLoginIntercept implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果已经登录返回true。
        // 如果没有登录没有登录，可以使用 reponse.send() 跳转页面。后面要跟return false,否则无法结束;

        // 为了测试，打印一句话
        System.out.println("访问了admin下url路径。");
        HttpSession session = request.getSession();

        User user;
        try {
            user = (User) session.getAttribute("user");
            System.out.println(user.toString());
            return true;
        }catch (Exception e){
            user = null;
            response.sendRedirect("/login");
            return false;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
