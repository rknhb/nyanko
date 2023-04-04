package com.example.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("adminhomecontroller")
public class HomeController {
	
	@GetMapping("/admin")
	String index() {
		return "admin/index";
	}
}