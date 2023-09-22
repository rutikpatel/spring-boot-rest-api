package org.learn.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;


//@Configuration
public class SwaggerConfiguration {

	@Bean
	Docket api(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("org.learn.java"))
				.paths(PathSelectors.regex("/api/rest.*"))
				.build()
				.apiInfo(apiInfo());
	}


  private ApiInfo apiInfo(){
  return new ApiInfo("OUR REST APIs",
              "This REST API is very good",
              "Version-1.0",
              "https://www.shopspring.com/terms",
              new Contact("Rutik Patel","www.rutikpatel.ca","r@p.com"),
              "GNU Public V2.0",
              "https://www.gnu.org/licence/old-licenses/gpl-2-0.en-html",
              Collections.emptyList());
}



}

