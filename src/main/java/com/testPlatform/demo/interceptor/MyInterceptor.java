package com.testPlatform.demo.interceptor;/**
 * Created by guojingjing on 11/9/17.
 */

import com.testPlatform.demo.domain.UserBean;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 ** @description 拦截器$
 ** Created by guojingjing on 11/9/17. 
 **/
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag = true;

//        String ip = request.getRemoteAddr();
//        long startTime = System.currentTimeMillis();
//        request.setAttribute("requestStartTime", startTime);
//        HandlerMethod handlerMethod = (HandlerMethod) handler;
//        Method method = handlerMethod.getMethod();
//        System.out.println("用户:"+ip+",访问目标:"+method.getDeclaringClass().getName() + "." + method.getName());


        UserBean userBean = (UserBean)request.getSession().getAttribute("user");
        flag = true;
//        if(null == userBean){
//            response.sendRedirect("toLogin");
//            flag = false;
//        }
//        else {
//            flag = true;
//        }
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception{

    }
}

