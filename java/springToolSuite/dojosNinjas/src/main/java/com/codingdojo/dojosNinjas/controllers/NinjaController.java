package com.codingdojo.dojosNinjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.dojosNinjas.models.Dojo;
import com.codingdojo.dojosNinjas.models.Ninja;
import com.codingdojo.dojosNinjas.services.DojoService;
import com.codingdojo.dojosNinjas.services.NinjaService;

@Controller
public class NinjaController {
////Attributes?
	private final NinjaService ninjaService;
	private final DojoService dojoService;
	public NinjaController(NinjaService ninjaService, DojoService dojoService) {
		//Creating an instance from the Ninja Service??		
		this.ninjaService = ninjaService;
		this.dojoService = dojoService;
	}
	
////Route for CREATING a new Ninja///////////////////////////////////////////////////////////////////////////	
	@RequestMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "/dojos_ninjas/createNinja.jsp";
	}
////POST route for CREATING a new Ninja/////////////////////////////////////////////////////////////////////// 	
	@RequestMapping(value = "/ninja/process", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("ninja") Ninja createNinja, BindingResult result) {
		if (result.hasErrors()) {
			return "/dojos_ninjas/createNinja.jsp";
		} else {
			ninjaService.createNinja(createNinja);
			return "redirect:/";
		}
	}
////Route for READING all Ninja's/////////////////////////////////////////////////////////////////////////////// 
	@RequestMapping("/ninjas")
	public String index(Model model) {
		List<Ninja> ninjas = ninjaService.allNinjas();
		model.addAttribute("ninjas", ninjas);
		return "/dojos_ninjas/readAll.jsp";
	}
////Route for READING one Ninja by ID//////////////////////////////////////////////////////////////////////////	
	@GetMapping("/ninjas/{ninja_id}")
	public String getPerson(@PathVariable("ninja_id") Long id, Model model) { 
		model.addAttribute("ninja", ninjaService.findNinja(id));
		return "/dojos_ninjas/readOne.jsp";
	}
////Route for DELETING one Ninja by id//////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "/ninjas/{ninja_id}", method = RequestMethod.DELETE)
	public String destroy(@PathVariable("ninja_id") Long id) {
		ninjaService.deleteNinja(id);
		return "redirect:/";
	}
}
