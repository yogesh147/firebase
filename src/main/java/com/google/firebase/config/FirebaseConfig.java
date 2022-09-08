package com.google.firebase.config;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.model.SecurityProperties;

@Configuration
public class FirebaseConfig {

	@Autowired
	SecurityProperties secProps;

	@Primary
	@Bean
	public void firebaseInit() {
		InputStream inputStream = null;
		try {
			inputStream = new ClassPathResource("firebase.json").getInputStream();
		} catch (IOException e3) {
			e3.printStackTrace();
		}
		try {
			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(inputStream)).build();

			if (FirebaseApp.getApps().isEmpty()) {
				FirebaseApp.initializeApp(options);
			}
			System.out.println("Firebase Initialize");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
