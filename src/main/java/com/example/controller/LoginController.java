package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.slf4j.Logger;
import org.springframework.ui.Model;

@Controller
public class LoginController {
	
	@GetMapping(path = "/login")
	public String index() {
		return "login/index";
	}
	
	@PostMapping("/login/auth")
	public String auth() {
		return "redirect:/admin";
	}
	
	@GetMapping(path = "/login-failure")
	public String loginFailure(Model model) {
		model.addAttribute("hasMessage", true);
		model.addAttribute("class", "alert-danger");
		model.addAttribute("message", "Emailまたはパスワードに誤りがあります。");
	
		return "login/index";
	}
	
	@GetMapping(path = "/logout-complete")
	public String logoutComplete(Model model) {
		model.addAttribute("hasMessage", true);
		model.addAttribute("class", "alert-info");
		model.addAttribute("message", "ログアウトしました。");
		
		return "index";
	}
}