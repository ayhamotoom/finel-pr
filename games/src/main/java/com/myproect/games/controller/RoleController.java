package com.myproect.games.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.myproect.games.entities.GmRole;
import com.myproect.games.repositories.GmRoleRepository;

@Controller
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	private GmRoleRepository roleRepository;

	@GetMapping
	public String createRole(Model model) {
		model.addAttribute("roles", roleRepository.findAll());
		model.addAttribute("role", new GmRole()); // for form
		return "createRole";
	}

	@PostMapping("/save")
	public String saveRole(@ModelAttribute("role") GmRole role) {
		roleRepository.save(role);
		return "redirect:/roles";
	}

	@GetMapping("/edit/{id}")
	public String editRole(@PathVariable Long id, Model model) {
		model.addAttribute("role", roleRepository.findById(id).orElseThrow());
		model.addAttribute("roles", roleRepository.findAll());
		return "createRole";
	}

	@GetMapping("/delete/{id}")
	public String deleteRole(@PathVariable Long id) {
		roleRepository.deleteById(id);
		return "redirect:/roles";
	}
}
