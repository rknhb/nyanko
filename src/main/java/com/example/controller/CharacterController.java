package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.entity.Rarity;

@Controller("charactercontroller")
public class CharacterController {
	
	@GetMapping("/character/{rarity}")
	public String index(@PathVariable("rarity") String rarity, Model model) {
		String characterRarity = Rarity.list.get(rarity);
		model.addAttribute("characterRarity", characterRarity);
		
		return "character/index";
	}
	
	@GetMapping("/character/detail/{characterId}")
	public String detail() {
		return "character/detail";
	}
}