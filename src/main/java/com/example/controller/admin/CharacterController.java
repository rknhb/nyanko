package com.example.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.entity.CharacterEntity;
import com.example.entity.Rarities;
import com.example.repository.CharacterRepository;

@Controller("admincharactercontroller")
public class CharacterController {
	
	@Autowired
	private CharacterRepository charactersRepository;
	
	@GetMapping("/admin/character/{rarity}")
	public String index() {
		return "admin/character/index";
	}
	
	@GetMapping("/admin/character/detail/{characterId}")
	public String detail() {
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
		System.out.println(form.getName());
		System.out.println(form.getCost());
		System.out.println(form.getRare());
		System.out.println(form.getCommentary1());
		System.out.println(form.getCommentary2());
		System.out.println(form.getAttack_frequency());
		System.out.println(form.getReproduction());
		System.out.println(form.getKnockback());
		
		charactersRepository.save(form);
		return "redirect:/admin";
	}
	
	@GetMapping("/admin/character/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		CharacterEntity character = charactersRepository.findById(id).get();
		model.addAttribute("character", character);
		model.addAttribute("raritys", Rarities.list);
		
		return "admin/character/edit";
	}
	
	@PostMapping("/admin/character/update")
	public String update() {
		return "redirect:/character/detail";
	}
}