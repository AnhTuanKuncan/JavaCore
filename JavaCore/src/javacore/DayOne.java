package javacore;

import java.util.Scanner;

public class DayOne {
	// biến là vùng nhớ dùng để lưu trữ dữ liệu và có một tên gọi riêng
	// có 8 kiểu dữ liệu nguyên thủy: byte,short,int,long,floaf,double,char,boolean
	// có 4 loại toán tử bao gồm: toán tử số học, so sánh, logic và gán
	// hàm là một đoạn mã dùng để xử lý một chức năng cụ thể có thể gọi được nhiều
	// lần
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập số a:");
		int a = sc.nextInt();
		System.out.println("Nhập số b:");
		int b = sc.nextInt();
		sc.nextLine();
		System.out.println("Nhập số kiểu tính toán:");
		String check = sc.nextLine();
		tinhToan(check, a, b);
		phuongTrinhBac1(a, b);
		System.out.println(isEven(a));

	}

	public static void tinhToan(String checkValue, int a, int b) {
		switch (checkValue) {
		case "+":
			int x = a + b;
			System.out.println("Tổng hai số là:" + x);
			break;
		case "-":
			int y = a - b;
			System.out.println("Hiệu hai số là:" + y);
			break;
		case "*":
			int z = a * b;
			System.out.println("Tích hai số là:" + z);
			break;
		default:
			if (b == 0) {
				System.out.println("Không thể chia cho 0!");
			} else {
				int e = a / b;
				System.out.println("Thương hai số là: " + e);
			}
		}
	}

	public static void phuongTrinhBac1(int a, int b) {
		if (a == 0) {
			if (b == 0) {
				System.out.println("Phương trình có vô số nghiệm!");
			} else {
				System.out.println("Phương trình vô nghiệm!");
			}
		} else {
			double x = -(double) b / a;
			System.out.println("Phương trình có nghiệm là:" + x);
		}
	}

	public static boolean isEven(int number) {
		return number % 2 == 0;
	}
}
