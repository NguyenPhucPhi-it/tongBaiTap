package file;

import java.io.Serializable;

public class Students implements Serializable{
private String name;
private String gender;
public Students(String name, String gender) {
	this.name = name;
	this.gender = gender;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
@Override
public String toString() {
	return "Student [name=" + name + ", gender=" + gender + "]";
}
public void display() {
	System.out.println(toString());
}
}
