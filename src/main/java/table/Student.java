package table;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Student {
	@Id
	int rollno;
	StudentName name;
	int age;

	@OneToOne
	Address address;

	@OneToMany
	List<Laptop> laptop = new ArrayList<Laptop>();

	@ManyToOne
	Country country;

	public Student() {
		super();
	}

	public Student(int rollno, StudentName name, int age, Address address, List<Laptop> laptop, Country country) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.age = age;
		this.address = address;
		this.laptop = laptop;
		this.country = country;
	}

	public Student(int rollno, StudentName name, int age, Address address, List<Laptop> laptop) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.age = age;
		this.address = address;
		this.laptop = laptop;
	}

	public Student(int rollno, StudentName name, int age, List<Laptop> laptop, Address address) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.age = age;
		this.address = address;
		this.laptop = laptop;
	}

	public Student(int rollno, StudentName name, int age, Address address) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public Student(int rollno, StudentName name, int age) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.age = age;
	}

	public Student(int rollno, StudentName name, int age, List<Laptop> laptop) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.age = age;
		this.laptop = laptop;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public StudentName getName() {
		return name;
	}

	public void setName(StudentName name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Laptop> getLaptop() {
		return laptop;
	}

	public void setLaptop(List<Laptop> laptop) {
		this.laptop = laptop;
	}

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", age=" + age + "]";
	}
}
