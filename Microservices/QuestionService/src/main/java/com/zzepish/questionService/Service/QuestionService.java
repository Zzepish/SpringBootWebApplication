package com.zzepish.questionService.Service;

import com.zzepish.questionService.Entity.Question;
import com.zzepish.questionService.Entity.Type.Category;
import com.zzepish.questionService.Entity.Wrapper.DTO.Answer;
import com.zzepish.questionService.Entity.Wrapper.QuestionWrapper;
import com.zzepish.questionService.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Long> generateForQuiz(Category category, byte amount) {
        return this.byCategory(category, amount).stream().map(Question::getId).toList();
    }

    public List<QuestionWrapper> getQuestionsById(long[] questionIds) {
        List<Question> questions = this.questionRepository.findByIds(questionIds);
        List<QuestionWrapper> questionWrappers = new ArrayList<>();

        for (Question question : questions) {
            questionWrappers.add(
                    new QuestionWrapper(
                            question.getId(),
                            question.getTitle(),
                            question.getOptions()
                    )
            );
        }

        return questionWrappers;
    }

    public int calculateResult(Answer[] answers) {
        if(answers.length == 0) return 0;

        List<Question> questions = this
                .questionRepository
                .findByIds(Arrays.stream(answers).mapToLong(Answer::getQuestionId).toArray());

        byte result = 0;

        for(Answer answer: answers) {
            for(Question question: questions) {
                if(question.getId() == answer.getQuestionId() && question.getAnswerIndex() == answer.getAnswerIndex()) {
                    result++;
                    break;
                }
            }
        }

        return result;
    }
}
