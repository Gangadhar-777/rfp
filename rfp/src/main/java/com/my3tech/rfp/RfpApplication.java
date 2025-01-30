package com.my3tech.rfp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class RfpApplication {

	public static void main(String[] args) {
		SpringApplication.run(RfpApplication.class, args);
	}

}
