package com.zzepish.questionService.Repository;

import com.zzepish.questionService.Entity.Question;
import com.zzepish.questionService.Entity.Type.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByCategory(Category category);

    @Query(value = "SELECT q.* FROM question q where q.category = :category ORDER BY RANDOM() LIMIT :limit", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(Category category, int limit);

    @Query("SELECT q FROM Question q WHERE q.id in :questionIds")
    List<Question> findByIds(long[] questionIds);
}
