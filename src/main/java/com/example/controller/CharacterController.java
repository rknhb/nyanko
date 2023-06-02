package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.entity.CharacterEntity;
import com.example.entity.Rarities;
import com.example.repositories.CharactersRepository;

@Controller("charactercontroller")
public class CharacterController {
	
	@Autowired
	private CharactersRepository charactersRepository;
	
	@GetMapping("/character/{rarity}")
	public String index(@PathVariable("rarity") String rarity, Model model) {
		List<CharacterEntity> characters = charactersRepository.findAll();
		String characterRarity = Rarities.list.get(rarity);
		model.addAttribute("characters", characters);
		model.addAttribute("characterRarity", characterRarity);
		
		return "character/index";
	}
	
	@GetMapping("/character/detail/{characterId}")
	public String detail() {
		return "character/detail";
	}
}