package com.example.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.entity.CharactersEntity;
import com.example.repositories.CharactersRepository;

@Controller("adminhomecontroller")
public class HomeController {
	
	@Autowired
	private CharactersRepository charactersRepository;
	
	@GetMapping("/admin")
	String index(Model model) {
		List<CharactersEntity> characters = charactersRepository.findAll();
		model.addAttribute("characters", characters);
		return "admin/index";
	}
}