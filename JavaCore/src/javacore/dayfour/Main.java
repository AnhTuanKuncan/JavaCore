package javacore.dayfour;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String [] args) {
		List<Animal> animals = new ArrayList<>();
		animals.add(new Cat());
		animals.add(new Dog());
		for(Animal animal: animals){
			animal.makeSound();
		}
		
		Employee employee  = new Employee("Tuấn", 1000);
		Manager manager = new Manager("Hà Linh", 1000, 2000);
		employee.showInfo();
		manager.showInfo();
		
		 Account acc = new Account("Tuan", "123456");

	     System.out.println("Username: " + acc.getUsername());
	     System.out.println("Password hợp lệ? " + acc.isValidPassword());
	}

}
