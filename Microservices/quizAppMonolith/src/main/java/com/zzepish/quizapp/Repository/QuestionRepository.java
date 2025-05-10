package com.zzepish.quizapp.Repository;

import com.zzepish.quizapp.Entity.Question;
import com.zzepish.quizapp.Entity.Type.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByCategory(Category category);

    @Query(value = "SELECT q.* FROM question q where q.category = :category ORDER BY RANDOM() LIMIT :limit", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(Category category, int limit);
}
