package com.decorizeLivspace.controller;

import com.decorizeLivspace.model.ContactUs;
import com.decorizeLivspace.repository.ContactUsRepository;
import com.decorizeLivspace.service.ContactUsService;
import com.decorizeLivspace.service.PostService;
import com.decorizeLivspace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
//	@Autowired: This annotation is used for automatic dependency injection,
//	allowing the Spring container to automatically wire the necessary dependencies into the controller.
//contains fields for various service classes: ContactUsService, UserService, and PostService
	@Autowired
	private ContactUsService contactUsService;

	@Autowired
	private UserService userService;

	@Autowired
	private PostService postService;

//	@GetMapping("/login"): This annotation maps the login() method to handle GET requests for the "/login" URL.
//	It returns the string "pages-login", which likely refers to a view or template to be rendered by the application.
	@GetMapping("/login")
	public String login() {
		return "pages-login";
	}


//	@GetMapping("/"): This annotation maps the home(Model model) method to handle GET requests for the root URL ("/").
//	It takes a Model object as a parameter, adds a new ContactUs object to the model,
//	and returns the string "pages-landingPage" as the view or template to be rendered.
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("contactUs", new ContactUs());
		return "pages-landingPage";
	}


	@GetMapping("/adminDashboard")
	public String adminDashboard(Model model) {
//		adds an attributes named "(posts,contactUs,users)" to the Model object.
//		The value of this attribute is obtained by invoking the methods on the Service objects.
//		It suggests that there are service classes called (PostService,ContactUsService,UserService) with a method to retrieve Data.
		model.addAttribute("posts", postService.getAllPosts());
		model.addAttribute("contactUs", contactUsService.getAllContacts());
		model.addAttribute("users", userService.getAllUsers());

		return "adminDashboard";
	}

}
