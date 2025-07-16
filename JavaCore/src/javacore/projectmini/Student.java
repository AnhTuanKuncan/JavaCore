package javacore.projectmini;

public class Student {
	private String maSV;
	private String name;
	private String email;
	private double point;

	public Student(String maSV, String name, String email, Double point) {
		this.maSV = maSV;
		this.name = name;
		this.email = email;
		this.point = point;
	}
	
	public Student(String name, Double point) {
		this.name = name;
		this.point = point;
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

	public void showInfor() {
		System.out.println("Sinh viên có mã " + maSV + ", Sinh viên có tên " + name + ", Email sinh viên là " + email
				+ ", Sinh viên có điểm là " + point);
	}
}
