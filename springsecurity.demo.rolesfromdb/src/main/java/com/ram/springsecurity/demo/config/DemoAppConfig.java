package com.ram.springsecurity.demo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.management.RuntimeErrorException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.ram.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {
	
	@Autowired
	private Environment env;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Bean
	public ViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	
	@Bean
	public DataSource securityDataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
		
		logger.info("Driver Class ==>>: " + env.getProperty("jdbc.driver"));
		logger.info("JDBC Url ==>>: " + env.getProperty("jdbc.url"));
		logger.info("JDBC Username ==>>: " + env.getProperty("jdbc.user"));
		
		logger.info("Initial Pool Size ==>>: " + getPropertyAsInteger("connection.pool.initialPoolSize"));
		logger.info("Min Pool Size ==>>: " + getPropertyAsInteger("connection.pool.minPoolSize"));
		logger.info("Max Pool Size ==>>: " + getPropertyAsInteger("connection.pool.maxPoolSize"));
		logger.info("Max Idle Time ==>>: " + getPropertyAsInteger("connection.pool.maxIdleTime"));
		
		dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		dataSource.setUser(env.getProperty("jdbc.user"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		
		dataSource.setInitialPoolSize(getPropertyAsInteger("connection.pool.initialPoolSize"));
		dataSource.setMinPoolSize(getPropertyAsInteger("connection.pool.minPoolSize"));
		dataSource.setMaxPoolSize(getPropertyAsInteger("connection.pool.maxPoolSize"));
		dataSource.setMaxIdleTime(getPropertyAsInteger("connection.pool.maxIdleTime"));
		return dataSource;
	}
	
	private int getPropertyAsInteger(String propertyName) {
		return Integer.parseInt(env.getProperty(propertyName));
	}

}
