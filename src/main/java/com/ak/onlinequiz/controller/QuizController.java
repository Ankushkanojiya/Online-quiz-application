package com.ak.onlinequiz.controller;

import com.ak.onlinequiz.dto.CreateQuizRequest;
import com.ak.onlinequiz.dto.QuestionRequest;
import com.ak.onlinequiz.dto.QuestionResponse;
import com.ak.onlinequiz.dto.QuizResponse;
import com.ak.onlinequiz.entity.Question;
import com.ak.onlinequiz.entity.Quiz;
import com.ak.onlinequiz.repository.QuizRepository;
import com.ak.onlinequiz.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quiz")
@RequiredArgsConstructor
public class QuizController {


    private final QuizService quizService;

    @PostMapping
    public ResponseEntity<QuizResponse> createQuiz(@RequestBody CreateQuizRequest request){
        QuizResponse response=quizService.createQuiz(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/{quizId}/addQuestion")
    public ResponseEntity<QuestionResponse> addQuestions(@PathVariable Long quizId, @RequestBody QuestionRequest request){
        QuestionResponse question=quizService.addQuestionsToQuiz(quizId,request);
        return ResponseEntity.status(HttpStatus.CREATED).body(question);
    }
}
