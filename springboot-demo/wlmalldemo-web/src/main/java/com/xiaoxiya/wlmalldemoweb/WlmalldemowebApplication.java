package com.xiaoxiya.wlmalldemoweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * mapperscan注解扫描生成的接口路径
 * SpringBootApplication注解包含了ComonentScan注解，默认扫描和启动类同级的目录以及下面的子目录
 * 添加ComponentScan注解扫描指定目录以及子目录，可解决多模块下springboot启动类无法加载其他模块bean的问题
 */
@SpringBootApplication
@MapperScan({"com.xiaoxiya.wlmalldemomodel.dao","com.xiaoxiya.wlmalldemomodel.mydao"})
@ComponentScan(value="com.xiaoxiya")
public class WlmalldemowebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WlmalldemowebApplication.class, args);
	}

}
