package com.egiftcard1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
@ComponentScan
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Online Wallet", version ="1.0", description ="Online wallet enables user to manage online e-wallet"))
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
