package com.testPlatform.demo.config;/**
 * Created by guojingjing on 11/9/17.
 */

import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 ** @description exercise custom webMvnConfigurerAdpter$
 ** Created by guojingjing on 11/9/17. 
 **/

@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter{

    // 设置无效，配置静态资源到classpath
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry){
//        registry.addResourceHandler("/test/**").addResourceLocations("classpath:/test/");
//        super.addResourceHandlers(registry);
//    }


    // 设置无效，配置静态资源到指定的访问路径
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.print("12345");
        registry.addResourceHandler("/test/**").addResourceLocations("file:~/Desktop/demo/src/main/resources/test/");
        super.addResourceHandlers(registry);
    }

//    无必需创建controller类和方法跳转到页面，直接访问就可以跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registration){
        registration.addViewController("toLogin").setViewName("login");
        super.addViewControllers(registration);
    }

}
