package com.testPlatform.demo.service.impl;/**
 * Created by guojingjing on 14/9/17.
 */

import com.testPlatform.demo.dao.DemoDao;
import com.testPlatform.demo.domain.DemoResource;
import com.testPlatform.demo.service.DemoService;
import com.testPlatform.demo.tools.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 ** @description $
 ** Created by guojingjing on 14/9/17. 
 **/
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    DemoDao demoDao;

    @Override
    public int add(DemoResource demoResource){
        return this.demoDao.add(demoResource);
    }

    @Override
    public int update(DemoResource demoResource) {
        return this.demoDao.update(demoResource);
    }

    @Override
    public int deleteByIds(String ids) {
        return this.demoDao.deleteByIds(ids);
    }

    @Override
    public DemoResource queryDemoResourceById(long id) {
        return this.demoDao.queryDemoResourceById(id);
    }

    @Override
    public Page queryDemoResourceList(Map<String, Object> params) {
        return this.demoDao.queryDemoResourceList(params);
    }


}
