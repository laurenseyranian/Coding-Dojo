package com.codingdojo.tasks.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.tasks.models.Task;
import com.codingdojo.tasks.models.User;
import com.codingdojo.tasks.services.TaskService;
import com.codingdojo.tasks.services.UserService;

@Controller
public class TaskController {
//-------------------------------------------------------------------------------------------------------
// Attributes
//-------------------------------------------------------------------------------------------------------
	private final TaskService taskService;
	private final UserService userService;

	// ----------------------------------------------------------------------------------------
	// Constructors
	// ----------------------------------------------------------------------------------------
	public TaskController(TaskService taskService, UserService userService) {
		this.taskService = taskService;
		this.userService = userService;
	}

//-------------------------------------------------------------------------------------------------------
// Dictionary for priority options
//-------------------------------------------------------------------------------------------------------
	private final String[] priorityOptions = { "High", "Medium", "Low" };

//-------------------------------------------------------------------------------------------------------
// 											Routes
//-------------------------------------------------------------------------------------------------------

//-------------------------------------------------------------------------------------------------------
// GET route for CREATING one task
//-------------------------------------------------------------------------------------------------------
	@GetMapping("/tasks/new")
	public String getCreateTask(@ModelAttribute("task") Task task, BindingResult result, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		User user = taskService.findUserById(userId);
		model.addAttribute("user", user);
		List<User> users = userService.allUsers();
		model.addAttribute("users", users);
		model.addAttribute("priorityOptions", priorityOptions);
		return "/tasks/create.jsp";
	}

//-------------------------------------------------------------------------------------------------------
// POST route for CREATING one task
//-------------------------------------------------------------------------------------------------------
	@PostMapping(value = "/task/create")
	public String postCreateTask(@Valid @ModelAttribute("task") Task task, BindingResult result, Model model, HttpSession session) {
		if (result.hasErrors()) {
			Long userId = (Long) session.getAttribute("userId");
			User user = taskService.findUserById(userId);
			model.addAttribute("user", user);
			List<User> users = userService.allUsers();
			model.addAttribute("users", users);
			model.addAttribute("priorityOptions", priorityOptions);
			return "/tasks/create.jsp";
		} else {
			taskService.createTask(task);
			return "redirect:/tasks/" + task.getId();
		}
	}

// -----------------------------------------------------------------------------------------------------
// GET route for READING all tasks after user successfully login
// -----------------------------------------------------------------------------------------------------
	@RequestMapping("/tasks")
	public String home(HttpSession session, Model model, @ModelAttribute("task") Task task) {
		Long id = (Long) session.getAttribute("userId");
		User user = userService.findUserById(id);
		model.addAttribute("user", user);
		List<Task> tasks = taskService.allTasks();
		model.addAttribute("tasks", tasks);
		return "/tasks/readAll.jsp";
	}

//------------------------------------------------------------------------------------------------------
// GET route for READING one task by ID
//------------------------------------------------------------------------------------------------------
	@GetMapping("/tasks/{task_id}")
	public String readOneTask(HttpSession session, Model model, @PathVariable("task_id") Long task_id) {
		Task task = taskService.findTaskById(task_id);
		model.addAttribute("task", task);
		Long userId = (Long) session.getAttribute("userId");
//			User user = taskService.findUserById(userId);
//			model.addAttribute("user", user);
		return "/tasks/readOne.jsp";
	}

// ------------------------------------------------------------------------------------------------------
// GET route for UPDATING one task by ID
// ------------------------------------------------------------------------------------------------------
	@RequestMapping("/task/{task_id}/edit")
	public String getUpdateTask(@PathVariable("task_id") Long task_id, Model model) {
		Task task = taskService.findTaskById(task_id);
		model.addAttribute("task", task);
		List<User> users = userService.allUsers();
		model.addAttribute("users", users);
		model.addAttribute("priorityOptions", priorityOptions);
		return "/tasks/update.jsp";
	}

//------------------------------------------------------------------------------------------------------
// POST route for UPDATE one task by ID
//------------------------------------------------------------------------------------------------------    
	@PutMapping("/task/{id}/update")
	public String postUpdateTask(Model model, @PathVariable("id") Long id, @Valid @ModelAttribute("task") Task task, BindingResult result) {
		if (result.hasErrors()) {
			List<User> users = userService.allUsers();
			model.addAttribute("users", users);
			model.addAttribute("priorityOptions", priorityOptions);

			return "/tasks/update.jsp";
		} else {
			this.taskService.updateTask(task);
			return "redirect:/tasks/" + task.getId();
		}
	}

//------------------------------------------------------------------------------------------------------
// POST route for DELETING an event by ID
//------------------------------------------------------------------------------------------------------
	@RequestMapping("/task/{task_id}/delete")
	public String deleteTask(@PathVariable("task_id") Long task_id) {
		taskService.deleteTask(task_id);
		return "redirect:/tasks";
	}
}
