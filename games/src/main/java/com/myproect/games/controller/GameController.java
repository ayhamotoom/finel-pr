package com.myproect.games.controller;

import com.myproect.games.entities.GmGame;
import com.myproect.games.entities.ListOfValueMapper;
import com.myproect.games.repositories.GmGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/addGame")
public class GameController {

	@Autowired
	private GmGameRepository gameRepository;

	@GetMapping
	public String newCreateGame(Model model) {
		model.addAttribute("games", gameRepository.findAll());
		model.addAttribute("game", new GmGame());
		model.addAttribute("studioMapper", new ListOfValueMapper()); // Add StudioMapper for Thymeleaf
		model.addAttribute("categoryMapper", new ListOfValueMapper()); // Add CategoryMapper for Thymeleaf
		return "createGames";
	}

	@PostMapping(value = "/save", consumes = "multipart/form-data")
	public String newSaveGame(@ModelAttribute("game") GmGame game, @RequestParam("imageFile") MultipartFile imageFile) {
		try {
			if (!imageFile.isEmpty()) {
				String contentType = imageFile.getContentType();
				if (contentType != null && (contentType.equals("image/png") || contentType.equals("image/jpeg"))) {
					// Get InputStream and read bytes
					try (InputStream imageStream = imageFile.getInputStream()) {
						byte[] imageBytes = imageStream.readAllBytes();
						game.setImager(imageBytes);
					}
				} else {
					throw new IllegalArgumentException("Invalid file format! Only PNG and JPG are allowed.");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (game.getGameId() == null) {
			game.setCreatedDate(new Date());
			game.setCreatedBy("system");
		} else {
			Optional<GmGame> newSaveGame1 = gameRepository.findById(game.getGameId());
			game.setUpdatedDate(new Date());
			game.setUpdatedBy("system");
			if (game.getImager() == null || game.getImager().length == 0) {
				game.setImager(newSaveGame1.get().getImager());
			}
		}

		gameRepository.save(game);
		return "redirect:/addGame";

	}

	@PostMapping(value = "/Newsave", consumes = "multipart/form-data")
	public String newGameSave(@ModelAttribute("game") GmGame game, @RequestParam("imageFile") MultipartFile imageFile) {
		try {
			if (!imageFile.isEmpty()) {
				String contentType = imageFile.getContentType();
				if (contentType != null && (contentType.equals("image/png") || contentType.equals("image/jpeg"))) {
					// Get InputStream and read bytes
					try (InputStream imageStream = imageFile.getInputStream()) {
						byte[] imageBytes = imageStream.readAllBytes();
						game.setImager(imageBytes);
					}
				} else {
					throw new IllegalArgumentException("Invalid file format! Only PNG and JPG are allowed.");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (game.getGameId() == null) {
			game.setCreatedDate(new Date());
			game.setCreatedBy("system");
		} else {
			Optional<GmGame> newSaveGame1 = gameRepository.findById(game.getGameId());
			game.setUpdatedDate(new Date());
			game.setUpdatedBy("system");
			if (game.getImager() == null || game.getImager().length == 0) {
				game.setImager(newSaveGame1.get().getImager());
			}
		}

		gameRepository.save(game);
		return "redirect:/Newgames";

	}

	@GetMapping("/delete/{id}")
	public String newDeleteGame(@PathVariable Long id) {
		gameRepository.deleteById(id);
		return "redirect:/addGame";
	}

	// New endpoint to retrieve and display images
	@GetMapping("/image/{id}")
	@ResponseBody
	public byte[] getImage(@PathVariable Long id) {
		GmGame game = gameRepository.findById(id).orElse(null);
		return (game != null && game.getImager() != null) ? game.getImager() : new byte[0];
	}

	@GetMapping("/sliderImages")
	@ResponseBody
	public List<String> getSliderImages() {
		List<GmGame> games = gameRepository.findAll().stream().limit(10).toList();

		List<String> imageUrls = new ArrayList<>();
		for (GmGame game : games) {
			if (game.getImager() != null) {
				imageUrls.add("/addGame/image/" + game.getGameId()); // Generates a URL for each game's image
			}
		}

		return imageUrls;
	}

	@GetMapping("/games")
	public String showGames(Model model) {
		List<GmGame> games = gameRepository.findAll();
		model.addAttribute("games", games);
		return "games";
	}

	@GetMapping("/gameForm")
	public String getGameForm() {
		return "addGame"; // اسم ملف HTML داخل templates بدون الامتداد
	}

	@PostMapping("/create")
	public String addGameForm() {
		return "redirect:/Newgames"; // اسم ملف HTML داخل templates بدون الامتداد
	}
}
