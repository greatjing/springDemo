package com.testPlatform.demo.service;

import com.testPlatform.demo.domain.DemoResource;
import com.testPlatform.demo.tools.Page;

import java.util.Map;

/**
 * Created by guojingjing on 14/9/17.
 */
public interface DemoService {
    int add(DemoResource demoResource);
    int update(DemoResource demoResource);
    int deleteByIds(String ids);
    DemoResource queryDemoResourceById(long id);
    Page queryDemoResourceList(Map<String, Object> params);
}
