package com.example.tyco.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginRestController {
	@GetMapping("/")
	public String test() {
		return "Hello World";
	}
}
