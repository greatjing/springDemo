package com.testPlatform.demo.dao;

import com.testPlatform.demo.domain.DemoResource;
import com.testPlatform.demo.service.DemoService;
import com.testPlatform.demo.tools.StringUtil;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by guojingjing on 18/9/17.
 */
@Component
@Mapper
public interface DemoMybits {
    @Insert("insert into demo_resource(name,title,url)  values(#{name},#{title},#{url})")
    int add(DemoResource demoResource);

    @Update("update demo_resource set name=#{name}, title=#{title}, url=#{url} where id=#{id}")
    int updateMybatis(DemoResource demoResource);

    @DeleteProvider(type = DemoSqlBuilder.class, method = "deleteByids")
    int deleteByIds(@Param("ids") String[] ids);

    @Select("select * from demo_resource where id=#{id}")
    @Results(id = "demoMap", value = {
            @Result(column = "id", property = "id", javaType = long.class),
            @Result(column = "name", property = "name", javaType = String.class),
            @Result(column = "title", property = "title", javaType = String.class)
    })
    DemoResource queryDemoResourceById(@Param("id") Long id);

    @SelectProvider(type = DemoSqlBuilder.class, method = "queryDemoResourceByParams")
    List<DemoResource> queryDemoResourceList(Map<String , Object> params);

    class DemoSqlBuilder{
        public String queryDemoResourceByParams(final Map<String, Object> params){
            StringBuffer sql = new StringBuffer();
            sql.append("select * from demo_resource where 1=1");
            if(!StringUtil.isNull((String)params.get("name"))){
                sql.append(" and name like '%").append((String) params.get("name")).append("%'");
            }
            if(!StringUtil.isNull((String) params.get("title"))){
                sql.append(" and name like '%").append((String) params.get("title")).append("%'");
            }
            System.out.println("查询");
            System.out.println("查询sql==" + sql.toString());
            return sql.toString();
        }

        public String deleteByids(@Param("ids") final String[] ids ){
            StringBuffer sql = new StringBuffer();
            sql.append("DELETE FROM demo_resource where id in (");
            System.out.println("*****");
            System.out.println(ids);
            System.out.println("1111");
            for (int i=0; i<ids.length-1; i++){
                if (i==ids.length-1){
                    sql.append(ids[i]);
                }else{
                    sql.append(ids[i]).append(",");
                }
            }

            sql.append(")");
            System.out.println("删除sql==" + sql.toString());
            return sql.toString();
        }

    }

}
