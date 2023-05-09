package com.example.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String create(Model model) {
		model.addAttribute("title", "create");
		model.addAttribute("message", "新規追加");
		return "admin/character/create";
	}
	
	/**
	 * 新規作成画面
	 */
	@PostMapping("/admin/character/add")
	public String add(@ModelAttribute CharactersEntity form) {
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
	
//	@PostMapping("/admin/character/add")
//	public String add(@RequestParam("name") String name, @RequestParam("cost") int cost, @RequestParam("rare") String rare, @RequestParam("commentary1") String commentary1, @RequestParam("commentary2" String commentary2) {
//		
//		System.out.println("name = " + name);
//		System.out.println("cost = " + cost);
//		System.out.println("rare = " + rare);
//		System.out.println("commentary1 = " + commentary1);
//		System.out.println("commentary2 = " + commentary2);
//		
//		return "redirect:/admin";
//	}
}