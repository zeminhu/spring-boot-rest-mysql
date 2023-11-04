package com.hzsolution.orders.db.mybatis.config;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Slf4j
@Configuration
// @PropertySource("classpath:mysql-config.properties")
@PropertySource("classpath:application.yml")
// @Profile("dev") -- default profile is dev
public class MybatisConfig {
	@Autowired
	private Environment env;

	@Bean
	public DataSource dataSource() {
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
		log.info("*****The active profile for the application is " + env.getProperty("spring.profiles.active"));
/*
		log.info("datasource.driverClassName " + env.getProperty("spring.datasource.driverClassName"));
		log.info("datasource.url " + env.getProperty("spring.datasource.url"));
		log.info("datasource.username " + env.getProperty("spring.datasource.username"));
		log.info("datasource.password " + env.getProperty("spring.datasource.password"));
*/

		dataSource.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
		dataSource.setUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.datasource.username") != null ? env.getProperty("spring.datasource.username") : "");
		dataSource.setPassword(env.getProperty("spring.datasource.password") != null ? env.getProperty("spring.datasource.password") : "");

		return dataSource;
	}
}
