package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {
	
	@GetMapping("/login")
	public String index() {
		return "admin/index";
	}
	
	@PostMapping("/sign_in")
	String adminHome() {
		return "admin/adminHome";
	}
	
	@GetMapping("/admin/character/{rarity}")
	public String adminCharacterList() {
		return "admin/adminCharacterList";
	}
	
	@GetMapping("/admin/character/detail/{characterId}")
	public String adminCharactereDetail() {
		return "admin/adminCharacterDetail";
	}
}