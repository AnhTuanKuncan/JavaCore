package javacore.dayfour;

public class Employee {
	String name;
	double saraly;
	
	public Employee(String name, double salary) {
		this.name = name;
		this.saraly = salary;
	}
	
	public double tinhLuong() {
		return saraly;
	}
	
	public void showInfo() {
        System.out.println("Tên: " + name + " | Lương: " + tinhLuong());
    }
}
