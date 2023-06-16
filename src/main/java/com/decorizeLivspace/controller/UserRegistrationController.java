package com.decorizeLivspace.controller;

import com.decorizeLivspace.model.ContactUs;
import com.decorizeLivspace.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.decorizeLivspace.dto.UserRegistrationDto;
import com.decorizeLivspace.service.UserService;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	@Autowired
	private UserService userService;

	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }
	
	@GetMapping
	public String showRegistrationForm() {
		return "pages-registration";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
		userService.save(registrationDto);
		return "redirect:/registration?success";
	}

	@GetMapping("/user/{id}")
	public String getUserProfileById(@PathVariable("id") Long id, Model model) {
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		return "pages-profile";
	}



	@GetMapping("/user/delete/{id}")
	public String deleteUser(@PathVariable("id") Long id) {
		User user = userService.getUserById(id);
		userService.deleteUser(id);
		return "redirect:/adminDashboard";
	}
}
