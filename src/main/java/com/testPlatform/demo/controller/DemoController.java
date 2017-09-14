package com.testPlatform.demo.controller;/**
 * Created by guojingjing on 13/9/17.
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.testPlatform.demo.service.DemoService;
import com.testPlatform.demo.tools.Page;
import com.testPlatform.demo.tools.ServletUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 ** @description demo controller$
 ** Created by guojingjing on 13/9/17. 
 **/
@Controller
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private DemoService demoService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("")
    public String demo(){
        return "demo-resource";
    }

    @RequestMapping(value = "/queryDemoList", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void queryDemoList(HttpServletRequest request, HttpServletResponse response){
        String page = request.getParameter("page");
        String rows = request.getParameter("rows");

        String name = request.getParameter("name");
        String title = request.getParameter("title");
        //String url = request.getParameter("url");

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("page", page);
        params.put("rows", rows);
        params.put("name", name);
        params.put("title", title);

        Page pageObj = demoService.queryDemoResourceList(params);

        List< Map<String , Object> > demoList = pageObj.getResultList();

        JSONObject jo = new JSONObject() ;
        jo.put("rows", demoList);
        jo.put("total", pageObj.getTotalPages());
        jo.put("records", pageObj.getTotalRows());
        ServletUtil.createSuccessResponse(200, jo, response);
    }
}
