package com.example.cmdrunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CmdrunnerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CmdrunnerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello world from Command Line Runner hi jagadeesh");
	}
}
