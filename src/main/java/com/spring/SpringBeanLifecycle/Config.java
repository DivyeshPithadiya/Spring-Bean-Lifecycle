package com.spring.SpringBeanLifecycle;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("app.properties")
public class Config {

	@Bean
	public ApplicationDao applicationDao() {
		return new ApplicationDao();
	}
}
