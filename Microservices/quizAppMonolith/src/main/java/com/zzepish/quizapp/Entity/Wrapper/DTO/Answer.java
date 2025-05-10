package com.zzepish.quizapp.Entity.Wrapper.DTO;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class Answer {
    private long questionId;
    private long answerIndex;
}