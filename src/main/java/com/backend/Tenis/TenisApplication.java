package com.backend.Tenis;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TenisApplication {

	public static void main(String[] args) {
		SpringApplication.run(TenisApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.components(new Components())
				.info(new Info().title("Cine API")
						.description("Ejemplo de API REST")
						.contact(new Contact()
								.name("Trino Gómez")
								.email("trino@hotmail.com")
								.url("https://portal.edu.gva.es/iesmaciaabela/l"))
						.version("1.0"));
	}

}
