package com.testPlatform.demo.config;/**
 * Created by guojingjing on 7/9/17.
 */

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 ** @description $
 ** Created by guojingjing on 7/9/17. 
 **/
@Configuration
@ConfigurationProperties(prefix = "com.custom")
@PropertySource("classpath:custom.properties")
public class CustomConfigBean {

    private String name;
    private String greeting;
    private int number;
    private long bignumber;
    private String uuid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public int getNumber(){
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public long getBignumber() {
        return bignumber;
    }

    public void setBignumber(long bignumber) {
        this.bignumber = bignumber;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
