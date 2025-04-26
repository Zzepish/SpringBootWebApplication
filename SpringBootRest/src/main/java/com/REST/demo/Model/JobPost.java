package com.REST.demo.Model;

import java.util.List;

import com.REST.demo.Enum.TechStack;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class JobPost {
    private int id;
    private String profile;
    private String description;
    private Integer requiredExperience;
    private List<TechStack> techStack;
}
