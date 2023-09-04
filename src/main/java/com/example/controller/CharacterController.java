package com.example.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.entity.CharaType;
import com.example.entity.CharacterEntity;
import com.example.entity.Rarities;
import com.example.repository.CharaTypeRepository;
import com.example.repository.CharacterDateRepository;
import com.example.repository.CharacterRepository;

@Controller("charactercontroller")
public class CharacterController {
	
	@Autowired
	private CharacterRepository charaRepo;
	
	@Autowired
	private CharaTypeRepository typeRepo;
	
	@Autowired
	private CharacterDateRepository dateRepo;
	
	@GetMapping("/character/{rarity}")
	public String index(@PathVariable("rarity") String rarity, Model model) {
		//CharacterEntity character = charaRepo.findById(Long.valueOf(1)).get();
		//Date date = character.getUpdatedAt();
		
		String characterRarity = Rarities.list.get(rarity);
		List<CharaType> charaTypes = typeRepo.findByRareOrderByIdAsc(rarity);
		Date date = dateRepo.getMaxUpdatedAt(rarity);
		model.addAttribute("characterRarity", characterRarity);
		model.addAttribute("charaTypes", charaTypes);
		model.addAttribute("date", date);
		return "character/index";
	}
	
	@GetMapping("/character/detail/{id}")
	public String detail(@PathVariable("id") Long id, Model model) {
		CharacterEntity character = charaRepo.findById(id).get();
		String characterRarity = Rarities.list.get(character.getRare());
		Optional<CharaType> optional = typeRepo.findById(Long.valueOf(character.getType()));
		CharaType charaType = optional.get();
		model.addAttribute("character", character);
		model.addAttribute("characterRarity", characterRarity);
		model.addAttribute("charaType", charaType);
		return "character/detail";
	}
}