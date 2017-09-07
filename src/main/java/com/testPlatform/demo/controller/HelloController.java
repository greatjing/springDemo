package com.testPlatform.demo.controller;/**
 * Created by guojingjing on 6/9/17.
 */

import com.testPlatform.demo.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @RequestMapping("/")
    public  String index(){
        return "Hello world1!";
    }

    @RequestMapping("/hello")
    public String hello(){
//		return greeting + name;
        System.out.print("**********");
        System.out.print(configBean.getName());
        System.out.print("@@@@@@@@@@@");
        System.out.print(configBean.getGreeting());
        return "<H1>"+configBean.getGreeting() + configBean.getName()+"</h1>" ;
    }
}
