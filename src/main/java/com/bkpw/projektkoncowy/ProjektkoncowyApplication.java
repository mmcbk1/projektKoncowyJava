package com.bkpw.projektkoncowy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;



//@EnableTransactionManagement
//@EnableJpaRepositories
@EnableJpaAuditing
@SpringBootApplication
public class ProjektkoncowyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjektkoncowyApplication.class, args);
	}
}
