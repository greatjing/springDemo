package com.testPlatform.demo.controller;/**
 * Created by guojingjing on 13/9/17.
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.testPlatform.demo.domain.DemoResource;
import com.testPlatform.demo.service.DemoService;
import com.testPlatform.demo.tools.Page;
import com.testPlatform.demo.tools.ServletUtil;
import com.testPlatform.demo.tools.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
//   这是什么作用？？
    public String demo(){
        return "demo-resource";
    }


    // 查询列表
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

    //＊＊＊＊＊
    // 添加功能
    //＊＊＊＊＊
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addDemo(HttpServletRequest request, HttpServletResponse response){
        JSONObject result = new JSONObject();
        String name = request.getParameter("name");
        String title = request.getParameter("title");
        String url = request.getParameter("url");

        //name空的校验
        if(StringUtil.isNull(name)){
            result.put("message", "简介不能为空！");
            result.put("flag", false);
            ServletUtil.createSuccessResponse(200, result, response);
            return;
        }

        //title空的校验
        if(StringUtil.isNull(title)){
            result.put("message", "标题不能为空");
            result.put("flag", false);
            ServletUtil.createSuccessResponse(200, result, response);
            return;
        }

        //url空的校验
        if(StringUtil.isNull(url)){
            result.put("message", "地址不能为空");
            result.put("flag", false);
            ServletUtil.createSuccessResponse(200, result, response);
            return;
        }

        //正常数据入库
        DemoResource demoResource = new DemoResource();
        demoResource.setName(name);
        demoResource.setTitle(title);
        demoResource.setUrl(url);

        int index = demoService.add(demoResource);
        System.out.println("返回添加：" + index);

        if(index>0){
            result.put("message", "添加成功");
            result.put("id", index);
            result.put("flag", true);
        }else{
            result.put("message", "添加失败");
            result.put("flag", false);
        }

        ServletUtil.createSuccessResponse(200, result, response);
    }


    //＊＊＊＊＊
    // 修改功能
    //＊＊＊＊＊
    @RequestMapping( value = "/update", method = RequestMethod.POST)
    public void updateDemo(HttpServletRequest request, HttpServletResponse response){
        JSONObject result = new JSONObject();
        String id = request.getParameter("id");

        //DemoResource demoResource = new DemoResource();
        //应该找出已知id的对象
        DemoResource demoResource = demoService.queryDemoResourceById(Long.valueOf(id));

        String name = request.getParameter("name");
        String title = request.getParameter("title");
        String url = request.getParameter("url");

        if(StringUtil.isNull(name)){
            result.put("message", "简介不能为空！");
            result.put("flag", false);
            ServletUtil.createSuccessResponse(200,result, response);
            return;
        }

        if(StringUtil.isNull(title)){
            result.put("message", "标题不能为空！");
            result.put("flag", false);
            ServletUtil.createSuccessResponse(200, result, response);
            return;
        }

        if(StringUtil.isNull(url)){
            result.put("message", "地址不能为空");
            result.put("flag", false);
            ServletUtil.createSuccessResponse(200, result, response);
            return;
        }

        //正常数据
        demoResource.setName(name);
        demoResource.setTitle(title);
        demoResource.setUrl(url);

        int index = demoService.update(demoResource);
        System.out.println("修改结果是：" + index);

        if(index > 0){
            result.put("message", "修改成功");
            result.put("flag", index);
        }else {
            result.put("message", "修改失败");
            result.put("flag", index);
        }
        ServletUtil.createSuccessResponse(200, result, response);
    }

    //＊＊＊＊＊
    // 删除功能
    //＊＊＊＊＊
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public void deleteDemo(HttpServletRequest request, HttpServletResponse response){
        String ids = request.getParameter("ids");

        JSONObject result = new JSONObject();

        int index = demoService.deleteByIds(ids);

        if (index > 0){
            result.put("message", "删除成功");
            result.put("flag", true);
        }else {
            result.put("message", "删除失败");
            result.put("flag", false);
        }
        ServletUtil.createSuccessResponse(200, result, response);
    }

}
