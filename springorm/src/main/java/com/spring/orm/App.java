package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

public class App {
	public static void main(String[] args) {
		System.out.println("started programming");

		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
//		Student student = new Student(12, "akash kumar", "chennai");
//		int r = studentDao.insert(student);
//		System.out.println("record inserted........ " + r);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean go = true;
		while (go) {
			System.out.println("1. Adding Student");
			System.out.println("2. Display all Studetns");
			System.out.println("3. get details of a single student");
			System.out.println("4. Delete student");
			System.out.println("5. update student");
			System.out.println("6. exit");

			try {

				int choice = Integer.parseInt(br.readLine());

				switch (choice) {
				case 1:
//					add a new student
//					taking all the required details for the user

					System.out.println("enter the student id: ");
					int uId = Integer.parseInt(br.readLine());

					System.out.println("enter the student name: ");
					String uName = br.readLine();

					System.out.println("enter the student city: ");
					String uCity = br.readLine();

					Student student = new Student(uId, uName, uCity);

//					adding using studenrDao method

					int i = studentDao.insert(student);
					System.out.println(uId + " data added to the table");
					System.out.println("********************************************");
					System.out.println();
					break;

				case 2:
//					display all student
					List<Student> allStudents = studentDao.getAllStudents();
					for (Student s : allStudents) {
						System.out.println(s);
						System.out.println("____________________________");
						System.out.println();
					}
					System.out.println("********************************************");
					System.out.println();
					break;

				case 3:
//					get details of a single student
					System.out.println("enter the id of the student for whome u want to fetch the data");
					int r = Integer.parseInt(br.readLine());
					Student s = studentDao.getStudent(r);
					System.out.println(s);
					System.out.println("********************************************");
					System.out.println();
					break;

				case 4:
//					Delete student
					System.out.println("enter the id of the student whome u want to remove from the table");
					int x = Integer.parseInt(br.readLine());
					studentDao.deleteStudent(x);
					System.out.println("Student data deleted");
					System.out.println("********************************************");
					System.out.println();
					break;

				case 5:

//					update student
					System.out.println("enter the id for the student for which you want to update the data");
					int up = Integer.parseInt(br.readLine());
					System.out.println("values before updating");
					Student stu = studentDao.getStudent(up);
					System.out.println(stu);
					System.out.println("*******************");
					System.out.println();
					System.out.println("enter the new name");
					String namString = br.readLine();
					System.out.println("enter the new city");
					String cityString = br.readLine();

					Student newsStudent = new Student(up, namString, cityString);
					studentDao.updateStudent(newsStudent);
					System.out.println("after update");
					Student newstu = studentDao.getStudent(up);
					System.out.println(newstu);
					System.out.println("*******************");
					System.out.println();

					break;
				case 6:
					go = false;
					break;
				}

			} catch (Exception e) {
				System.out.println("invalid input ! please give a correct input");
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Thankyou for usnig my application");
		System.out.println("********* SEE YOU SOON !!!  ***************");
	}
}
