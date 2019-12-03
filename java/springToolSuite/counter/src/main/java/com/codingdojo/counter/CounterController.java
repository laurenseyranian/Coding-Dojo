package com.codingdojo.counter;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
	@RequestMapping ("/")
	public String index(HttpSession session){
		Integer count = (Integer) session.getAttribute("count");
		if (count == null) {
			count = 0;
		}
		session.setAttribute("count", count +1);
		return "index.jsp";
	}
	@RequestMapping ("/counter")
	public String counter(HttpSession session, Model counter) {
	    Integer count = (Integer) session.getAttribute("count");
	    counter.addAttribute("count", count);
		return "counter.jsp";
	}
}