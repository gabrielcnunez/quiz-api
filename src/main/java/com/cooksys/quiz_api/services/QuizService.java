package com.cooksys.quiz_api.services;

import java.util.List;

import com.cooksys.quiz_api.dtos.QuestionRequestDto;
import com.cooksys.quiz_api.dtos.QuestionResponseDto;
import com.cooksys.quiz_api.dtos.QuizRequestDto;
import com.cooksys.quiz_api.dtos.QuizResponseDto;

public interface QuizService {

	List<QuizResponseDto> getAllQuizzes();

	QuizResponseDto getQuizById(Long id);
	
	QuestionResponseDto getRandomQuestion(Long id);

	QuizResponseDto createQuiz(QuizRequestDto quizRequestDto);

	QuizResponseDto renameQuiz(Long id, String name);

	QuizResponseDto addQuestion(Long id, QuestionRequestDto questionRequestDto);

	QuestionResponseDto deleteQuestion(Long id, Long questionId);

	QuizResponseDto deleteQuiz(Long id);

}
