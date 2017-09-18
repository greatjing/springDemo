package com.testPlatform.demo.domain;/**
 * Created by guojingjing on 6/9/17.
 */

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 ** @description $
 ** Created by guojingjing on 6/9/17. 
 **/
@Configuration
@ConfigurationProperties(prefix = "com.testPlatform")
public class ConfigBean {
    private String name ;
    private String greeting ;
    private String hello2;

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting){
        this.greeting = greeting;
    }

    public String getHello2() {
        return hello2;
    }

    public void setHello2(String hello2) {
        this.hello2 = hello2;
    }
}
