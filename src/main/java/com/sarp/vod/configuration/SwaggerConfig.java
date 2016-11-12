package com.sarp.vod.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
@EnableAutoConfiguration
public class SwaggerConfig {

	@Bean
	public Docket contactApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("vod")
				.apiInfo(apiInfo())
				.select()
				.paths(categoryPaths()).build();
	}

	private Predicate<String> categoryPaths() {
		return regex("/vod.*");
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Video on Demand Demo Application")
				.description("Video on Demand Demo for Swagger Usage")
				.termsOfServiceUrl("")
				.license("Apache License Version 2.0")
				.licenseUrl("")
				.version("1.0").build();
	}
}
