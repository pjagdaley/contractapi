package com.oceanstech.contract.contractmain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ContractmainApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContractmainApplication.class, args);
	}

}
