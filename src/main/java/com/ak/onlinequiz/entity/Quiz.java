package com.ak.onlinequiz.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private LocalDate createdAt;
    @OneToMany(mappedBy = "quiz")
    private List<Question> questions;
}
