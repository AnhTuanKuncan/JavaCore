package javacore.projectmini;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	}

	public static void addStudent(Scanner sc, List<Student> students) {
		System.out.println("Nhập số lượng sinh viên muốn thêm:");
		int sumStudent = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < sumStudent; i++) {
			System.out.println("Nhập thông tin sinh viên thứ " + (i + 1));
			System.out.println("Nhập mã sinh viên:");
			String maSV = sc.nextLine();
			System.out.println("Nhập tên sinh viên:");
			String tenSV = sc.nextLine();
			System.out.println("Nhập email sinh viên:");
			String email = sc.nextLine();
			System.out.println("Nhập điểm sinh viên:");
			Double point = sc.nextDouble();
			sc.nextLine();
			Student student = new Student(maSV, tenSV, email, point);
			students.add(student);
		}
	}

	public static void showInfoStudent(List<Student> students) {
		for (Student student : students) {
			student.showInfor();
		}
	}

	public static void updateStudent(Scanner sc, List<Student> students) {
		System.out.println("Nhập mã sinh viên muốn sửa");
		String maSV = sc.nextLine();
		List<Student> studentLst = students.stream().filter(x -> x.getMaSV().equals(maSV)).collect(Collectors.toList());
		if (!studentLst.isEmpty()) {
			System.out.println("Nhập tên sinh viên");
			String nameSV = sc.nextLine();
			System.out.println("Nhập email sinh viên");
			String email = sc.nextLine();
			System.out.println("Nhập điểm sinh viên");
			Double point = sc.nextDouble();
			sc.nextLine();
			studentLst.get(0).setName(nameSV);
			studentLst.get(0).setEmail(email);
			studentLst.get(0).setPoint(point);
		} else {
			System.out.println("Mã sinh viên không tồn tại!");
		}
	}

	public static void deleteStudent(Scanner sc, List<Student> students) {
		System.out.println("Nhập mã sinh viên muốn xóa");
		String maSV = sc.nextLine();
		List<Student> studentLst = students.stream().filter(x -> x.getMaSV().equals(maSV)).collect(Collectors.toList());
		Iterator<Student> student = studentLst.iterator();
		while (student.hasNext()) {
			student.remove();
		}
	}

	public static void sumPointStudent(Scanner sc, List<Student> students) {
		System.out.println("Điểm trung bình của các sinh viên là");
		Map<String, Double> mapStudent = new HashMap<>();
		mapStudent = students.stream().collect(Collectors.toMap(Student::getName, student -> student.getPoint()));
		mapStudent.forEach((name, avgPoint) -> System.out.printf("→ %s: %.2f\n", name, avgPoint));
	}

	public static void findStudentByPoint(Scanner sc, List<Student> students) {
		System.out.println("Nhập khoảng điểm đầu tiên muốn tìm:");
		Double a = sc.nextDouble();
		sc.nextLine();
		System.out.println("Nhập khoảng điểm thứ hai muốn tìm:");
		Double b = sc.nextDouble();
		sc.nextLine();
		List<Student> studentList = students.stream().filter(x -> x.getPoint() > a || x.getPoint() < b)
				.collect(Collectors.toList());
		for (Student student : studentList) {
			student.showInfor();
		}
	}

	public static void sortStudent(Scanner sc, List<Student> students) {
		List<Student> studentList = students.stream().sorted(Comparator.comparing(Student::getName))
				.collect(Collectors.toList());
		for (Student student : studentList) {
			student.showInfor();
		}
	}

	public static void writerFile(Scanner sc, List<Student> students) {
		System.out.print("Nhập tên file để ghi (VD: students.txt): ");
		String fileName = sc.nextLine();

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
			for (Student student : students) {
				String line = student.getName() + ";" + student.getPoint();
				writer.write(line);
				writer.newLine();
			}
			System.out.println("Ghi file thành công!");
		} catch (IOException e) {
			System.err.println("Lỗi khi ghi file: " + e.getMessage());
		}
	}

	public static void readFile(Scanner sc, List<Student> students) {
		System.out.print("Nhập tên file để đọc (VD: students.txt): ");
		String fileName = sc.nextLine();

		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(";");
				if (parts.length == 2) {
					String name = parts[0];
					Double point = Double.parseDouble(parts[1]);
					Student student = new Student(name, point);
					students.add(student);
				}
			}
			System.out.println("Đọc file thành công!");
		} catch (IOException e) {
			System.err.println("Lỗi khi đọc file: " + e.getMessage());
		}
	}

	public static void email(Scanner sc, List<Student> students) {
		Set<String> email = new HashSet<>();
		email = students.stream().map(t -> t.getEmail()).collect(Collectors.toSet());
	}

	public static void countStudent(Scanner sc, List<Student> students) {
		long count = students.stream().filter(x -> x.getPoint() > 20).count();
	}

	public static void boxStudent(Scanner sc, List<Student> students) {
		for (Student student : students) {
			Box box = new Box(student);
		}
	}

}
