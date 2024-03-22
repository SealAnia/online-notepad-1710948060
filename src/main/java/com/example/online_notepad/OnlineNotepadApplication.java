package com.example.online_notepad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class OnlineNotepadApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineNotepadApplication.class, args);
	}

}
