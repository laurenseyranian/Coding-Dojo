package com.codingdojo.dojosurvey.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SurveyController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/result")
	public String result(Model model) {
		return "result.jsp";
	}
	@RequestMapping(value="/survey", method=RequestMethod.POST)
    public String survey(HttpSession session, @RequestParam(value="name") String name, @RequestParam(value="location") String location, @RequestParam(value="language") String language, @RequestParam(value="comment") String comment, Model model){
        session.setAttribute("name", name);
        session.setAttribute("location", location);
        session.setAttribute("language", language);
        session.setAttribute("comment", comment);
		return "redirect:/result";
    }
}
