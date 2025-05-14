package com.zzepish.questionService.Entity;

import com.zzepish.questionService.Entity.Type.Category;
import com.zzepish.questionService.Entity.Type.DificulityLevel;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String[] options;
    private byte answerIndex;
    private DificulityLevel dificulityLevel;
    private Category category;
}
