package com.example.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.CharaType;
import com.example.entity.CharacterEntity;
import com.example.entity.Rarities;
import com.example.repository.CharaTypeRepository;
import com.example.repository.CharacterSearchRepository;
import com.example.repository.CharacterRepository;

@Controller("charactercontroller")
public class CharacterController {
	
	@Autowired
	private CharacterRepository charaRepo;
	
	@Autowired
	private CharaTypeRepository typeRepo;
	
	@Autowired
	private CharacterSearchRepository searchRepo;
	
	@GetMapping("/character/{rarity}")
	public String index(@PathVariable("rarity") String rarity, Model model) {
		String characterRarity = Rarities.list.get(rarity);
		List<CharaType> charaTypes = typeRepo.findByRareOrderByIdAsc(rarity);
		Date date = searchRepo.getMaxUpdatedAt(rarity);
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
	
	@GetMapping("/character/search")
	public String search(@RequestParam("q") String word, Model model) {
		List<CharacterEntity> characters = searchRepo.search(word);
		model.addAttribute("word", word);
		model.addAttribute("characters", characters);
		return "character/search";
	}
}