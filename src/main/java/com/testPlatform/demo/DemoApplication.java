package com.testPlatform.demo;

import com.testPlatform.demo.config.ConfigBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@EnableConfigurationProperties({ConfigBean.class})
public class DemoApplication {

////	@Value("${com.testPlatform.name}")
//	private String name;
////	@Value("${com.testPlatform.greeting}")
//	private String greeting;

	public static void main(String[] args){
		SpringApplication.run(DemoApplication.class, args);
	}


}
