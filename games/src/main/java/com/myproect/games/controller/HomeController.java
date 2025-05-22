package com.myproect.games.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.myproect.games.entities.GmGame;
import com.myproect.games.entities.GmUsers;
import com.myproect.games.repositories.GmGameRepository;

@Controller
public class HomeController {

	@Autowired
	private GmGameRepository gameRepository;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("name", "دلعني");
		return "home";
	}

	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("name", "دلعني");
		return "home";
	}

	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("name", "دلعني");
		return "about";
	}

	@GetMapping("/contact")
	public String contact(Model model) {
		model.addAttribute("name", "دلعني");
		return "contact";
	}

	@GetMapping("/Newgames")
	public String games(Model model) {
		List<GmGame> games = gameRepository.findAll();
		model.addAttribute("games", games);
		return "games";
	}
}
