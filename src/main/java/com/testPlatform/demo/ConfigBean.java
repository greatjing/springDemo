package com.testPlatform.demo;/**
 * Created by guojingjing on 6/9/17.
 */

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 ** @description $
 ** Created by guojingjing on 6/9/17. 
 **/

@ConfigurationProperties(prefix = "com.testPlatform")
public class ConfigBean {
    private String name ;
    private String greeting ;

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
}
