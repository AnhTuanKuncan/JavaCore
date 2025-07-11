package javacore;

import java.util.Scanner;

public class DayTwo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		bangCuuChuong();
		mangSoNguyen(sc);
		chuoiPalindrome(sc);
		noiChuoiKytu(sc);
	}

	public static void bangCuuChuong() {
		for (int i = 1; i <= 9; i++) {
			System.out.println("Bảng cửu chương " + i + ":");
			for (int j = 1; j <= 10; j++) {
				System.out.println(i + " x " + j + " = " + (i * j));
			}
			System.out.println();
		}
	}

	public static void mangSoNguyen(Scanner sc) {
		int[] arrays = new int[10];
		System.out.println("Nhập mảng 10 số nguyên");
		for (int i = 0; i < arrays.length; i++) {
			System.out.println("Số thứ" + (i + 1) + ":");
			arrays[i] = sc.nextInt();
		}
		int maxValue = arrays[0];
		int sumValue3 = 0;
		System.out.print("Các số chẵn là:");
		for (int i = 0; i < arrays.length; i++) {
			if (maxValue < arrays[i]) {
				maxValue = arrays[i];
			}
			if (arrays[i] % 2 == 0) {
				System.out.print(arrays[i] + " ");
			}
			if (arrays[i] % 3 == 0) {
				sumValue3 = sumValue3 + arrays[i];
			}
		}
		sc.nextLine();
		System.out.println("\n Số lớn nhất là:" + maxValue);
		System.out.println("\n Tổng các số chia hết cho 3 là:" + sumValue3);
	}

	public static void chuoiPalindrome(Scanner sc) {
		System.out.println("Nhập chuỗi ký tự: ");
		String chuoi = sc.nextLine();
		String reverseChuoi = new StringBuilder(chuoi).reverse().toString();
		if (chuoi.equals(reverseChuoi)) {
			System.out.println("Là chuỗi palindrome");
		} else {
			System.out.println("Không phải chuỗi palindrome");
		}
	}

	public static void noiChuoiKytu(Scanner sc) {
		System.out.println("Nhập họ: ");
		String ho = sc.nextLine();
		System.out.println("Nhập tên đệm: ");
		String dem = sc.nextLine();
		System.out.println("Nhập tên: ");
		String ten = sc.nextLine();
		StringBuilder sb = new StringBuilder();
		sb.append(ho);
		sb.append(" ");
		sb.append(dem);
		sb.append(" ");
		sb.append(ten);
		System.out.println("Tên đầy đủ:" + sb.toString());

	}

}
