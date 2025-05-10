package com.zzepish.quizapp.Service;

import com.zzepish.quizapp.Entity.Question;
import com.zzepish.quizapp.Entity.Quiz;
import com.zzepish.quizapp.Entity.Type.Category;
import com.zzepish.quizapp.Entity.Wrapper.DTO.Answer;
import com.zzepish.quizapp.Entity.Wrapper.QuestionWrapper;
import com.zzepish.quizapp.Repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionService questionService;

    public List<Quiz> all(){
        return this.quizRepository.findAll();
    }

    public Quiz createQuiz(Quiz quiz, Category category, int limit) {
        List<Question> questions = this.questionService.byCategory(category, limit);

        quiz.setQuestions(questions);

        return this.quizRepository.save(quiz);
    }

    public List<QuestionWrapper> getQuestions(int quizId) {
        List<Question> questions = this.quizRepository.findById(quizId).orElseThrow().getQuestions();
        ArrayList<QuestionWrapper> questionWrappers = new ArrayList<>(questions.size());
        for(Question question: questions) {
            questionWrappers.add(new QuestionWrapper(question.getId(), question.getTitle(), question.getOptions()));
        }

        return questionWrappers;
    }

    public int calculateResult(int quizId, Answer[] answers) {
        List<Question> questions = this.quizRepository.findById(quizId).orElseThrow().getQuestions();
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