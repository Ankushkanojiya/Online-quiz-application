package com.ak.onlinequiz.repository;

import com.ak.onlinequiz.entity.MultipleOption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MultipleOptionRepository extends JpaRepository<MultipleOption,Long> {

    Optional<MultipleOption> findByQuestionIdAndIsCorrectTrue(Long questionId);
}
