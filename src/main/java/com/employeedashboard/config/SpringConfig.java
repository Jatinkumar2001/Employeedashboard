package com.employeedashboard.config;



import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@Configuration
@ComponentScan(basePackages = {"com.employeedashboard"})
@EnableWebMvc
public class SpringConfig implements WebMvcConfigurer
{ 
	  public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/CSS/**").addResourceLocations("/CSS/");
	    }
	@Bean
	public LocalSessionFactoryBean getfactory()
	{
		LocalSessionFactoryBean factory=new LocalSessionFactoryBean();
		factory.setDataSource(getDataSource());
		factory.setHibernateProperties(getHibernateProperties());
		factory.setPackagesToScan("com.employeedashboard.models");
		return factory;
	}

	private Properties getHibernateProperties() {
		Properties p= new Properties();
		p.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		p.put("hibernate.hbm2ddl.auto","update");
		p.put("hibernate.show_sql","true");
		return p;
	}

	private DriverManagerDataSource getDataSource() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/mvc");
		dataSource.setUsername("root");
		dataSource.setPassword("mysql");
		return dataSource;
	}
	@Bean
	public SpringResourceTemplateResolver getTemplateResolver()
	{
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setPrefix("/templates/");
		templateResolver.setSuffix(".html");
		return templateResolver;
	}
	@Bean
	public ThymeleafViewResolver getViewResolver()
	{
		ThymeleafViewResolver resolver= new ThymeleafViewResolver();
		resolver.setTemplateEngine(getTemplateEngine());
		return resolver;
		
	}
   @Bean
	public SpringTemplateEngine getTemplateEngine() {
		SpringTemplateEngine engine= new SpringTemplateEngine();
		engine.setTemplateResolver(getTemplateResolver());
		return engine;
	}
}
