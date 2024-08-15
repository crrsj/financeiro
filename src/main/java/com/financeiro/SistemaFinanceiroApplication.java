package com.financeiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
			title = "API-Controle financeiro familiar",
			version = "1.0",
			description = "Documentando uma API para controle financeiro",
			contact = @Contact(name = "Carlos Roberto", email = "crrsj1@gmail.com")
		)
	)
public class SistemaFinanceiroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaFinanceiroApplication.class, args);
	}

}
