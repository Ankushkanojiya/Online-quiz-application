package com.ak.onlinequiz.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponse {
    private Long id;
    private String questionText;
    private List<OptionResponse> optionResponses;
}
