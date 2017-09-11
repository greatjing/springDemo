package com.testPlatform.demo.controller;/**
 * Created by guojingjing on 11/9/17.
 */

import com.testPlatform.demo.domain.ThymeleafBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 ** @description $
 ** Created by guojingjing on 11/9/17. 
 **/

@Controller
@RequestMapping("/jsp")
public class jspExerciseController {
    @RequestMapping("")
    public ModelAndView index(){
        System.out.print("**********");
        List<ThymeleafBean> thymeleafBeans = new ArrayList<ThymeleafBean>();
        ThymeleafBean bean = new ThymeleafBean("aa","第一个","http://utest.qq.com/");
        thymeleafBeans.add(bean);

        bean = new ThymeleafBean("bb","第二个", "http://mqc.aliyun.com");
        thymeleafBeans.add(bean);

        bean = new ThymeleafBean("cc", "第三个", "http://mtc.baidu.com");
        thymeleafBeans.add(bean);

        ModelAndView modelAndView = new ModelAndView("index1");
        modelAndView.addObject("jspexercises","thymeleafBeans");

        System.out.print("#####");
        System.out.print(modelAndView);
        System.out.print("&&&&&");
        return modelAndView;
    }
}
