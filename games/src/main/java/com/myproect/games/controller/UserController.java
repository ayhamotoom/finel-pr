package com.myproect.games.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.myproect.games.entities.GmUsers;
import com.myproect.games.repositories.GmUsersRepository;

@Controller
@RequestMapping("/addUser")
public class UserController {

	@Autowired
	private GmUsersRepository userRepository;

	
	@GetMapping
	public String createUser(Model model) {
		model.addAttribute("users", userRepository.findAll());
		model.addAttribute("user", new GmUsers()); // for form
		return "createUser";
	}

	@GetMapping("/userList")
	public String listUsers(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "user-list";
	}

	@PostMapping("/save")
	public String saveUser(@ModelAttribute("user") GmUsers user) {
		userRepository.save(user);
		return "redirect:/addUser";
	}

	@GetMapping("/edit/{id}")
	public String editUser(@PathVariable Long id, Model model) {
		model.addAttribute("user", userRepository.findById(id).orElseThrow());
		model.addAttribute("users", userRepository.findAll());
		return "redirect:/addUser";
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		userRepository.deleteById(id);
		return "redirect:/addUser";
	}
	
}
