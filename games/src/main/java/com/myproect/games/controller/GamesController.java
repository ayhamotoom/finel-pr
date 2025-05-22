package com.myproect.games.controller;

import com.myproect.games.entities.GmGame;
import com.myproect.games.repositories.GmGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

@Controller
@RequestMapping("/games")
public class GamesController {

	@Autowired
	private GmGameRepository gamesRepository;

	@GetMapping
	public String createGame(Model model) {
		model.addAttribute("games", gamesRepository.findAll());
		model.addAttribute("game", new GmGame());
		return "createGames";
	}

	@PostMapping("/save")
	public String saveGame(@ModelAttribute("game") GmGame game, @RequestParam("file") MultipartFile file)
			throws IOException {
		if (!file.isEmpty()) {
			game.setImager(file.getBytes());
		}
		game.setUpdatedDate(new Date());
		gamesRepository.save(game);
		return "redirect:/games";
	}

	@GetMapping("/edit/{id}")
	public String editGame(@PathVariable Long id, Model model) {
		GmGame game = gamesRepository.findById(id).orElseThrow();
		model.addAttribute("game", game);
		model.addAttribute("games", gamesRepository.findAll());
		return "createGames";
	}

	@GetMapping("/delete/{id}")
	public String deleteGame(@PathVariable Long id) {
		gamesRepository.deleteById(id);
		return "redirect:/games";
	}
	/*
	 * @Controller public class GameController {
	 * 
	 * @GetMapping("/addGame") public String showAddGameForm() { return "addGame";
	 * // تأكد أن لديك ملف addGame.html داخل /templates } }
	 */

}
