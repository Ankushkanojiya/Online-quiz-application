package com.ak.onlinequiz.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OptionRequest {
    @NotBlank
    private String optionText;
    private boolean correct;
}

