package com.zzepish.quizapp.Entity;

import com.zzepish.quizapp.Entity.Type.Category;
import com.zzepish.quizapp.Entity.Type.DificulityLevel;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;

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
