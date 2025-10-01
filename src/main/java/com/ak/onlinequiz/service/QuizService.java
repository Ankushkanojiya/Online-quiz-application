package com.ak.onlinequiz.service;

import com.ak.onlinequiz.dto.CreateQuizRequest;
import com.ak.onlinequiz.entity.Quiz;
import com.ak.onlinequiz.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository quizRepo;

    public Quiz createQuiz(CreateQuizRequest request){
        Quiz quiz=Quiz.builder()
                .title(request.getTitle())
                .createdAt(LocalDateTime.now())
                .build();
        return quizRepo.save(quiz);
    }
}
