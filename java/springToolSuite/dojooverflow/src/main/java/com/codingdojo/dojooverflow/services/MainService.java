package com.codingdojo.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojooverflow.models.Answer;
import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.models.Tag;
import com.codingdojo.dojooverflow.models.TagQuestion;
import com.codingdojo.dojooverflow.repositories.AnswerRepository;
import com.codingdojo.dojooverflow.repositories.QuestionRepository;
import com.codingdojo.dojooverflow.repositories.TagQuestionRepository;
import com.codingdojo.dojooverflow.repositories.TagRepository;

@Service
public class MainService {
	private final AnswerRepository answerRepository;
	private final QuestionRepository questionRepository;
	private final TagRepository tagRepository;
	private final TagQuestionRepository tagQuestionRepository;
	
	public MainService(AnswerRepository answerRepository, QuestionRepository questionRepository, TagRepository tagRepository, TagQuestionRepository tagQuestionRepository) {
		this.answerRepository = answerRepository;
		this.questionRepository = questionRepository;
		this.tagRepository = tagRepository;
		this.tagQuestionRepository = tagQuestionRepository;
	}
//  ----------------------------------------------------------------
//  FIND all questions
//  ----------------------------------------------------------------
	public List<Question> allQuestions(){
		return questionRepository.findAll();
	}
//  ----------------------------------------------------------------
//  FIND one question by ID
//  ----------------------------------------------------------------
	public Question findQuestionById(Long question_id) {
		Question question = questionRepository.findQuestionById(question_id);
			return question;
		}
//  ----------------------------------------------------------------
//  CREATE one question
//  ----------------------------------------------------------------
	public Question createQuestion(Question newQuestion) {
		return questionRepository.save(newQuestion);	
	}
//  ----------------------------------------------------------------
//  CREATE one answer
//  ----------------------------------------------------------------
	public Answer createAnswer(Answer newAnswer) {
		return answerRepository.save(newAnswer);	
	}
//  ----------------------------------------------------------------
//  CREATE one tag
//  ----------------------------------------------------------------
	public Tag createTag(String string) {
		Optional<Tag> optionalTagging = tagRepository.findBySubject(string);
		if(optionalTagging.isPresent()) {
			return optionalTagging.get();
		}
		else {
			Tag newTag = new Tag(string);
			return tagRepository.save(newTag);
		}
		
	}
//  ----------------------------------------------------------------
//  CREATE tag(s) to a question
//  ----------------------------------------------------------------
	public void createQuestionTag(TagQuestion newQuestionTag){
		tagQuestionRepository.save(newQuestionTag);
	}
	public void deleteQuestion(Long question_id) {
		questionRepository.deleteById(question_id);
	}
	public void deleteAnswer(Long answer_id) {
		answerRepository.deleteById(answer_id);
	}
}
