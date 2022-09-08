package com.google.firebase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class FirebaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirebaseApplication.class, args);
		log.info("________________________________");
		log.info("Firebase POC APP Start");
		log.info("________________________________");
	}

}
