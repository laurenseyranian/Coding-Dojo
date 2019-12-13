package com.codingdojo.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.dojooverflow.models.Answer;

public interface AnswerRepository extends CrudRepository <Answer, Long>{
//----------------------------------------------------------------
//	FIND all answers
//----------------------------------------------------------------
	List<Answer> findAll();
//----------------------------------------------------------------
//	FIND one answer by ID
//----------------------------------------------------------------
	Answer findAnswerById(Long answer_id);
}
