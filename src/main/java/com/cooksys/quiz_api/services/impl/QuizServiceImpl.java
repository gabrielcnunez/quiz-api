package com.cooksys.quiz_api.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.cooksys.quiz_api.dtos.QuestionResponseDto;
import com.cooksys.quiz_api.dtos.QuizRequestDto;
import com.cooksys.quiz_api.dtos.QuizResponseDto;
import com.cooksys.quiz_api.entities.Answer;
import com.cooksys.quiz_api.entities.Question;
import com.cooksys.quiz_api.entities.Quiz;
import com.cooksys.quiz_api.exceptions.BadRequestException;
import com.cooksys.quiz_api.exceptions.NotFoundException;
import com.cooksys.quiz_api.mappers.QuestionMapper;
import com.cooksys.quiz_api.mappers.QuizMapper;
import com.cooksys.quiz_api.repositories.QuizRepository;
import com.cooksys.quiz_api.services.QuizService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

	private final QuestionMapper questionMapper;
	private final QuizRepository quizRepository;
	private final QuizMapper quizMapper;

	@Override
	public List<QuizResponseDto> getAllQuizzes() {
		return quizMapper.entitiesToDtos(quizRepository.findAll());
	}

	@Override
	public QuizResponseDto getQuizById(Long id) {
		return quizMapper.entityToDto(getQuiz(id));
	}
	
	@Override
	public QuestionResponseDto getRandomQuestion(Long id) {
		List<Question> quizQuestions = getQuiz(id).getQuestions();
		Random rng = new Random();
		Question randomQuestion = quizQuestions.get(rng.nextInt(0, quizQuestions.size()));
		
		return questionMapper.entityToDto(randomQuestion);
	}

	@Override
	public QuizResponseDto createQuiz(QuizRequestDto quizRequestDto) {
		if (quizRequestDto.getName() == null || quizRequestDto.getQuestions().isEmpty()) {
			throw new BadRequestException("All fields are required for creating a quiz");
		}
		Quiz quizToPost = quizMapper.requestDtoToEntity(quizRequestDto);

		for (Question question : quizToPost.getQuestions()) {
			question.setQuiz(quizToPost);
			for (Answer answer : question.getAnswers()) {
				answer.setQuestion(question);
			}
		}

		return quizMapper.entityToDto(quizRepository.saveAndFlush(quizToPost));
	}

	@Override
	public QuizResponseDto renameQuiz(Long id, String name) {
		Quiz quizToRename = getQuiz(id);
		quizToRename.setName(name);

		return quizMapper.entityToDto(quizRepository.saveAndFlush(quizToRename));
	}
	
	@Override
	public QuizResponseDto deleteQuiz(Long id) {
		Quiz quizToDelete = getQuiz(id);
		quizRepository.delete(quizToDelete);
		
		return quizMapper.entityToDto(quizToDelete);
	}
	
	private Quiz getQuiz(Long id) {
		Optional<Quiz> optionalQuiz = quizRepository.findById(id);
		if (optionalQuiz.isEmpty()) {
			throw new NotFoundException("No quiz found with id: " + id);
		}

		return optionalQuiz.get();
	}

}
