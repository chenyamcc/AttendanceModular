package com.woniuxy.oa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(value="com.woniuxy.oa.mapper")
@SpringBootApplication
public class WoniuOaApplication {

	public static void main(String[] args) {
		SpringApplication.run(WoniuOaApplication.class, args);
	}

}
