package com.ak.onlinequiz.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateQuizRequest {
    @NotBlank(message = "Enter the Title of Quiz")
    private String title;
}
