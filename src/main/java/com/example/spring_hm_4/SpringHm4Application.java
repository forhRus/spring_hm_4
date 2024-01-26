package com.example.spring_hm_4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties") // путь к файлу с конфигами
@ConfigurationPropertiesScan("com.example")  // путь к файлам, кому конфиги прикрутить
public class SpringHm4Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringHm4Application.class, args);
	}

}
