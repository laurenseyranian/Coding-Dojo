package com.codingdojo.tasks.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.tasks.models.Task;



public interface TaskRepository extends CrudRepository<Task, Long>{
//----------------------------------------------------------------
//	FIND all tasks
//----------------------------------------------------------------	
	List<Task> findAll();
	
//----------------------------------------------------------------
//	FIND task by ID
//----------------------------------------------------------------
	Task findTaskById(Long task_id);
}
