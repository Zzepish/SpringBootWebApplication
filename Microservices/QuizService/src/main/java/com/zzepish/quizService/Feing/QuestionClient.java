package com.zzepish.quizService.Feing;

import com.zzepish.quizService.Entity.Type.Category;
import com.zzepish.quizService.Entity.Wrapper.DTO.Answer;
import com.zzepish.quizService.Entity.Wrapper.DTO.QuestionWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//questionService - Name of service in Eureka
@FeignClient("questionService")
public interface QuestionClient {
    @GetMapping("/questions/generate/{category}/{amount}")
    public List<Long> getQuestionsForQuiz(@PathVariable Category category, @PathVariable byte amount);

    @GetMapping("/questions/list")
    public List<QuestionWrapper> questionsList(@RequestParam List<Long> questionIds);

    @PostMapping("/questions/calculate")
    public int calculate(@RequestBody Answer[] answer);
}
