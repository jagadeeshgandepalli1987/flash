package com.zetcode.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages="com.zetcode")
//@PropertySource({"classpath:application.properties"}) 
public class SpringDBCLIApp {

    public static void main(String[] args) {

        SpringApplication.run(SpringDBCLIApp.class, args);
    }
}