package com.cooksys.quiz_api.repositories;

import com.cooksys.quiz_api.entities.Quiz;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

  Optional<Quiz> findById(Long id);

}
