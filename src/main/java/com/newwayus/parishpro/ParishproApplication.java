package com.newwayus.parishpro;

import com.newwayus.parishpro.config.ParishProConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import; //added by GJ

@SpringBootApplication
@Import(ParishProConfig.class) // Import ParishProConfig class
public class ParishproApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParishproApplication.class, args);
	}

}
