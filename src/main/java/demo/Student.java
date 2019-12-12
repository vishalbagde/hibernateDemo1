package demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Student {
	@Id
	int student_id;
	String student_name;
	int age;
	
	public Student()
	{
		
	}
	
	public Student(int student_id, String student_name, int age) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
		this.age = age;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", student_name=" + student_name + ", age=" + age + "]";
	}
	
	


}
