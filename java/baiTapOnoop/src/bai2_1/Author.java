package bai2_1;

import java.util.Scanner;

public class Author {
private String name;
private String email;
private char gender;
public Author(String name, String email, char gender) {
	this.name = name;
	this.email = email;
	this.gender = gender;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public char getGender() {
	return gender;
}
public void setGender(char gender) {
	this.gender = gender;
}
@Override
public String toString() {
	return "Author [name=" + name + ", email=" + email + ", gender=" + gender + "]";
}
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Nhập tên: ");
	String name=sc.nextLine();
	System.out.println("Nhập email: ");
	String email=sc.nextLine();
	System.out.println("Nhập giới tính(Nam:m/ Nữ:n)");
	char gender=sc.next().charAt(0);
	 Author author = new Author(name, email, gender);
	System.out.println("name is: " +author.getName());     
	System.out.println("email is: " +author.getEmail());   
	System.out.println("gender is: " + author.getGender()); 
}
}
