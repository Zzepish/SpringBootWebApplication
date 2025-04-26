package com.data_jpa.demo;

import com.data_jpa.demo.Entity.Student;
import com.data_jpa.demo.Repository.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		/*SpringApplication.run(DemoApplication.class, args);*/
		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);

		StudentRepository studentRepository = ctx.getBean(StudentRepository.class);

		if (false) {
			studentRepository.deleteById(1);
		}

		if (false) {
			System.out.println(studentRepository.findByName("Petro"));
			System.out.println(studentRepository.findByMarks(new int[] {45, 12}));
			System.out.println(studentRepository.findByMarksGreaterThan(12));
		}

		if (false) {
			Student student = ctx.getBean(Student.class);
			Student student2 = ctx.getBean(Student.class);
			Student student3 = ctx.getBean(Student.class);

			student.setId(1);
			student.setMarks(22);
			student.setName("Artem");

			student2.setId(2);
			student2.setMarks(12);
			student2.setName("Ivan");

			student3.setId(3);
			student3.setMarks(45);
			student3.setName("Petro");

			studentRepository.save(student);
			studentRepository.save(student2);
			studentRepository.save(student3);
		}
	}

}
