package javacore;

import java.util.Scanner;

public class DayThree {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập số lượng sinh viên muốn tạo:");
		int soSinhVien = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < soSinhVien; i++) {
			System.out.println("Nhập mã sinh viên:");
			String id = sc.nextLine();
			System.out.println("Nhập tên sinh viên:");
			String name = sc.nextLine();
			System.out.println("Nhập tuổi sinh viên:");
			int age = sc.nextInt();
			sc.nextLine();
			new Student(id, name, age);
		}
		System.out.println("Tổng số sinh viên được tạo là:" + Student.count);
		Rectangle rectangle = new Rectangle(3, 5);
		rectangle.getArea(rectangle);
		rectangle.getPerimeter(rectangle);
		new PIExample(4);
	}

	public static class Student {
		static int count = 0;
		String id;
		String name;
		int age;

		public Student(String id, String name, int age) {
			super();
			count++;
			this.id = id;
			this.name = name;
			this.age = age;
			show();
		}

		public void show() {
			System.out.println(name + " - " + age);
		}
	}

	public static class Rectangle {
		private double width;
		private double height;

		public Rectangle(final double width, final double height) {
			this.width = width;
			this.height = height;
		}

		public static void getArea(Rectangle rectangle) {
			double area = rectangle.width * rectangle.height;
			System.out.println("Diện tích là:" + area);
		}

		public static void getPerimeter(Rectangle rectangle) {
			double perimeter = 2 * (rectangle.width + rectangle.height);
			System.out.println("Chu vi là:" + perimeter);
		}
	}

	public static class PIExample {
		final double PI = 3.14;
		double bankinh;

		public PIExample(double bankinh) {
			this.bankinh = bankinh;
			dienTichHinhTron();
		}

		public void dienTichHinhTron() {
			double dientich = PI * bankinh * bankinh;
			System.out.println("Diện thích hình tròn là:" + dientich);
		}
	}
}