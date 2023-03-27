package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("homecontroller")
public class HomeController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
}