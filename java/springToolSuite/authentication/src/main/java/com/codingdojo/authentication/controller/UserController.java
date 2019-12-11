package com.codingdojo.authentication.controller;

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

import com.codingdojo.authentication.model.User;
import com.codingdojo.authentication.service.UserService;

@Controller
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/registration")
	public String registerForm(@ModelAttribute("user") User user) {
		return "registrationPage.jsp";
	}

	@RequestMapping("/login")
	public String login() {
		return "loginPage.jsp";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, RedirectAttributes attribute) {
		if (result.hasErrors()) {
	         return "registrationPage.jsp";
	    }
	    else if(userService.checkUser(user.getEmail())) {
	    	attribute.addFlashAttribute("error", "User already exists");
	    	return "redirect:/registration";
	    }
	    else if(!user.getPassword().equals(user.getPasswordConfirmation())) {
			attribute.addFlashAttribute("error", "Passwords do not match");
			return "redirect:/registration";
	    } 
	    else {
	    	User new_user = userService.registerUser(user);
	        session.setAttribute("loggedIn", user);
	        session.setAttribute("userId", new_user.getId());
	        return "redirect:/home" ;
	    }
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, RedirectAttributes attribute) {
		if (email.length()<1) {
			attribute.addFlashAttribute("error", "Must enter an email");
			return "redirect:/login";
		}
		else if (password.length()<1) {
			attribute.addFlashAttribute("error", "Must enter a password");
			return "redirect:/login";
		}
		else if (userService.authenticateUser(email, password)) {
			User user = userService.findByEmail(email);
			if(user == null){
				attribute.addFlashAttribute("error", "User does not exist");
			} 
			else {
				session.setAttribute("userId", user.getId());
				session.setAttribute("loggedIn", true);
				return "redirect:/home";
			}
		} 
		else {
			attribute.addFlashAttribute("error", "Invalid Password");
		}
		return "redirect:/login";
	}

	@RequestMapping("/home")
	public String home(HttpSession session, Model model) {
		Long id = (Long) session.getAttribute("userId");
		User user = userService.findUserById(id);
		model.addAttribute("user", user);
		return "homePage.jsp";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}
