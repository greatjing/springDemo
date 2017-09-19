package com.testPlatform.demo.service.impl;/**
 * Created by guojingjing on 14/9/17.
 */

import com.github.pagehelper.PageHelper;
import com.testPlatform.demo.dao.DemoDao;
import com.testPlatform.demo.dao.DemoMybits;
import com.testPlatform.demo.dao.DemoMybitsXml;
import com.testPlatform.demo.domain.DemoResource;
import com.testPlatform.demo.service.DemoService;
import com.testPlatform.demo.tools.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 ** @description $
 ** Created by guojingjing on 14/9/17. 
 **/
@Service
public class DemoServiceImpl implements DemoService {

//    使用传统jdbc
//    @Autowired
//    DemoDao demoDao;

//    使用注释方式实现
//    @Autowired
//    DemoMybits demoMybits;

//    使用xml配置实现
    @Autowired
    DemoMybitsXml demoMybitsXml;

    @Override
    public int add(DemoResource demoResource){
//        return this.demoDao.add(demoResource);
//        System.out.println("新增信息==" + this.demoMybits.add(demoResource) );
        System.out.println("新增信息==" + this.demoMybitsXml.add(demoResource) );
        return this.demoMybitsXml.add(demoResource);
    }

    @Override
    public int update(DemoResource demoResource) {
//        return this.demoDao.update(demoResource);
//        return this.demoMybits.updateMybatis(demoResource);
        return this.demoMybitsXml.updateMybatis(demoResource);
    }

    @Override
    public int deleteByIds(String[] ids) {
//        return this.demoDao.deleteByIds(ids);
//        return this.demoMybits.deleteByIds(ids);
        return this.demoMybitsXml.deleteByIds(ids);
    }

    @Override
    public DemoResource queryDemoResourceById(long id) {
//        return this.demoDao.queryDemoResourceById(id);
//        return this.demoMybits.queryDemoResourceById(id);
        return this.demoMybitsXml.queryDemoResourceById(id);
    }

    //返回所有数据

//    public Page queryDemoResourceList(Map<String, Object> params) {
//        return this.demoDao.queryDemoResourceList(params);
//    }
    @Override
    public List<DemoResource> queryDemoResourceList(Map<String, Object> params){
        //PageHelper.startPage(Integer.parseInt(params.get("page").toString()), Integer.parseInt((params.get("rows").toString())) );
//        System.out.println("获取页数：" + params.get("page").toString());
//        System.out.println("获取总数" + params.get("rows").toString());
//        System.out.println( Integer.parseInt(params.get("page").toString()) );
//        System.out.println( Integer.parseInt(params.get("rows").toString()) );
        PageHelper.startPage(Integer.parseInt(params.get("page").toString()), Integer.parseInt(params.get("rows").toString()));
        System.out.println("查询结果==" + this.demoMybitsXml.queryDemoList(params));
//        return this.demoMybits.queryDemoResourceList(params);
        return this.demoMybitsXml.queryDemoList(params);
    }
}
