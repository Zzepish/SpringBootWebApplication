package com.data_jpa.demo.Repository;

import com.data_jpa.demo.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * As generic template we set object type and ID type
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    public List<Student> findByName(String name);

    @Query("SELECT s FROM Student s WHERE s.marks IN :marks")
    public List<Student> findByMarks(@Param("marks") int[] marks);

    public List<Student> findByMarksGreaterThan(int mark);
}
