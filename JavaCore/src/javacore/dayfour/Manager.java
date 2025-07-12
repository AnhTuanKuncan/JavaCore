package javacore.dayfour;

public class Manager extends Employee {
	private double bonus;

	public Manager(String name, double salary, double bonus) {
		super(name, salary);
		this.bonus = bonus;
	}
	
	@Override
	public double tinhLuong() {
		return super.saraly + bonus;
	}
}
