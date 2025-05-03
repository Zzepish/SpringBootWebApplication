package com.example.spring_rest.Entity;

import com.example.spring_rest.Enum.TechStack;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
public class JobPost {
    @Id
    private int id;
    private String profile;
    private String description;
    private Integer requiredExperience;
    private List<TechStack> techStack;
}
