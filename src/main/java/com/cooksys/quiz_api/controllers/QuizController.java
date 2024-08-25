package com.cooksys.quiz_api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.quiz_api.dtos.QuizRequestDto;
import com.cooksys.quiz_api.dtos.QuizResponseDto;
import com.cooksys.quiz_api.services.QuizService;

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
  
  @GetMapping("/{id}")
  public QuizResponseDto getQuizById(@PathVariable Long id) {
	  return quizService.getQuizById(id);
  }
  
  // TODO: Implement the remaining 6 endpoints from the documentation.
  
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public QuizResponseDto createQuiz(@RequestBody QuizRequestDto quizRequestDto) {
	  return quizService.createQuiz(quizRequestDto);
  }
  
  @PutMapping("/{id}")
  public QuizResponseDto updateQuiz(@PathVariable Long id) {
	  return null;
  }
  
  @DeleteMapping("/{id}")
  public QuizResponseDto deleteQuiz(@PathVariable Long id) {
	  return quizService.deleteQuiz(id);
  }

}
