package com.zzepish.quizService.Controller;

import com.zzepish.quizService.Entity.Quiz;
import com.zzepish.quizService.Entity.Type.Category;
import com.zzepish.quizService.Entity.Wrapper.DTO.Answer;
import com.zzepish.quizService.Entity.Wrapper.DTO.QuestionWrapper;
import com.zzepish.quizService.Service.QuizService;
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
    public Quiz create(@ModelAttribute Quiz quiz, @RequestParam Category category, @RequestParam byte number) {
        return this.quizService.createQuiz(quiz, category, number);
    }

    @GetMapping("/{id}/questions")
    public List<QuestionWrapper> questions(@PathVariable int id) {
        return this.quizService.getQuestions(id);
    }

    @PostMapping("/calculate")
    public int result(@RequestBody Answer[] answers) {
        return this.quizService.calculateResult(answers);
    }
}
