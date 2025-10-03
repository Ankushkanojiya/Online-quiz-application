package com.ak.onlinequiz.repository;

import com.ak.onlinequiz.entity.Question;
import com.ak.onlinequiz.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface QuizRepository extends JpaRepository<Quiz,Long> {

}
