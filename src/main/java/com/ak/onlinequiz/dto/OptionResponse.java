package com.ak.onlinequiz.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class OptionResponse {
    private Long id;
    private String optionText;
}
