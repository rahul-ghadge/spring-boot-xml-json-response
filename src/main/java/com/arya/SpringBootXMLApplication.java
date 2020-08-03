package com.arya;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SpringBootXMLApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootXMLApplication.class, args);
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.
				favorParameter(true).
				// http://localhost:8080/super-hero/tony?mediaType=json
				parameterName("mediaType").

				// By uncommenting below line it will ignore Accept type from request
				//ignoreAcceptHeader(true).

				// for default XML response
				defaultContentType(MediaType.APPLICATION_XML).

				// for xml param in request  return xml response
				mediaType("xml", MediaType.APPLICATION_XML).

				// for json param in request  return xml response
				mediaType("json", MediaType.APPLICATION_JSON);
	}
}
