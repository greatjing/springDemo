package com.testPlatform.demo.dao;

import com.testPlatform.demo.domain.DemoResource;
import com.testPlatform.demo.tools.Page;

import java.util.Map;

/**
 * Created by guojingjing on 13/9/17.
 */
public interface DemoDao {
    int add(DemoResource demoResource);
    int update(DemoResource demoResource);
    int deleteByIds(String ids);
    DemoResource queryDemoResourceById(Long id);
    Page queryDemoResourceList(Map<String, Object> params);
}
