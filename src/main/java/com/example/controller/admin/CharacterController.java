package com.example.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("admincharactercontroller")
public class CharacterController {
	
	@GetMapping("/admin/character/{rarity}")
	public String index() {
		return "admin/character/index";
	}
	
	@GetMapping("/admin/character/detail/{characterId}")
	public String detail() {
		return "admin/character/detail";
	}
	
	@GetMapping("/admin/character/edit")
	public String edit() {
		return "admin/character/edit";
	}
	
	@PostMapping("/admin/character/update")
	public String update() {
		return "redirect:/character/detail";
	}
	
	@GetMapping("/admin/character/create")
	public String create() {
		return "admin/character/create";
	}
	
	@PostMapping("/admin/character/add")
	public String add() {
		return "redirect:/admin";
	}
}