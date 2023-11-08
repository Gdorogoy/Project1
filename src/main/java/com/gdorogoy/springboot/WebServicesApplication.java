package com.gdorogoy.springboot;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
		info =@Info(
				title = "Spring boot API Documentation",
				description = "API Document",
				version = "1.0",
				contact = @Contact(
						name = "Egor Dorogoy",
						url = "https://github.com/Gdorogoy"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://github.com/Gdorogoy"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "spring boot user management",
				url = "none"
		)

)
public class WebServicesApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(WebServicesApplication.class, args);
	}

}
