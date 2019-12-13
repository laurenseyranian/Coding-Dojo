package com.codingdojo.dojooverflow.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.dojooverflow.models.Answer;
import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.models.Tag;
import com.codingdojo.dojooverflow.models.TagQuestion;
import com.codingdojo.dojooverflow.services.MainService;
@Controller
public class MainController {
//----------------------------------------------------------------
// Attributes
//----------------------------------------------------------------
	private final MainService mainService;
	public MainController(MainService mainService) {
		//----------------------------------------------------------------
		// Attach Service to instance of a Controller
		//----------------------------------------------------------------	
		this.mainService = mainService;
	}
//----------------------------------------------------------------
// GET route for CREATING one question
//----------------------------------------------------------------
	@GetMapping("/questions/new")
	public String newQuestions() {
		return "/dojooverflow/createQuestion.jsp";
	}
// ----------------------------------------------------------------
// CREATE one question - Post Route
// ----------------------------------------------------------------
	@PostMapping("/question/create")
	public String createQuestion(@RequestParam("question") String question, @RequestParam("subject") String subject) {
		System.out.println(subject);
		System.out.println(question);
		String[] tagging = subject.split("\\s*,\\s*");
		Question newQuestion = mainService.createQuestion(new Question(question));
			for (String string : tagging) {
				Tag returnedTag = mainService.createTag(string);
				mainService.createQuestionTag(new TagQuestion(newQuestion, returnedTag));
			}
			return "redirect:/questions";
	}
// ----------------------------------------------------------------
// CREATE one answer - Post Route
// ----------------------------------------------------------------
	@PostMapping("/answer/create/{question_id}")
	public String createAnswer(@Valid @ModelAttribute("answer") Answer createAnswer, BindingResult result,@PathVariable("question_id") Long question_id) {
		if (result.hasErrors()) {
			return "/dojooverflow/readOne.jsp";
		} else {
			createAnswer.setQuestion(mainService.findQuestionById(question_id));
			mainService.createAnswer(createAnswer);
			return "redirect:/questions/" + question_id;
		}
	}
//----------------------------------------------------------------
// READ all questions - Get Route
//----------------------------------------------------------------
	@GetMapping("/questions")
	public String allquestions(Model model) {
		List<Question> questions = mainService.allQuestions();
		model.addAttribute("questions", questions);
		return "/dojooverflow/readAll.jsp";
	}
// ----------------------------------------------------------------
// READ one question ID - Get Route
// ----------------------------------------------------------------
	@GetMapping("/questions/{question_id}")
	public String questionsId(Model model, @PathVariable("question_id") Long question_id, @ModelAttribute("answer") Answer answer) {
		Question question = mainService.findQuestionById(question_id);
		model.addAttribute("question", question);
		return "/dojooverflow/readOne.jsp";
	}
// ----------------------------------------------------------------
// READ one question by ID - Post Route
// ----------------------------------------------------------------
	@RequestMapping("/questions/{question_id}/answer")
	public String createAnswer(@RequestParam("answer") String answer, @PathVariable("question_id") Long question_id) {
		Answer newAnswer = new Answer();
		newAnswer.setText(answer);
		Question question = mainService.findQuestionById(question_id);
		newAnswer.setQuestion(question);
		mainService.createAnswer(newAnswer);
			return "redirect:/questions/" + question_id;
	}
// ----------------------------------------------------------------
// DELETE one question by ID - Post Route
// ----------------------------------------------------------------
	@RequestMapping(value = "/questions/{question_id}", method = RequestMethod.DELETE)
	public String destroyQuestion(@PathVariable("question_id") Long id) {
		mainService.deleteQuestion(id);
		return "redirect:/questions";
	}
// ----------------------------------------------------------------
// DELETE one answer by ID - Post Route
// ----------------------------------------------------------------
	@RequestMapping(value = "/answers/{answer_id}/{question_id}", method = RequestMethod.DELETE)
	public String destroyAnswer(@PathVariable("answer_id") Long answer_id, @PathVariable("question_id") Long question_id) {
		mainService.deleteAnswer(answer_id);
		return "redirect:/questions/" + question_id;
	}
}
