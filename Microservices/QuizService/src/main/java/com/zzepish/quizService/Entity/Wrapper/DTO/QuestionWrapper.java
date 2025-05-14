package com.zzepish.quizService.Entity.Wrapper.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionWrapper {
    private long id;
    private String title;
    private String[] options;
}
