package javacore.daysix;

import java.time.LocalDate;
import java.time.Period;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		divide(sc);
		convertWrapper(sc);
		calculateAge(sc);
		File(sc);
	}

	public static void divide(Scanner sc) {
		System.out.println("Nhập số muốn chia cho 0:");
		double a = sc.nextDouble();
		try {
			double result = a / 0;
			System.out.println("Số " + a + "chia hết cho 0!");
		} catch (Exception e) {
			System.out.println("Số " + a + " không chia hết cho 0!");
		}

	}

	public static void convertWrapper(Scanner sc) {
		try {
			System.out.print("Nhập số nguyên: ");
			String inputInt = sc.nextLine();
			int intValue = Integer.parseInt(inputInt);
			System.out.println("Giá trị int: " + intValue);
		} catch (NumberFormatException e) {
			System.out.println("Lỗi: Không phải số nguyên hợp lệ!");
		}

		try {
			System.out.print("Nhập số thực: ");
			String inputDouble = sc.nextLine();
			double doubleValue = Double.parseDouble(inputDouble);
			System.out.println("Giá trị double: " + doubleValue);
		} catch (NumberFormatException e) {
			System.out.println("Lỗi: Không phải số thực hợp lệ!");
		}

		try {
			System.out.print("Nhập giá trị boolean (true/false): ");
			String inputBool = sc.nextLine();
			boolean boolValue = Boolean.parseBoolean(inputBool);
			System.out.println("Giá trị boolean: " + boolValue);
		} catch (Exception e) {
			System.out.println("Lỗi boolean!");
		}
	}

	public static void calculateAge(Scanner sc) {
		System.out.println("Nhập năm sinh:");
		int namSinh = sc.nextInt();
		sc.nextLine();
		System.out.println("Nhập tháng sinh:");
		int thangSinh = sc.nextInt();
		sc.nextLine();
		System.out.println("Nhập ngày sinh:");
		int ngaySinh = sc.nextInt();
		sc.nextLine();
		try {
			LocalDate birthday = LocalDate.of(namSinh, thangSinh, ngaySinh);
			LocalDate today = LocalDate.now();
			Period age = Period.between(birthday, today);
			System.out.println("Tuổi hiện tại là: " + age.getYears());
		} catch (Exception e) {
			System.out.println("Lỗi " + e);
		}

	}

	public static void File(Scanner sc) {
		List<Student> students = new ArrayList<>();

		System.out.print("Nhập số sinh viên: ");
		int n = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < n; i++) {
			System.out.println("Sinh viên " + (i + 1));
			System.out.print("Tên: ");
			String name = sc.nextLine();

			System.out.print("Tuổi: ");
			int age = sc.nextInt();
			sc.nextLine();

			System.out.print("Email: ");
			String email = sc.nextLine();

			students.add(new Student(name, age, email));
		}

		try (BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {
			for (Student s : students) {
				bw.write(s.convertLine());
				bw.newLine();
			}
			System.out.println("Đã ghi vào file output.txt");
		} catch (IOException e) {
			System.out.println("Lỗi ghi file: " + e.getMessage());
		}

		System.out.println("\n--- Danh sách từ file ---");
		try (BufferedReader br = new BufferedReader(new FileReader("output.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				Student s = Student.fromString(line);
				s.showInfo();
			}
		} catch (IOException e) {
			System.out.println("Lỗi đọc file: " + e.getMessage());
		}
	}
}
