package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("/helloWorld")
	public void message() {
		System.out.println("Hello World");
	}
	
	@GetMapping("/getData")
	public void getData() {
		System.out.println("Hello World");
	}
	
}
