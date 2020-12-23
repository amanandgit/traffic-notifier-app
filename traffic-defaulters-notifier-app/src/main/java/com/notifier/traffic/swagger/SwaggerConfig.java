package com.notifier.traffic.swagger;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.notifier.traffic.controller"))
                .paths(PathSelectors.any())
                .build();
             
    }
    
  // @Bean
    private ApiInfo apiInfo() {
        return new ApiInfo(
          "My Traffic Fine Notifier API", 
          "This is to trigger email to Defaulters.", 
          "API TOS", 
          "Terms of service", 
          new Contact("Aman Anand", "www.example.com", "amanand92@gmail.com"), 
          "License of API", "http://localhost:8080/swagger-ui.html", Collections.emptyList());
    }
    
   	@Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
  
}
