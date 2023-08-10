package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.entity.CharacterClassificationEntity;
import com.example.entity.CharacterEntity;
import com.example.entity.Rarities;
import com.example.repository.CharacterClassificationRepository;
import com.example.repository.CharacterRepository;

@Controller("charactercontroller")
public class CharacterController {
	
	@Autowired
	private CharacterRepository characterRepository;
	
	@Autowired
	private CharacterClassificationRepository classificationRepository;
	
	
	@GetMapping("/character/{rarity}")
	public String index(@PathVariable("rarity") String rarity, Model model) {
		String characterRarity = Rarities.list.get(rarity);
		List<CharacterEntity> characters = characterRepository.findByRare(rarity);
		Optional<CharacterClassificationEntity> line = classificationRepository.findById(1L);
		model.addAttribute("characters", characters);
		model.addAttribute("characterRarity", characterRarity);
		//model.addAttribute("classification", classificationRepository.findAll());//
		
		return "character/index";
	}
	
	@GetMapping("/character/detail/{characterId}")
	public String detail() {
		return "character/detail";
	}
}