package com.codingdojo.tasks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.tasks.models.Task;
import com.codingdojo.tasks.models.User;
import com.codingdojo.tasks.repositories.TaskRepository;
import com.codingdojo.tasks.repositories.UserRepository;

@Service
public class TaskService {
//----------------------------------------------------------------------------------------------
// Attributes
//----------------------------------------------------------------------------------------------
	private final TaskRepository taskRepository;
	private final UserRepository userRepository;
	// -----------------------------------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------------------------------
    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }
//  -----------------------------------------------------------------------------------------
//  CREATE task
//  -----------------------------------------------------------------------------------------
	public Task createTask(Task task) {
		return taskRepository.save(task);
	}
	
//  -----------------------------------------------------------------------------------------
//  UPDATE a task
//  -----------------------------------------------------------------------------------------
	public Task updateTask(Task task) {
		return this.taskRepository.save(task);

	}

//  -----------------------------------------------------------------------------------------
//  DELETE task by ID
//  -----------------------------------------------------------------------------------------
	public void deleteTask(Long task_id) {
		taskRepository.deleteById(task_id);
	}
//  ----------------------------------------------------------------
//  FIND all tasks
//  ----------------------------------------------------------------
	public List<Task> allTasks(){
		return taskRepository.findAll();
	}
//  -----------------------------------------------------------------------------------------
//  FIND one task by ID
//  -----------------------------------------------------------------------------------------
	public Task findTaskById(Long task_id) {
		return taskRepository.findTaskById(task_id);
	}
//  -----------------------------------------------------------------------------------------
//  FIND one user by ID
//  -----------------------------------------------------------------------------------------
	public User findUserById(Long userId) {
		Optional<User> u = userRepository.findById(userId);
		if (u.isPresent()) {
			return u.get();
		} else {
			return null;
		}
	}
}
