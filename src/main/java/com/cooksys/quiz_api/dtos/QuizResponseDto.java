package com.cooksys.quiz_api.dtos;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class QuizResponseDto {

  public Long id;

  public String name;

  public List<QuestionResponseDto> questions;

}
