package com.ak.onlinequiz.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerRequest {
    private Long questionId;
    private Long selectedOptionId;
}
