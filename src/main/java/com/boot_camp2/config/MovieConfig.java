package com.boot_camp2.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MovieConfig {

	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
