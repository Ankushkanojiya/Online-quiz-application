package com.ak.onlinequiz.dto;

import lombok.*;

import javax.lang.model.element.NestingKind;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuizResponse {
    private Long id;
    private String title;
    private LocalDateTime createdAt;
    private List<QuestionResponse> questionList;
}
