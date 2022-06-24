package com.ispan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.ispan")
@EnableWebMvc
public class WebAppConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/resources/images/");
		registry.addResourceHandler("/upload_images/**").addResourceLocations("/data/upload_images/");
		registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/resources/css/");
		registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/resources/js/");
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "/comments");
	}
	
	@Bean
	public InternalResourceViewResolver irViewResolver() {
		InternalResourceViewResolver irvrl = new InternalResourceViewResolver();
		irvrl.setPrefix("/WEB-INF/views/");
		irvrl.setSuffix(".jsp");
		irvrl.setOrder(6);
		return irvrl;
	}
	
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver cmr1 = new CommonsMultipartResolver();
		cmr1.setDefaultEncoding("UTF-8");
		return cmr1;
	}
	
}
