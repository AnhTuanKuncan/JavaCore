package javacore.forsInJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

	}

	public static void evenPositionElement() {
		int[] list = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int sum = 0;
		for (int i = 0; i < list.length; i++) {
			if (i % 2 == 0) {
				sum = sum + list[i];
			}
		}
		System.out.println(sum);
	}

	public static void evenStringElement() {
		List<String> list = Arrays.asList("abcd", "abc");
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).length() > 3) {
				System.out.println(list.get(i));
			}
		}
	}

	public static void evenDoubleElement() {
		List<Double> list = Arrays.asList(2.0, 5.0);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) > 5.0) {
				System.out.println(i);
			}
		}
	}

	public static void evenSetStringElement() {
		Set<String> list = Set.of("Tuấn", "Tuấn 2");
		for (String string : list) {
			System.out.println(string);
		}
	}

	public static void evenSetDoubleElement() {
		double[] list = { 1.0, 2.3, 3.6 };
		int count = 0;
		for (double a : list) {
			if (a > 0.0) {
				count++;
			}
		}
		System.out.println(count);
	}

	public static void evenSetIntegerElement() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		for (Integer a : list) {
			System.out.println(a * a);
		}
	}

	public static void evenStringLambda() {
		List<String> list = Arrays.asList("a", "b", "c", "d");
		list.forEach(x -> System.out.println(x.toUpperCase()));
	}

	public static void evenStringIntegerLambda() {
		Map<String, Integer> list = Map.of("a", 1, "b", 2);
		list.forEach((x, y) -> System.out.println("Tên là" + x + ",Điểm là" + y));
	}

	public static void evenDoubleLambda() {
		Set<Double> list = Set.of(1.5, 5.6);
		list.forEach(x -> {
			if (x > 5.0) {
				System.out.println(x);
			}
		});
	}

	public static void evenStringIterator() {
		List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
		Iterator<String> item = list.iterator();
		while (item.hasNext()) {
			String itemValue = item.next();
			if (itemValue.equals("a")) {
				item.remove();
			}
		}
	}

	public static void evenStringListIterator() {
		List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
		ListIterator<String> item = list.listIterator();
		while (item.hasNext()) {
			String itemValue = item.next();
			if (itemValue.equals("a")) {
				item.set(itemValue.toUpperCase());
			}

		}
	}

	public static void evenStringStream() {
		List<String> list = Arrays.asList("a", "b", "c", "d");
		list.stream().map(String::toUpperCase).filter(x -> x.startsWith("A")).forEach(System.out::println);
	}

	public static void evenStringMap() {
		Map<String, Integer> list = Map.of("a", 1, "b", 6);
		for (Map.Entry<String, Integer> mapList : list.entrySet()) {
			if (mapList.getValue() > 5) {
				System.out.println(mapList);
			}
		}
		for (String key : list.keySet()) {
			System.out.println(key);
		}
		for (Integer value : list.values()) {
			System.out.println(value);
		}
	}

}
