package com.ispan.config;

import java.util.Properties;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

@Configuration
@EnableTransactionManagement
public class RootAppConfig {

	@Bean
	public DataSource dataSource() throws IllegalArgumentException, NamingException {
		SQLServerDataSource ds = new SQLServerDataSource();
		ds.setServerName("localhost");
		ds.setPortNumber(1433);
		ds.setUser("sa");
		ds.setPassword("sa123456");
		ds.setDatabaseName("GoTrip");
		return ds;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() throws IllegalArgumentException, NamingException {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setDataSource(dataSource());
		factoryBean.setPackagesToScan("com.ispan.model");
		factoryBean.setHibernateProperties(additionalProperties());
		return factoryBean;
	}
	
	private Properties additionalProperties() {
		Properties props = new Properties();
		props.put("hibernate.dialect", org.hibernate.dialect.SQLServerDialect.class);
		props.put("hibernate.show_sql", Boolean.TRUE);
		props.put("hibernate.format_sql", Boolean.TRUE);
		return props;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManage(SessionFactory sessionFactory) {
		HibernateTransactionManager txMgr = new HibernateTransactionManager();
		txMgr.setSessionFactory(sessionFactory);
		return txMgr;
	}
	
}
