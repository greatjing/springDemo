package com.testPlatform.demo.controller;/**
 * Created by guojingjing on 8/9/17.
 */

import com.testPlatform.demo.domain.ThymeleafBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 ** @description $
 ** Created by guojingjing on 8/9/17. 
 **/

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafExerciseController {
    @RequestMapping("")
    public ModelAndView index(){
        System.out.print("11111111");
        List<ThymeleafBean> thymeleafBeans = new ArrayList<ThymeleafBean>();
        ThymeleafBean bean = new ThymeleafBean("qq", "腾讯测试平台", "http://utest.qq.com/");
        thymeleafBeans.add(bean);

        bean = new ThymeleafBean("alibaba", "阿里测试平台", "http://mqc.aliyun.com/");
        thymeleafBeans.add(bean);

        bean = new ThymeleafBean("baidu", "百度测试平台", "http://mtc.baidu.com/");
        thymeleafBeans.add(bean);

        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("thymeleafBeans1", thymeleafBeans);

//        System.out.print("00000000");
//        System.out.print(modelAndView);
//        System.out.print("00000000");
        return modelAndView;
    }
}
