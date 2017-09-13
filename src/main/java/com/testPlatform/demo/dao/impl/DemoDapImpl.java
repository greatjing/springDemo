package com.testPlatform.demo.dao.impl;/**
 * Created by guojingjing on 13/9/17.
 */


import com.testPlatform.demo.dao.DemoDao;
import com.testPlatform.demo.domain.DemoResource;
import com.testPlatform.demo.tools.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.testPlatform.demo.tools.StringUtil;

import java.util.List;
import java.util.Map;

/**
 ** @description $
 ** Created by guojingjing on 13/9/17. 
 **/

//注释Repository是用来给持久层类定义一个名字
@Repository
public class DemoDapImpl implements DemoDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(DemoResource demoResource){
        return jdbcTemplate.update("INSERT INTO demo_resource(name, title, url) values(?, ?, ?)", demoResource.getName(), demoResource.getTitle(), demoResource.getUrl() );
    }

    @Override
    public int update(DemoResource demoResource){
        return jdbcTemplate.update("update demo_resource set name=?, title=?, url=? wher id=?", new Object[]{demoResource.getName(), demoResource.getTitle(), demoResource.getUrl(), demoResource.getId()});
    }

    @Override
    public int deleteByIds(String ids){
        return jdbcTemplate.update("delete from demo_resource where id in("+ids+")");
    }

    @Override
    public DemoResource queryDemoResourceById(Long id){
        List<DemoResource> list = jdbcTemplate.query("select * from demo_resource where id=?", new Object[]{id}, new BeanPropertyRowMapper<>(DemoResource.class));
        if(null != list && list.size()>0){
            DemoResource demoResource = list.get(0);
            return demoResource;
        }else{
            return null;
        }
    }

    @Override
    public Page queryDemoResourceList(Map<String, Object> params){
        StringBuffer sql = new StringBuffer();
        sql.append("select * from demo_resource where 1=1");
        if(!com.testPlatform.demo.tools.StringUtil.isNull((String)params.get("name"))){
            sql.append("and name like '%").append((String) params.get("name")).append("%'");
        }
        if(!StringUtil.isNull((String)params.get("title"))){
            sql.append("and title like '%").append((String) params.get("title")).append("%'");
        }
        Page page = new Page(sql.toString(), Integer.parseInt(params.get("page").toString()), Integer.parseInt(params.get("rows").toString()), jdbcTemplate );
        return page;
    }

}
