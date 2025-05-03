package com.example.spring_rest.Repository;

import com.example.spring_rest.Entity.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<JobPost, Integer> {

    public List<JobPost> findByProfileContainingOrDescriptionContaining(String searchString, String searchString2);
}