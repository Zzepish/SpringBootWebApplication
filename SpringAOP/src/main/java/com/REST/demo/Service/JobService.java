package com.REST.demo.Service;

import java.util.List;

import com.REST.demo.Entity.JobPost;
import com.REST.demo.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {
    @Autowired
    private JobRepository repository;

    public JobService(JobRepository repository) {
        this.repository = repository;
    }

    //method to return all JobPosts
    public List<JobPost> getAll() {
        return this.repository.findAll();
    }

    // method to add a jobPost
    public void add(JobPost jobPost) {
        this.repository.save(jobPost);
    }

    public void update(JobPost jobPost) {
        this.repository.save(jobPost);
    }

    public void delete(int id) {
        this.repository.deleteById(id);
    }

    public JobPost find(int id) {
        return this.repository.findById(id).orElse(null);
    }

    public List<JobPost> search(String searchString) {
        return this.repository.findByProfileContainingOrDescriptionContaining(searchString, searchString);
    }
}