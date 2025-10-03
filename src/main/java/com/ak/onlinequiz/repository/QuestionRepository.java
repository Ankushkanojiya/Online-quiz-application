package com.ak.onlinequiz.repository;

import com.ak.onlinequiz.dto.QuestionResponse;
import com.ak.onlinequiz.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Long> {
    @Query("SELECT q FROM Question q JOIN FETCH q.optionList WHERE q.quiz.id = :quizId")
    List<Question> findByQuizId(Long quizId);
}
