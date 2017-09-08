package com.testPlatform.demo.controller;/**
 * Created by guojingjing on 6/9/17.
 */

import com.testPlatform.demo.domain.ConfigBean;
import com.testPlatform.demo.domain.CustomConfigBean;
import com.testPlatform.demo.service.DBConnectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 ** @description $
 ** Created by guojingjing on 6/9/17. 
 **/
@RestController
public class HelloController {

//    @Value("${com.testPlatform.name}")
//    private String name;
//    @Value("${com.testPlatform.greeting}")
//    private String greetjing;

    @Autowired
    ConfigBean configBean;
    @Autowired
    CustomConfigBean customConfigBean;
    @Autowired
    DBConnectorService dbConnectorService;

    @RequestMapping("/")
    public  String index(){
        return "Hello world1!";
    }

    @RequestMapping("/hello")
    public String hello(){
//		return greeting + name;
//        System.out.print("**********");
//        System.out.print(configBean.getName());
//        System.out.print("@@@@@@@@@@@");
//        System.out.print(configBean.getGreeting());
        return "<H1>"+configBean.getGreeting() + configBean.getName()+"</h1>" ;
    }

    @RequestMapping("/hello2")
    public String hello2(){
        return configBean.getHello2();
    }

    @RequestMapping("/hello3")
    public String hello3(){
        System.out.print("**********");
        System.out.print(customConfigBean.getGreeting());
        System.out.print("**********");
        return customConfigBean.getGreeting() + customConfigBean.getName();
    }

    @RequestMapping("hello4")
    public String hello4(){
        String num = "" + customConfigBean.getNumber();
        String bignum = ""+ customConfigBean.getBignumber();
        String uuid = customConfigBean.getUuid().toString();
        return "num * " + num + "bignum * " + bignum + "uuid * " + uuid;
    }


    @RequestMapping("task")
    public String task(){
        dbConnectorService.config();
        return "properties test";
    }
}
