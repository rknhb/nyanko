package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("charactercontroller")
public class CharacterController {
	
	@GetMapping("/character/{rarity}")
	public String index() {
		return "character/index";
	}
	
	@GetMapping("/character/detail/{characterId}")
	public String detail() {
		return "character/detail";
	}
}