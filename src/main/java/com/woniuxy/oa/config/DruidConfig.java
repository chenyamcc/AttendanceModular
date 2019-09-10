package com.woniuxy.oa.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * 阿里巴巴来接池配置类
 * @author 张峻溢
 *
 */
//@Configuration
public class DruidConfig {
	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource druid() {
		return new DruidDataSource();
	}
}
