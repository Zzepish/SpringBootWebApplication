package com.REST.demo.Repository;

import com.REST.demo.Entity.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<JobPost, Integer> {

    public List<JobPost> findByProfileContainingOrDescriptionContaining(String searchString, String searchString2);
   /* // Java Developer Job Post
        this.jobs.add(new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                List.of(TechStack.CORE_JAVA, TechStack.J2EE, TechStack.SPRING_BOOT, TechStack.HIBERNATE)));

        // Frontend Developer Job Post
        this.jobs.add(
                new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",
                        3, List.of(TechStack.CORE_JAVA, TechStack.J2EE, TechStack.SPRING_BOOT, TechStack.HIBERNATE)));

        // Data Scientist Job Post
        this.jobs.add(new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                List.of(TechStack.CORE_JAVA, TechStack.J2EE, TechStack.SPRING_BOOT, TechStack.HIBERNATE)));

        // Network Engineer Job Post
        this.jobs.add(new JobPost(4, "Network Engineer",
                "Design and implement computer networks for efficient data communication", 5,
                List.of(TechStack.CORE_JAVA, TechStack.J2EE, TechStack.SPRING_BOOT, TechStack.HIBERNATE)));

        // Mobile App Developer Job Post
        this.jobs
                .add(new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android",
                        3, List.of(TechStack.CORE_JAVA, TechStack.J2EE, TechStack.SPRING_BOOT, TechStack.HIBERNATE)));*/
}