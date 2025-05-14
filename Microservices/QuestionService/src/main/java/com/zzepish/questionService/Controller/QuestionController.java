package com.zzepish.questionService.Controller;

import com.zzepish.questionService.Entity.Question;
import com.zzepish.questionService.Entity.Type.Category;
import com.zzepish.questionService.Entity.Wrapper.DTO.Answer;
import com.zzepish.questionService.Entity.Wrapper.QuestionWrapper;
import com.zzepish.questionService.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping
    public ResponseEntity<List<Question>> index() {
        try {
            return new ResponseEntity<>(this.questionService.all(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Question> add(@ModelAttribute Question question) {
        try {
            return new ResponseEntity<>(this.questionService.save(question), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Question> put(@PathVariable long id, @ModelAttribute Question question) {
        try {
            question.setId(id);
            return new ResponseEntity<>(this.questionService.save(question), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        try {
            this.questionService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/categories/{category}")
    public ResponseEntity<List<Question>> byCategory(@PathVariable Category category) {
        try {
            return new ResponseEntity<>(this.questionService.byCategory(category), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/generate/{category}/{amount}")
    public ResponseEntity<List<Long>> getQuestionsForQuiz(@PathVariable Category category, @PathVariable byte amount)
    {
        return new ResponseEntity<>(this.questionService.generateForQuiz(category, amount), HttpStatus.OK);
    }

    @GetMapping("/list")
    public List<QuestionWrapper> questionsList(@RequestParam long[] questionIds)
    {
        return this.questionService.getQuestionsById(questionIds);
    }

    @PostMapping("/calculate")
    public int calculate(@RequestBody Answer[] answer) {
        return this.questionService.calculateResult(answer);
    }
}
