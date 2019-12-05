package com.codingdojo.languages.controllers;

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
import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.services.LanguageService;

@Controller
public class LanguagesController {
    private final LanguageService languageService;
    
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }
    
    // Route for CREATING a new language
    @RequestMapping("/languages/new")
    public String newLanguage(@ModelAttribute("language") Language language) {
        return "/languages/create.jsp";
    }
    // POST route that CREATES a language and checks for errors in the form from the .JSP file
    @RequestMapping(value="/createLanguage", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("language") Language createLanguage, BindingResult result) {
        if (result.hasErrors()) {
            return "/languages/create.jsp";
        } else {
            languageService.createLangauge(createLanguage);
            return "redirect:/languages";
        }
    }
    
    // Route for READING all languages
    @RequestMapping("/languages")
    public String index(Model model) {
        List<Language> languages = languageService.allLanguages();
        model.addAttribute("languages", languages);
        return "/languages/readAll.jsp";
    }
    // Route for READING one language
    @GetMapping("/languages/{language_id}")
    public String show(Model model, @PathVariable ("language_id") String id) {
    	model.addAttribute("language", languageService.findLanguage((long) Integer.parseInt(id)));
        return "/languages/readOne.jsp";
    }
    
    // Route for UPDATING one languages
    @RequestMapping("/languages/{language_id}/edit")
    public String edit(@PathVariable("language_id") Long id, Model model) {
    	Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "/languages/update.jsp";
    }
    // POST route that UPDATES a language and checks for errors in the form from the .JSP file
    @RequestMapping("/updateLanguage/{language_id}")
    public String update(@Valid @ModelAttribute("language") Language updateLanguage, BindingResult result, @PathVariable("language_id") Long id) {
        if (result.hasErrors()) {
            return "/languages/update.jsp";
        } else {
        	updateLanguage.setId(id);
            languageService.updateLanguage(updateLanguage);
            return "redirect:/languages";
        }
    }
    
    // Route for DELETING a language   
    @RequestMapping(value="/languages/{language_id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("language_id") Long id) {
    	languageService.deleteLanguage(id);
        return "redirect:/languages";
    }
}