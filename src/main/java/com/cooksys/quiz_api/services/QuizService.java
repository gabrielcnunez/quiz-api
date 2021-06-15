package com.cooksys.quiz_api.services;

import java.util.List;

import com.cooksys.quiz_api.dtos.QuizResponseDto;

public interface QuizService {

  List<QuizResponseDto> getAllQuizzes();

}
