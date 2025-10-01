package com.ak.onlinequiz.repository;

import com.ak.onlinequiz.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;


public interface QuizRepository extends JpaRepository<Quiz,Long> {

}
