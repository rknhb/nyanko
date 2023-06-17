package com.example.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.entity.CharacterEntity;
import com.example.entity.Rarities;
import com.example.repositories.CharacterRepository;

@Controller("adminhomecontroller")
public class HomeController {
	
	@Autowired
	private CharacterRepository charactersRepository;
	
	@GetMapping("/admin")
	String index(Model model) {
		List<CharacterEntity> characters = charactersRepository.findAll();
		model.addAttribute("characters", characters);
		model.addAttribute("raritys", Rarities.list);
		return "admin/index";
	}
}