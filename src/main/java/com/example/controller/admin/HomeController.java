package com.example.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("adminhomecontroller")
public class HomeController {
	
	@PostMapping("/admin")
	String index() {
		return "admin/index";
	}
}