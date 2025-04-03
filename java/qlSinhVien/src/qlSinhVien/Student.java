package qlSinhVien;

import java.io.Serializable;
import java.util.Scanner;

public class Student implements Serializable{
private int id, age;
private String name, address;
private float gpa;
public Student() {
	
}
public Student(int id, int age, String name, String address, float gpa) {
	this.id = id;
	this.age = age;
	this.name = name;
	this.address = address;
	this.gpa = gpa;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public float getGpa() {
	return gpa;
}
public void setGpa(float gpa) {
	this.gpa = gpa;
}
public void input() {
	Scanner sc=new Scanner(System.in);
	System.out.println("Nhap id:");
	id=Integer.parseInt(sc.nextLine());
	System.out.println("Nhap ten:");
	name=sc.nextLine();
	System.out.println("Dia chi: ");
	address=sc.nextLine();
	System.out.println("Nhap tuoi: ");
	age=Integer.parseInt(sc.nextLine());
	System.out.println("Nhap gba: ");
	gpa=Float.parseFloat(sc.nextLine());	
}
public void display() {
	System.out.println(this);
}
public String getFileLine() {
	return id+","+name+","+address+","+age+","+gpa+"\n";
}
@Override
public String toString() {
	return "id=" + id + ", age=" + age + ", name=" + name + ", address=" + address + ", gpa=" + gpa + "\n";
}
 
}
