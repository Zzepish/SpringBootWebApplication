package com.REST.demo.Controller;

import com.REST.demo.Entity.JobPost;
import com.REST.demo.Service.JobService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {
    @Autowired
    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping(path = "/all", produces = {"application/json"})
    public List<JobPost> all()
    {
        return this.jobService.getAll();
    }

    @GetMapping(path = "/{id}", produces = {"application/json"})
    public JobPost find(@PathVariable int id)
    {
        return this.jobService.find(id);
    }

    @PostMapping(produces = {"application/json"}, consumes = {"multipart/form-data"})
    @ResponseStatus(HttpStatus.CREATED)
    public JobPost post(@ModelAttribute JobPost jobPost)
    {
        this.jobService.add(jobPost);
        return jobPost;
    }

    @PutMapping(path = "/{id}", produces = {"application/json"}, consumes = {"multipart/form-data"})
    public JobPost update(@PathVariable int id, @ModelAttribute JobPost jobPost)
    {
        jobPost.setId(id);
        this.jobService.update(jobPost);
        return jobPost;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        this.jobService.delete(id);
    }

    @GetMapping("/search/{searchString}")
    public List<JobPost> search(@PathVariable String searchString)
    {
        return this.jobService.search(searchString);
    }
}
