package com.dnd.creator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={"com.dnd.*"})
@EnableJpaRepositories("com.dnd.dao")
@EntityScan("com.dnd.beans")
public class DnDCreatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DnDCreatorApplication.class, args);
	}
}
