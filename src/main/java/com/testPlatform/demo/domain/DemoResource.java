package com.testPlatform.demo.domain;/**
 * Created by guojingjing on 13/9/17.
 */

/**
 ** @description demo实体$
 ** Created by guojingjing on 13/9/17. 
 **/
public class DemoResource {
    private Long id;
    private String name;
    private String title;
    private String url;

    public long getId(){
        System.out.println("111111111111");
        System.out.println(id);
        return id;
    }

    public void setId( Long id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
