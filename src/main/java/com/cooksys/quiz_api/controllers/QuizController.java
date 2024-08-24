package com.cooksys.quiz_api.controllers;

import java.util.List;

import com.cooksys.quiz_api.dtos.QuizRequestDto;
import com.cooksys.quiz_api.dtos.QuizResponseDto;
import com.cooksys.quiz_api.services.QuizService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/quiz")
public class QuizController {

  private final QuizService quizService;

  @GetMapping
  public List<QuizResponseDto> getAllQuizzes() {
    return quizService.getAllQuizzes();
  }
  
  // TODO: Implement the remaining 6 endpoints from the documentation.
  
  @PostMapping
  public QuizResponseDto createQuiz(@RequestBody QuizRequestDto quizRequestDto) {
	  return quizService.createQuiz(quizRequestDto);
  }

}
