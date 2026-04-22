package com.coderr.cruddemo;

import com.coderr.cruddemo.dao.StudentDAO;
import com.coderr.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
		};
	}

	private void createMultipleStudents(StudentDAO studentDAO){

		//create the student object
		System.out.println("Creating student");
		Student tempstu1=new Student("JK","ROWLING","dfs@gmail.com");
		Student tempstu2=new Student("Jine","jones","uuit@gmail.com");
		Student tempstu3=new Student("kevin","hogwarts","gyjs@gmail.com");

		//save the student object
		System.out.println("Saving student");
		System.out.println("Saving students");
		studentDAO.save(tempstu1);
		studentDAO.save(tempstu2);
		studentDAO.save(tempstu3);

		//find student by id
		System.out.println("FINDING STUDENT BY ID..");
		Student studentFound=studentDAO.findById(2);
		System.out.println("FOUND STUDENT: "+studentFound);
	}


	private void createStudent(StudentDAO studentDAO){
		//create the student object
		System.out.println("Creating student");
		Student thestudent=new Student("Jake","Watson","example@gmail.com");

		//save the student object
		System.out.println("Saving student");
		studentDAO.save(thestudent);

		//display the id of the save student
		System.out.println("Displaying student");
		System.out.println("THE ID GENERATED: "+ thestudent.getId());



	}



}
