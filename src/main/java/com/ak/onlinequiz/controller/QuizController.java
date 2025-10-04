package com.ak.onlinequiz.controller;

import com.ak.onlinequiz.dto.*;
import com.ak.onlinequiz.entity.Question;
import com.ak.onlinequiz.entity.Quiz;
import com.ak.onlinequiz.repository.QuizRepository;
import com.ak.onlinequiz.service.QuizService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{quizId}/fetchQuestion")
    public ResponseEntity<List<QuestionResponse>> fetchQuestionsForQuiz(@PathVariable Long quizId){
        List<QuestionResponse> question=quizService.fetchQuestionOfQuiz(quizId);
        return ResponseEntity.ok(question);
    }

    @PostMapping("/{quizId}/submit")
    public ResponseEntity<SubmitResponse> submitQuizEvaluation(@PathVariable Long quizId, @Valid @RequestBody SubmitRequest request){
        SubmitResponse response=quizService.submitQuizEvaluation(quizId,request);
        return ResponseEntity.ok(response);
    }
}
