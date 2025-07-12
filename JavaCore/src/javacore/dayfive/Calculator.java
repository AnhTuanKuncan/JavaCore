package javacore.dayfive;

public class Calculator {

	public int add(int a, int b) {
		return a + b;
	}

	public double add(double a, double b) {
		return a + b;
	}

	public String add(String a, String b) {
		StringBuilder sb = new StringBuilder();
		sb.append(a);
		sb.append(b);
		return sb.toString();
	}

}
