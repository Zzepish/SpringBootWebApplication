package com.zzepish.quizapp.Controller;

import com.zzepish.quizapp.Entity.Quiz;
import com.zzepish.quizapp.Entity.Type.Category;
import com.zzepish.quizapp.Entity.Wrapper.DTO.Answer;
import com.zzepish.quizapp.Entity.Wrapper.QuestionWrapper;
import com.zzepish.quizapp.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @GetMapping
    public List<Quiz> index() {
        return this.quizService.all();
    }

    @PostMapping
    public Quiz create(@ModelAttribute Quiz quiz, @RequestParam Category category, @RequestParam int number) {
        return this.quizService.createQuiz(quiz, category, number);
    }

    @GetMapping("/{id}/questions")
    public List<QuestionWrapper> questions(@PathVariable int id) {
        return this.quizService.getQuestions(id);
    }

    @PostMapping("/{id}/result")
    public int result(@PathVariable int id, @RequestBody Answer[] answers) {
        return this.quizService.calculateResult(id, answers);
    }
}
