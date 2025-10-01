package com.ak.onlinequiz.controller;

import com.ak.onlinequiz.dto.CreateQuizRequest;
import com.ak.onlinequiz.entity.Quiz;
import com.ak.onlinequiz.repository.QuizRepository;
import com.ak.onlinequiz.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quiz")
@RequiredArgsConstructor
public class QuizController {


    private final QuizService quizService;

    @PostMapping
    public ResponseEntity<Quiz> createQuiz(@RequestBody CreateQuizRequest request){
        Quiz quiz=quizService.createQuiz(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(quiz);
    }
}
