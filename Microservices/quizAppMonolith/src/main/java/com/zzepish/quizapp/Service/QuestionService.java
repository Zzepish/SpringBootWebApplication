package com.zzepish.quizapp.Service;

import com.zzepish.quizapp.Entity.Question;
import com.zzepish.quizapp.Entity.Type.Category;
import com.zzepish.quizapp.Repository.QuestionRepository;
import org.hibernate.query.spi.Limit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> all() {
        return this.questionRepository.findAll();
    }

    public List<Question> byCategory(Category category) {
        return this.questionRepository.findByCategory(category);
    }

    public List<Question> byCategory(Category category, int limit) {
        return this.questionRepository.findRandomQuestionsByCategory(category, limit);
    }

    public Question save(Question question) {
        return this.questionRepository.save(question);
    }

    public void delete(long id) {
        this.questionRepository.deleteById(id);
    }
}
