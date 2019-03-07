package ru.prilepskiy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ru.prilepskiy.*")
public class ApplicationContextConfig {

	 

//	@Bean(name = "viewResolver")
//	public InternalResourceViewResolver getViewResolver() {
//		InternalResourceViewResolver
//		      viewResolver = new InternalResourceViewResolver();
//		System.out.println("Create Bean viewResolver");
//
//		viewResolver.setPrefix("/WEB-INF/pages/");
//		viewResolver.setSuffix(".jsp");
//		return viewResolver;
//	}
  

}