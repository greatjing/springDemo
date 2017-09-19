package com.testPlatform.demo.dao;

import com.testPlatform.demo.domain.DemoResource;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by guojingjing on 19/9/17.
 */
@Mapper
public interface DemoMybitsXml {
    int add(DemoResource demoResource);
    int updateMybatis(DemoResource demoResource);
    int deleteByIds(String[] ids);
    DemoResource queryDemoResourceById(long id);
    public List<DemoResource> queryDemoList(Map<String, Object> params);
}
