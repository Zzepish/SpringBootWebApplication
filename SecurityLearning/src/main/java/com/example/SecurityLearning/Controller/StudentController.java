package com.example.SecurityLearning.Controller;

import com.example.SecurityLearning.Entity.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private List<Student> students = new ArrayList<>(List.of(
            new Student(1, "Artem", "PHP"),
            new Student(2, "Leha", "Java")
    ));

    @GetMapping
    public List<Student> all()
    {
        return this.students;
    }

    @PostMapping
    public Student add(@ModelAttribute Student student)
    {
        student.setId(this.students.get(this.students.size() - 1).getId() + 1);
        this.students.add(student);
        return student;
    }

    @GetMapping("/csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute(CsrfToken.class.getName());
    }
}
