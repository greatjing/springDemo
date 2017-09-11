package com.testPlatform.demo.controller;/**
 * Created by guojingjing on 11/9/17.
 */

import com.testPlatform.demo.domain.UserBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 ** @description $
 ** Created by guojingjing on 11/9/17. 
 **/

@Controller
public class loginController {
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String ,Object> login(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> map = new HashMap<>();
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        if(!userName.equals("") && password != ""){
            UserBean user = new UserBean(userName, password);
            request.getSession().setAttribute("user", user);
            map.put("result", "1");
        }
        else {
            map.put("result", "0");
        }
        return map;
    }
}
