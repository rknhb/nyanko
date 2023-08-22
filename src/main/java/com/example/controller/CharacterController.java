package com.example.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.entity.CharaType;
import com.example.entity.CharacterEntity;
import com.example.entity.Rarities;
import com.example.repository.CharaTypeRepository;
import com.example.repository.CharacterRepository;

@Controller("charactercontroller")
public class CharacterController {
	
	@Autowired
	private CharacterRepository charaRepo;
	
	@Autowired
	private CharaTypeRepository typeRepo;
	
	@GetMapping("/character/{rarity}")
	public String index(@PathVariable("rarity") String rarity, Model model) {
		String characterRarity = Rarities.list.get(rarity);
		List<CharaType> charaTypes = typeRepo.findByRareOrderByIdAsc(rarity);
		model.addAttribute("characterRarity", characterRarity);
		model.addAttribute("charaTypes", charaTypes);
		
		return "character/index";
	}
	
	@GetMapping("/character/detail/{id}")
	public String detail(@PathVariable("id") Long id, Model model) {
		CharacterEntity character = charaRepo.findById(id).get();
		List<CharaType> charaTypes = typeRepo.findAll();
		model.addAttribute("character", character);
		model.addAttribute("charaTypes", charaTypes);
		return "character/detail";
	}
}