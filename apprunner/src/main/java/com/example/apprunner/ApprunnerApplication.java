package com.example.apprunner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApprunnerApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApprunnerApplication.class, args);
	}
	
	@Override
	   public void run(ApplicationArguments arg0) throws Exception {
	      System.out.println("Hello World from Application Runner");
	   }
}
