package com.codingdojo.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.dojooverflow.models.Question;

public interface QuestionRepository extends CrudRepository<Question, Long>{
//----------------------------------------------------------------
//	FIND all questions
//----------------------------------------------------------------
	List<Question> findAll();
//----------------------------------------------------------------
//	FIND one question by ID
//----------------------------------------------------------------
	Question findQuestionById(Long question_id);
}
