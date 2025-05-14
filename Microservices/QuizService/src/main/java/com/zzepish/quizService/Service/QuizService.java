package com.zzepish.quizService.Service;

import com.zzepish.quizService.Entity.Quiz;
import com.zzepish.quizService.Entity.Type.Category;
import com.zzepish.quizService.Entity.Wrapper.DTO.Answer;
import com.zzepish.quizService.Entity.Wrapper.DTO.QuestionWrapper;
import com.zzepish.quizService.Feing.QuestionClient;
import com.zzepish.quizService.Repository.QuizRepository;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionClient questionClient;

    public List<Quiz> all(){
        return this.quizRepository.findAll();
    }

    public Quiz createQuiz(Quiz quiz, Category category, byte limit) {
        List<Long> questions = this.questionClient.getQuestionsForQuiz(category, limit);
        quiz.setQuestions(questions);

        return this.quizRepository.save(quiz);
    }

    public List<QuestionWrapper> getQuestions(int quizId) {
        Quiz quiz = this.quizRepository.findById(quizId).orElseThrow(NotFoundException::new);

        return this.questionClient.questionsList(quiz.getQuestions());
    }

    public int calculateResult(Answer[] answers) {
        return this.questionClient.calculate(answers);
    }
}