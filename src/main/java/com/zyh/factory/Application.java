package com.zyh.factory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.zyh.factory.user.filter.TokenFilter;

@SpringBootApplication
public class Application {

	@Bean
	public FilterRegistrationBean filterJwt() {
		
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new TokenFilter());
		filterRegistrationBean.addUrlPatterns("/admin/*");
		
		return filterRegistrationBean;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
