package com.ak.onlinequiz.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class OptionResponse {
    private Long id;
    private String optionText;
}
