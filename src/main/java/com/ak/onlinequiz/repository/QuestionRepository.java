package com.ak.onlinequiz.repository;

import com.ak.onlinequiz.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Long> {
}
