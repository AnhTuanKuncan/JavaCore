package javacore.daysix;

public class Student {
	private String name;
 	private int age;
 	private String email;
 	
 	public Student(String name, int age, String email) {
 		this.name = name;
 		this.age = age;
 		this.email = email;
 	}
 	
 	public String convertLine() {
 		return name + "," + age + "," + email;
 	}
 	
 	 public static Student fromString(String line) {
         String[] parts = line.split(",");
         return new Student(parts[0], Integer.parseInt(parts[1]), parts[2]);
     }
 	 
 	public void showInfo() {
        System.out.println("Tên: " + name + ", Tuổi: " + age + ", Email: " + email);
    }
}
