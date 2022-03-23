package com.pingcap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(App.class);
		springApplication.addListeners(new ApplicationPidFileWriter("spring-jpa-hibernate.pid"));
		springApplication.run(args);
	}

}
