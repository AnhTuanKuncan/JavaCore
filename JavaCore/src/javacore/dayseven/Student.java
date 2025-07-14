package javacore.dayseven;

public class Student {
	private String id;
	private String name;
	private int age;
	private double point;

	public Student(String id, String name, int age, double point) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.point = point;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

	public void showInfo() {
		System.out.println("Mã sinh viên là: " + id + ", Tên sinh viên là: " + name + ",Tuổi sinh viên là: " + age
				+ ",Điểm của sinh viên là " + point);
	}

}
