package com.spring.zoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration()
public class SpringCloudWebZookeeperApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudWebZookeeperApplication.class, args);
	}

}
