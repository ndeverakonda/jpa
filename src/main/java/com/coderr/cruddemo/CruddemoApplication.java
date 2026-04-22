package com.coderr.cruddemo;

import com.coderr.cruddemo.dao.StudentDAO;
import com.coderr.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//createStudent(studentDAO);
			//createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//findLastName(studentDAO);
			//updateStudent(studentDAO);
			//removeStudent(studentDAO);
			removeAll(studentDAO);
		};
	}


	private void removeAll(StudentDAO studentDAO) {
		//delete all
		int number=studentDAO.deleteAll();
		System.out.println("NUMBER DELETED: "+ number);
	}

	private void removeStudent(StudentDAO studentDAO) {
		//delete student
		studentDAO.delete(8);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student based on id
		Student stu=studentDAO.findById(2);

		//change firstname to scooby
		stu.setFirstName("Scooby");

		//update the student
		studentDAO.update(stu);
		//display the student

		System.out.println("UPDATED STUDENT: "+studentDAO.findById(2));
	}

	private void findLastName(StudentDAO studentDAO) {
		List<Student> list3=studentDAO.findByLastName("ROWLING");
		for(Student stu:list3){
			System.out.println(stu);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		List<Student> stuList=studentDAO.findAll();
		for(Student stu:stuList){
			System.out.println(stu);
		}
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
