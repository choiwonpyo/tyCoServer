package com.example.tyco.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

@EnableWebMvc
@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
	@Autowired
	private ObjectMapper objectMapper;
	
	  @Override
	  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	    MappingJackson2HttpMessageConverter jacksonMessageConverter = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = jacksonMessageConverter.getObjectMapper();
		Hibernate5Module hbm = new Hibernate5Module();
		hbm.enable(Hibernate5Module.Feature.FORCE_LAZY_LOADING);
		
		objectMapper.registerModule(hbm);
	    converters.add(new MappingJackson2HttpMessageConverter(objectMapper));
	  }
	
}
