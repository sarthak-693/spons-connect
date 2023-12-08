package com.sponsconnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.sponsconnect")
@EntityScan(basePackages = "com.sponsconnect")


public class SponsConnectApplication {
	public static void main(String[] args) {
		SpringApplication.run(SponsConnectApplication.class, args);
	}

}
