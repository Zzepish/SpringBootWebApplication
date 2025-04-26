package com.REST.demo.Repository;

import java.util.ArrayList;
import java.util.List;

import com.REST.demo.Enum.TechStack;
import com.REST.demo.Model.JobPost;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;

@Repository
public class JobRepository {
    List<JobPost> jobs = new ArrayList<>();

    public JobRepository() {

        // Java Developer Job Post
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
                        3, List.of(TechStack.CORE_JAVA, TechStack.J2EE, TechStack.SPRING_BOOT, TechStack.HIBERNATE)));



    }

    public JobPost find(int id) {
        for(JobPost jp : this.jobs) {
            if (jp.getId() == id) {
                return jp;
            }
        }

        return null;
    }

    public List<JobPost> getAll() {
        return this.jobs;
    }

    public void add(JobPost job) {
        job.setId(this.jobs.get(this.jobs.size() - 1).getId() + 1);
        this.jobs.add(job);
    }

    public void update(JobPost job) {
        for(JobPost jp : this.jobs) {
            if (jp.getId() == job.getId()) {
                this.jobs.add(this.jobs.indexOf(jp), job);
                break;
            }
        }
    }

    public void delete(int id) throws Exception {
        for(JobPost jp : this.jobs) {
            if (jp.getId() == id) {
                this.jobs.remove(jp);
                return;
            }
        }

        throw new Exception("Job Post " + id + " not found");
    }
}