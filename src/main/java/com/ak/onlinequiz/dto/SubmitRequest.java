package com.ak.onlinequiz.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SubmitRequest {
    private List<AnswerRequest> answers;
}
