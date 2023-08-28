package com.example.controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.entity.CharaType;
import com.example.entity.CharacterEntity;
import com.example.entity.Rarities;
import com.example.repository.CharaTypeRepository;
import com.example.repository.CharacterRepository;

@Controller("admincharactercontroller")
public class CharacterController {
	
	@Autowired
	private CharacterRepository charaRepo;
	
	@Autowired
	CharaTypeRepository typeRepo;
	
	@GetMapping("/admin/character/{rarity}")
	public String index(@PathVariable("rarity") String rarity, Model model) {
		String characterRarity = Rarities.list.get(rarity);
		List<CharaType> charaTypes = typeRepo.findByRareOrderByIdAsc(rarity);
		model.addAttribute("characterRarity", characterRarity);
		model.addAttribute("charaTypes", charaTypes);
		return "admin/character/index";
	}
	
	@GetMapping("/admin/character/detail/{id}")
	public String detail(@PathVariable("id") Long id, Model model) {
		CharacterEntity character = charaRepo.findById(id).get();
		String characterRarity = Rarities.list.get(character.getRare());
		Optional<CharaType> optional = typeRepo.findById(Long.valueOf(character.getType()));
		CharaType charaType = optional.get();
		model.addAttribute("character", character);
		model.addAttribute("characterRarity", characterRarity);
		model.addAttribute("charaType", charaType);
		return "admin/character/detail";
	}
	
	@RequestMapping(value = "/admin/character/create", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("title", "create");
		model.addAttribute("message", "新規追加");
		model.addAttribute("raritys", Rarities.list);
		return "admin/character/create";
	}
	
	@PostMapping("/admin/character/add")
	public String add(@ModelAttribute CharacterEntity form) {
		form.getName();
		form.getCost();
		form.getRare();
		form.getCommentary1();
		form.getCommentary2();
		form.getAttack_frequency();
		form.getReproduction();
		form.getKnockback();
		form.getType();
		form.getNumber();
		System.out.println(form.getName());
		System.out.println(form.getCost());
		System.out.println(form.getRare());
		System.out.println(form.getCommentary1());
		System.out.println(form.getCommentary2());
		System.out.println(form.getAttack_frequency());
		System.out.println(form.getReproduction());
		System.out.println(form.getKnockback());
		System.out.println(form.getType());
		System.out.println(form.getNumber());
		
		charaRepo.save(form);
		return "redirect:/admin";
	}
	
	@GetMapping("/admin/character/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		CharacterEntity character = charaRepo.findById(id).get();
		model.addAttribute("character", character);
		model.addAttribute("raritys", Rarities.list);
		
		return "admin/character/edit";
	}
	
	@PostMapping("/admin/character/update")
	public String update() {
		return "redirect:/character/detail";
	}
}