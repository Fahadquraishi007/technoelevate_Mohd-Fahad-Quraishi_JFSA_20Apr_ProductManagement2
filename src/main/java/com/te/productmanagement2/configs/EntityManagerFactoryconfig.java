package com.te.productmanagement2.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class EntityManagerFactoryconfig {

	@Bean
	public LocalEntityManagerFactoryBean getFactory() {
		LocalEntityManagerFactoryBean entityManagerFactory = new LocalEntityManagerFactoryBean();
		entityManagerFactory.setPersistenceUnitName("emsPeristenceUnit");
		return entityManagerFactory;
	}// 
	
	
//	LocalContainerEntityManagerFactoryBean
}