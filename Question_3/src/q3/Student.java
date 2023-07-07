package q3;

import java.util.Arrays;

public class Student {
	String name,usn,address,category,age;
	double sg[];
	double cgpa;
	
	public Student(String name, String usn, String address, String category, String age, double[] sg, double cgpa) {
		super();
		this.name = name;
		this.usn = usn;
		this.address = address;
		this.category = category;
		this.age = age;
		this.sg = sg;
		this.cgpa = cgpa;
	}

	
	
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", usn=" + usn + ", address=" + address + ", category=" + category + ", age="
				+ age + ", sg=" + Arrays.toString(sg) + ", cgpa=" + cgpa + "]";
	}
	
	
}
