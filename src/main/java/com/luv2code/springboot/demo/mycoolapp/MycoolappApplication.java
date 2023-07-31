package com.luv2code.springboot.demo.mycoolapp;

import com.luv2code.springboot.demo.mycoolapp.dao.StudentDAO;
import com.luv2code.springboot.demo.mycoolapp.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

//@SpringBootApplication(
//		scanBasePackages = {"com.lu2code.springboot",
//							"com.luv2code.util"
//		}
//)

@SpringBootApplication
public class MycoolappApplication {
	public static void main(String[] args) {
		SpringApplication.run(MycoolappApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		//return runner -> createMultipleStudents(studentDAO);
		//return runner -> readStudent(studentDAO);
//		return runner -> queryForStudents(studentDAO);
//		return runner -> queryForStudentsByLastName(studentDAO);
		return runner -> updateStudent(studentDAO);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(1);

		System.out.println("Updating student...");
		myStudent.setFirstName("Scooby");
		studentDAO.update(myStudent);

		System.out.println("Update student: " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("Doe");
		theStudents.forEach(student -> System.out.println(student));
	}

	private void createStudent(StudentDAO studentDAO, String firstName, String lastName, String email) {
		System.out.println("Creating new student object...");
		Student student = new Student(firstName, lastName, email);

		System.out.println("Saving the student...");
		studentDAO.save(student);

		System.out.println("Saved student. Generated id: " + student.getId());
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		createStudent(studentDAO, "John", "Xvim", "email1@gmail.com");
		createStudent(studentDAO, "Xohn", "Tim", "email11@gmail.com");
		createStudent(studentDAO, "Tohn", "Qim", "email2@gmail.com");
		createStudent(studentDAO, "Fred", "Xiem", "email241@gmail.com");
		createStudent(studentDAO, "Qohn", "Xism", "email1241@gmail.com");
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object...");
		Student student = new Student("Paul", "Doe", "paul@luv2code.com");

		System.out.println("Saving the student...");
		studentDAO.save(student);

		System.out.println("Saved student. Generated id: " + student.getId());

		int theId = student.getId();

		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		System.out.println("Found the student: " + myStudent);
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findAll();
		theStudents.forEach(student -> System.out.println(student));
	}
}