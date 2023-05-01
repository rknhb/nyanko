package com.example.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.CharactersEntity;
import com.example.repositories.CharactersRepository;

@Controller("admincharactercontroller")
public class CharacterController {
	
	@Autowired
	private CharactersRepository charactersRepository;
	
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
	
	@RequestMapping(value = "/admin/character/create", method = RequestMethod.GET)
	public String newPage(Model model) {
		model.addAttribute("title", "new");
		model.addAttribute("message", "送信前");
		return "admin/character/create";
	}
	
	@RequestMapping(value = "/admin/character/create", method = RequestMethod.POST)
	public String createPage(@RequestParam("name")String name, Model model) {
		model.addAttribute("title", "create");
		model.addAttribute("message", name);
		model.addAttribute("name", name);
		return "admin/character/create";
	}
	
	@PostMapping("/admin/character/add")
	public String add() {
		return "redirect:/admin";
	}
}