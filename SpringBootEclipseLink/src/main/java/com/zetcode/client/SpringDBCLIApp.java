package com.zetcode.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages="com.zetcode")
public class SpringDBCLIApp {

    public static void main(String[] args) {
    	//Spring boot Configuration file
        SpringApplication.run(SpringDBCLIApp.class, args);
    }
}