package com.REST.demo.Entity;

import java.util.List;

import com.REST.demo.Enum.TechStack;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
