package com.cooksys.quiz_api.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Question {

  @Id
  @GeneratedValue
  private Long id;

  private String text;

  @ManyToOne
  @JoinColumn(name = "quiz_id")
  private Quiz quiz;

  @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Answer> answers;

}
