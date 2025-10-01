package com.ak.onlinequiz.dto;

import java.util.List;

import com.ak.onlinequiz.entity.Quiz;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QuestionRequest {
    @NotBlank
    private String questionText;
    @NotEmpty
    @Size(min = 4, message = "question should have 4 options")
    private List<OptionRequest> optionRequestList;


}
