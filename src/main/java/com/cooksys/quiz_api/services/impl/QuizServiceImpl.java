package com.cooksys.quiz_api.services.impl;

import java.util.List;

import com.cooksys.quiz_api.dtos.QuizRequestDto;
import com.cooksys.quiz_api.dtos.QuizResponseDto;
import com.cooksys.quiz_api.entities.Answer;
import com.cooksys.quiz_api.entities.Question;
import com.cooksys.quiz_api.entities.Quiz;
import com.cooksys.quiz_api.mappers.QuizMapper;
import com.cooksys.quiz_api.repositories.QuizRepository;
import com.cooksys.quiz_api.services.QuizService;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

	private final QuizRepository quizRepository;
	private final QuizMapper quizMapper;

	@Override
	public List<QuizResponseDto> getAllQuizzes() {
		return quizMapper.entitiesToDtos(quizRepository.findAll());
	}

	@Override
	public QuizResponseDto createQuiz(QuizRequestDto quizRequestDto) {
		Quiz quizToPost = quizMapper.requestDtoToEntity(quizRequestDto);

		for (Question question : quizToPost.getQuestions()) {
			question.setQuiz(quizToPost);
			for (Answer answer : question.getAnswers()) {
				answer.setQuestion(question);
			}
		}

		return quizMapper.entityToDto(quizRepository.saveAndFlush(quizToPost));
	}

}
