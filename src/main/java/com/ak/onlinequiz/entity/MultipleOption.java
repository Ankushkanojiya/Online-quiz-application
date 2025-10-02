package com.ak.onlinequiz.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class MultipleOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String optionText;
    private boolean isCorrect;

    @ManyToOne
    @JoinColumn(name="question_id")
    private Question question;
}
