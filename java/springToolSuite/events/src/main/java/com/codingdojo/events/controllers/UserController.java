package com.codingdojo.events.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.events.models.User;
import com.codingdojo.events.services.EventService;
import com.codingdojo.events.services.UserService;

@Controller
public class UserController {
//--------------------------------------------------------------------------------------------
// Attribute
//--------------------------------------------------------------------------------------------
	private final UserService userService;
	//----------------------------------------------------------------------------------------
	// Constructor
	//----------------------------------------------------------------------------------------
	public UserController(UserService userService) {
		this.userService = userService;
	}
//--------------------------------------------------------------------------------------------
// Dictionary for all of the states
//--------------------------------------------------------------------------------------------
	private final String[] states = { "AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "IA", "ID",
	        "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN", "MO", "MS", "MT", "NC", "ND", "NE", "NH", "NJ",
	        "NM", "NV", "NY", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV",
	        "WY" };
//--------------------------------------------------------------------------------------------
// GET route for READING authentication page
//--------------------------------------------------------------------------------------------	
	@RequestMapping("/")
	public String registerForm(@ModelAttribute("user") User user, Model model) {
		model.addAttribute("states", this.states);
		return "/events/authentication.jsp";
	}

//--------------------------------------------------------------------------------------------
// 										REGISTRATION
//--------------------------------------------------------------------------------------------
	
//--------------------------------------------------------------------------------------------
// POST route for CREATING a user
// --------------------------------------------------------------------------------------------
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session,
			RedirectAttributes attribute) {
		if (result.hasErrors()) {
			return "/events/authentication.jsp";
		} else if (userService.checkUser(user.getEmail())) {
			attribute.addFlashAttribute("error", "User already exists");
			return "redirect:/";
		} else if (!user.getPassword().equals(user.getPasswordConfirmation())) {
			attribute.addFlashAttribute("error", "Passwords do not match");
			return "redirect:/";
		} else {
			User new_user = userService.registerUser(user);
			session.setAttribute("loggedIn", user);
			session.setAttribute("userId", new_user.getId());
			return "redirect:/events";
		}
	}
	
	
//--------------------------------------------------------------------------------------------
//											LOGIN
//--------------------------------------------------------------------------------------------

//--------------------------------------------------------------------------------------------
// POST route for logging in a user
//--------------------------------------------------------------------------------------------
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model,
			HttpSession session, RedirectAttributes attribute) {
		if (email.length() < 1) {
			attribute.addFlashAttribute("error", "Must enter an email");
			return "redirect:/";
		} else if (password.length() < 1) {
			attribute.addFlashAttribute("error", "Must enter a password");
			return "redirect:/";
		} else if (userService.authenticateUser(email, password)) {
			User user = userService.findByEmail(email);
			if (user == null) {
				attribute.addFlashAttribute("error", "User does not exist");
			} else {
				System.out.println("INSIDE SESSION SETTING ROUTE");
				session.setAttribute("userId", user.getId());
				session.setAttribute("loggedIn", true);
				return "redirect:/events";
			}
		} else {
			attribute.addFlashAttribute("error", "Invalid Password");
		}
		return "redirect:/";
	}
//--------------------------------------------------------------------------------------------
// GET route for logging out a user 
//--------------------------------------------------------------------------------------------
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
