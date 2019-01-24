package com.example.corsdemo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CORSController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping(value = "/products")
	@CrossOrigin(origins = "http://localhost:8080")
	public ResponseEntity<Object> getProduct() {
		 ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:8080/products", String.class);
		 String body = entity.getBody();
	   return  new ResponseEntity<>(body,HttpStatus.OK);
	}

}
