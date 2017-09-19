package com.testPlatform.demo.service.impl;/**
 * Created by guojingjing on 14/9/17.
 */

import com.github.pagehelper.PageHelper;
import com.testPlatform.demo.dao.DemoDao;
import com.testPlatform.demo.dao.DemoMybits;
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

    @Autowired
    DemoDao demoDao;

    @Autowired
    DemoMybits demoMybits;

    @Override
    public int add(DemoResource demoResource){
//        return this.demoDao.add(demoResource);
        System.out.println("新增信息==" + this.demoMybits.add(demoResource) );
        return this.demoMybits.add(demoResource);
    }

    @Override
    public int update(DemoResource demoResource) {
//        return this.demoDao.update(demoResource);
        return this.demoMybits.updateMybatis(demoResource);
    }

    @Override
    public int deleteByIds(String ids) {
        return this.demoDao.deleteByIds(ids);
    }

    @Override
    public DemoResource queryDemoResourceById(long id) {
        return this.demoDao.queryDemoResourceById(id);
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
        //System.out.println("查询结果==" + this.demoMybits.queryDemoResourceList(params));
        return this.demoMybits.queryDemoResourceList(params);
    }
}
