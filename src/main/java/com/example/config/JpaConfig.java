package com.example.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import com.example.App;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = App.class)
public class JpaConfig implements TransactionManagementConfigurer {

	@Value("${dataSource.driverClassName}")
	private String driver;
	@Value("${dataSource.url}")
	private String url;
	@Value("${dataSource.username}")
	private String username;
	@Value("${dataSource.password}")
	private String password;
	@Value("${hibernate.dialect}")
	private String dialect;
	@Value("${hibernate.hbm2ddl.auto}")
	private String hbm2ddlAuto;
	
	@Bean
	public DataSource configureDataSource(){
		HikariConfig config = new HikariConfig();
		config.setDriverClassName(driver);
		config.setJdbcUrl(url);
		config.setUsername(username);
		config.setPassword(password);
		
		return new HikariDataSource(config);
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean configureEntityFactory(){
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(configureDataSource());
		factoryBean.setPackagesToScan("com.example");
		factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		
		Properties jpaProperties = new Properties();
		jpaProperties.put(org.hibernate.cfg.Environment.DIALECT, dialect);
		jpaProperties.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, hbm2ddlAuto);
		factoryBean.setJpaProperties(jpaProperties);
		
		return factoryBean;
	}
	
	@Bean
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return new JpaTransactionManager();
	}

}
