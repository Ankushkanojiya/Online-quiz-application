package com.ak.onlinequiz.service;

import com.ak.onlinequiz.dto.*;
import com.ak.onlinequiz.entity.MultipleOption;
import com.ak.onlinequiz.entity.Question;
import com.ak.onlinequiz.entity.Quiz;
import com.ak.onlinequiz.repository.QuestionRepository;
import com.ak.onlinequiz.repository.QuizRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository quizRepo;
    private final QuestionRepository questionRepo;

    public QuizResponse createQuiz(CreateQuizRequest request){
        Quiz quiz=Quiz.builder()
                .title(request.getTitle())
                .createdAt(LocalDateTime.now())
                .build();
        Quiz saveQuiz=quizRepo.save(quiz);

        QuizResponse response=QuizResponse.builder()
                .id(saveQuiz.getId())
                .title(saveQuiz.getTitle())
                .createdAt(saveQuiz.getCreatedAt())
                .build();
        return response;
    }

    public QuestionResponse addQuestionsToQuiz(Long id, QuestionRequest questionRequest){
        // get the quiz object by id to make reference to question
        Quiz quiz=quizRepo.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Quiz not found with this id "+id));

        // create a question object
        Question addQuestion=Question.builder()
                .questionText(questionRequest.getQuestionText())
                .quiz(quiz)
                .build();

        // create list to store the MCQ's
        List<MultipleOption> multipleOptions=new ArrayList<>();

        // get the options from OptionRequest class which is reference to QuestionRequest class and save to MultipleOption
        for (OptionRequest optionRequest:questionRequest.getOptionRequestList()){
            MultipleOption option=new MultipleOption();
            option.setOptionText(optionRequest.getOptionText());
            option.setCorrect(optionRequest.isCorrect());
            option.setQuestion(addQuestion);
            multipleOptions.add(option);
        }
        addQuestion.setOptionList(multipleOptions);
        Question savedQuestion=questionRepo.save(addQuestion); // save to repository

        // now convert to DTO for security concern and Infinite loop breaking
        List<OptionResponse> optionResponses=new ArrayList<>();

        for (MultipleOption option: savedQuestion.getOptionList()){
            OptionResponse response= OptionResponse.builder()
                    .id(option.getId())
                    .optionText(option.getOptionText())
                    .build();
            optionResponses.add(response);
        }
        // convert to DTO
        QuestionResponse response= QuestionResponse.builder()
                .id(savedQuestion.getId())
                .questionText(savedQuestion.getQuestionText())
                .optionResponses(optionResponses)
                .build();

        return response;
    }
}
