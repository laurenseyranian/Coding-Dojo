package com.codingdojo.relationships.controllers;

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

import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.services.PersonService;

@Controller
public class PersonController {
	private final PersonService personService;
	
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
////Route for CREATING a new person///////////////////////////////////////////////////////////////////////////	
	@RequestMapping("/persons/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "/relationships/createPerson.jsp";
	}
////POST route for CREATING a new person/////////////////////////////////////////////////////////////////////// 	
	@RequestMapping(value = "/person/process", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("person") Person createPerson, BindingResult result) {
		if (result.hasErrors()) {
			return "/relationships/createPerson.jsp";
		} else {
			personService.createPerson(createPerson);
			return "redirect:/licenses/new";
		}
	}
////Route for READING all persons/////////////////////////////////////////////////////////////////////////////// 
	@RequestMapping("/")
	public String index(Model model) {
		List<Person> persons = personService.allPersons();
		model.addAttribute("persons", persons);
		return "/relationships/readAll.jsp";
	}
////Route for READING one person by id//////////////////////////////////////////////////////////////////////////	
	@GetMapping("/persons/{person_id}")
	public String getPerson(@PathVariable("person_id") Long id, Model model) { 
		model.addAttribute("person", personService.findPerson(id));
		return "/relationships/readOne.jsp";
	}
////Route for DELETING one person by id//////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "/persons/{person_id}", method = RequestMethod.DELETE)
	public String destroy(@PathVariable("person_id") Long id) {
		personService.deletePerson(id);
		return "redirect:/";
	}

}
