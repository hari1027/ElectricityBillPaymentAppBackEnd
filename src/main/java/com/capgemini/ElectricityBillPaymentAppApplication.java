package com.capgemini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@CrossOrigin(origins = "*")
public class ElectricityBillPaymentAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElectricityBillPaymentAppApplication.class, args);
		System.out.println("ok");
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("").allowedOrigins("*").allowedMethods("GET","POST","PUT","DELETE");
			}
		};
	}

}	