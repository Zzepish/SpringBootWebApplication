package com.REST.demo.Service;

import java.util.List;

import com.REST.demo.Model.JobPost;
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
        return this.repository.getAll();
    }

    // method to add a jobPost
    public void add(JobPost jobPost) {
        this.repository.add(jobPost);
    }

    public void update(JobPost jobPost) {
        this.repository.update(jobPost);
    }

    public void delete(int id) throws Exception {
        this.repository.delete(id);
    }

    public JobPost find(int id) {
        return this.repository.find(id);
    }
}