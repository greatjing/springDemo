package com.testPlatform.demo.domain;/**
 * Created by guojingjing on 8/9/17.
 */

/**
 ** @description $
 ** Created by guojingjing on 8/9/17. 
 **/
public class ThymeleafBean {
    private String name;
    private String title;
    private String url;

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl(){
        return url;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public ThymeleafBean(String name, String title, String url){
        this.name = name;
        this.title = title;
        this.url = url;
    }
}
