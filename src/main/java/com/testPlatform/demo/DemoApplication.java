package com.testPlatform.demo;

import com.alibaba.druid.pool.DruidDataSource;
import com.testPlatform.demo.domain.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;


@SpringBootApplication
//@EnableConfigurationProperties({ConfigBean.class})
public class DemoApplication {

////	@Value("${com.testPlatform.name}")
//	private String name;
////	@Value("${com.testPlatform.greeting}")
//	private String greeting;

	public static void main(String[] args){
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private Environment env;

//	destroyMethod="close"作用：当数据库连接不使用时，就把该连接重新放到数据池中，方便下次使用调用
	@Bean(destroyMethod = "close")
	public DataSource dataSource(){
		DruidDataSource dataSource = new DruidDataSource();
//		配置项
		dataSource.setUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.datasource.username"));//数据库用户名
		dataSource.setPassword(""); //数据库密码
		dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));

		dataSource.setInitialSize(2);  //初始化建立物理连接个数
		dataSource.setMaxActive(20); //最大连接池数量
		dataSource.setMinIdle(0); //最小连接池数量
		dataSource.setMaxWait(60000); //获取连接时最长等待时间（ms）
		dataSource.setValidationQuery("SELECT 1"); //检测连接是否有效sql
		dataSource.setTestOnBorrow(false); //执行validationQuery检测连接是否有效
		dataSource.setTestWhileIdle(true); //建议配置为true，不影响性能，并保证安全性
		dataSource.setPoolPreparedStatements(false); //是否缓存preparedStatement,也就是PSCache
		return dataSource;
	}


}
