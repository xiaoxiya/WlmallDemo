package com.xiaoxiya.wlmalldemoweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * mapperscan注解扫描生成的接口路径
 */
@SpringBootApplication
@MapperScan("com.xiaoxiya.wlmalldemomodel.dao")
public class WlmalldemowebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WlmalldemowebApplication.class, args);
	}

}
