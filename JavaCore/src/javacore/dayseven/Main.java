package javacore.dayseven;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Student> students = new ArrayList<>();

		Map<String, Double> pointStudents = new HashMap<>();
		Set<String> emails = new HashSet<>();
		emails.add("tuan@gmail.com");
		emails.add("lan@gmail.com");
		emails.add("tuan@gmail.com");
		emails.add("hoa@gmail.com");
		emails.add("minh@gmail.com");
		List<Box<String>> testBoxEmails = emails.stream().map(email -> new Box<>(email)).collect(Collectors.toList());

		System.out.println("----------Menu-----------");
		System.out.println("1.Thêm sinh viên");
		System.out.println("2.Sửa sinh viên");
		System.out.println("3.Xóa sinh viên");
		System.out.println("4.Hiển thị danh sách sinh viên");
		System.out.println("5.In danh sách sinh viên có điểm lớn hơn 7");
		System.out.println("----------End-----------");
		System.out.println("Nhập số tương ứng để chọn chức năng mong muốn: ");
		String choose = sc.nextLine();
		switch (choose) {
		case "1": {
			addStudent(sc, students, pointStudents);
			break;
		}
		case "2": {
			updateStudent(sc, students);
			break;
		}
		case "3": {
			deleteStudent(sc, students);
			break;
		}
		case "4": {
			showListStudent(students);
			break;
		}
		default:
			System.out.println("Lựa chọn không tồn tại");
		}
	}

	public static void addStudent(Scanner sc, List<Student> students, Map<String, Double> pointStudents) {
		System.out.println("Số lượng sinh viên muốn thêm:");
		int numbers = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < numbers; i++) {
			System.out.println("Sinh viên thứ " + (i + 1));
			System.out.println("Nhập mã sinh viên:");
			String maSV = sc.nextLine();
			System.out.println("Nhập tên sinh viên:");
			String tenSV = sc.nextLine();
			System.out.println("Nhập tuổi sinh viên:");
			int tuoiSV = sc.nextInt();
			sc.nextLine();
			System.out.println("Nhập điểm sinh viên:");
			double diemSV = sc.nextDouble();
			sc.nextLine();
			Student student = new Student(maSV, tenSV, tuoiSV, diemSV);
			students.add(student);
			pointStudents.put(tenSV, diemSV);
		}
	}

	public static void updateStudent(Scanner sc, List<Student> students) {
		System.out.println("Mã sinh viên muốn sửa:");
		String maSV = sc.nextLine();
		for (Student student : students) {
			if (student.getId().equals(maSV)) {
				System.out.println("Nhập tên muốn sửa:");
				String tenSV = sc.nextLine();
				System.out.println("Nhập tuổi muốn sửa:");
				int tuoiSV = sc.nextInt();
				sc.nextLine();
				System.out.println("Nhập điểm muốn sửa:");
				double diemSV = sc.nextDouble();
				sc.nextLine();
				student.setName(tenSV);
				student.setAge(tuoiSV);
				student.setPoint(diemSV);
				System.out.println("Sinh viên đã được sửa");
			} else {
				System.out.println("Không có sinh viên tồn tại!");
			}
		}
	}

	public static void deleteStudent(Scanner sc, List<Student> students) {
		System.out.println("Mã sinh viên muốn xóa:");
		String maSV = sc.nextLine();
		for (Student student : students) {
			if (student.getId().equals(maSV)) {
				students.remove(student);
				System.out.println("Sinh viên đã bị xóa");
			} else {
				System.out.println("Không có sinh viên tồn tại!");
			}
		}
	}

	public static void showListStudent(List<Student> students) {
		for (Student student : students) {
			student.showInfo();
		}
	}

	public static void showListStudentPointSeven(Map<String, Double> pointStudents) {
		for (Map.Entry<String, Double> entry : pointStudents.entrySet()) {
			if (entry.getValue() > 7.0) {
				System.out.println("Những sinh viên có điểm lớn hơn 7 là: " + entry.getKey());
			}
		}
	}

	public static void showStudentPointMax(Map<String, Double> pointStudents) {
		double pointMax = 0;
		boolean forFist = false;
		for (Map.Entry<String, Double> entry : pointStudents.entrySet()) {

			if (forFist == false) {
				pointMax = entry.getValue();
				forFist = true;
			} else {
				if (pointMax < entry.getValue()) {
					pointMax = entry.getValue();
				}
			}

		}
		System.out.println("số điểm cao nhất là: " + pointMax);
	}

	public static void showAge20Student(Scanner sc, List<Student> students) {
		List<Student> studentList20 = students.stream().filter(x -> x.getAge() > 20).collect(Collectors.toList());
		for (Student student : studentList20) {
			student.showInfo();
		}
	}

	public static void sortStudentByName(Scanner sc, List<Student> students) {
		List<Student> studentList20 = students.stream().sorted(Comparator.comparing(Student::getName))
				.collect(Collectors.toList());
		for (Student student : studentList20) {
			student.showInfo();
		}
	}

	public static void sumAge20Student(Scanner sc, List<Student> students) {
		int count = 0;
		List<Student> studentList20 = students.stream().filter(x -> x.getAge() > 20).collect(Collectors.toList());
		for (Student student : studentList20) {
			count++;
		}
		System.out.println("Có " + count + " sinh viên lớn hơn 20 tuổi!");
	}
}
