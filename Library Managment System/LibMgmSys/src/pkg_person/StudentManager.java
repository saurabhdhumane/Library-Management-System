package pkg_person;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ListIterator;

public class StudentManager {
	ObjectOutputStream oos_student = null;
	ObjectInputStream ois_student = null;

	File student_file = new File("student.dat");

	ArrayList<Student> student_list = null;

	@SuppressWarnings("unchecked")
	public StudentManager() {
		student_file = new File("student.dat");
		student_list = new ArrayList<Student>();

		if (student_file.exists()) {
			try {
				ois_student = new ObjectInputStream(new FileInputStream(student_file));
				student_list = (ArrayList<Student>) ois_student.readObject();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public Student get(int rollno) {
		for (Student student : student_list) {
			if (student.getRollno() == rollno) {
				return student;
			}
		}
		return null;
	}

	public void addStudent(Student student) {
		student_list.add(student);
	}

	public void viewAllstudent() {
		for (Student student : student_list) {
			System.out.println(student);
		}
	}

	public Student searchStudentByRollno(int search_rollno) {
		for (Student student : student_list) {
			if (student.getRollno() == search_rollno) {
				return student;
			}
		}
		return null;
	}

	public boolean deleteStudent(int delete_student) {
		ListIterator<Student> student_iterator = (ListIterator<Student>) student_list.listIterator();

		while (student_iterator.hasNext()) {
			Student student = student_iterator.next();
			if (student.getRollno() == delete_student) {
				student_list.remove(student);
				return true;
			}
		}
		return false;
	}

	public boolean updateStudent(int updateRollNo, String name, String emailId, String phoneNumber, String address,
			String dob, int std, String division) {
		ListIterator<Student> student_iterator = (ListIterator<Student>) student_list.listIterator();

		while (student_iterator.hasNext()) {
			Student student = student_iterator.next();
			if (student.getRollno() == updateRollNo) {
				student.setAddress(address);
				student.setDivision(division);
				student.setDob(dob);
				student.setEmailId(emailId);
				student.setName(name);
				student.setPhoneNumber(phoneNumber);
				student.setStd(std);
				return true;
			}

		}
		return false;
	}
	
	public void writeToFile() {
		try {
			oos_student = new ObjectOutputStream(new FileOutputStream(student_file));
			oos_student.writeObject(student_list);
		}catch(FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
