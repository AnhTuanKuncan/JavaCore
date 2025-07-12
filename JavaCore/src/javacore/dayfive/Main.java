package javacore.dayfive;

public class Main {
	public static void main(String[] args) {
		Calculator calc = new Calculator();

		int sumInt = calc.add(3, 5);
		System.out.println("Tổng int: " + sumInt);

		double sumDouble = calc.add(3.5, 2.1);
		System.out.println("Tổng double: " + sumDouble);

		String sumString = calc.add("Hello ", "Java");
		System.out.println("Tổng chuỗi: " + sumString);

		Vehicle v1 = new Vehicle();
		Vehicle v2 = new Car();
		Vehicle v3 = new Bike();

		v1.move();
		v2.move();
		v3.move();

		Shape[] shapes = new Shape[3];
		shapes[0] = new Circle(5.0);
		shapes[1] = new Rectangle(4.0, 6.0);
		shapes[2] = new Circle(2.5);

		for (int i = 0; i < shapes.length; i++) {
			System.out.println("Hình " + (i + 1));
			System.out.println("Diện tích: " + shapes[i].area());
			System.out.println("Chu vi: " + shapes[i].perimeter());
			System.out.println("-----");
		}
	}
}
