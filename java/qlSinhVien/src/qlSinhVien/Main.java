package qlSinhVien;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<Student> studentList=new ArrayList<>();
	static Scanner sc=new Scanner(System.in);
public static void main(String[] args) {
		int choose;
	do {
		showMenu();
		choose=Integer.parseInt(sc.nextLine());
		switch(choose) {
		case 1:
			inputStudent();
			break;
		case 2:
			editStudent();
			break;
		case 3:
			deleteStudentById();
			break;
		case 4:
			sortStudentByGPA();
			break;
		case 5:
			sortStudentByName();
			break;
		case 6:
			displayStudent();
			break;
		case 7:
			saveFile();
			break;
		case 8:
			break;
		case 9:
			System.out.println("Thoat");
			break;
			default:
				System.out.println("Nhap lai: ");
				break;			
		}
	}while(choose!=9);
}

private static void inputStudent() {
	System.out.println("Nhap so sv:");
	int n=Integer.parseInt(sc.nextLine());
	for(int i=0;i<n;i++) {
		Student std=new Student();
		std.input();
		studentList.add(std);
	}
	
}

private static void editStudent() {
	System.out.println("Nhap id sv can sua: ");
	int id=Integer.parseInt(sc.nextLine());
	for (Student student : studentList) {
		if(student.getId()==id) {
			student.input();
			break;
		}
	}
	
}

private static void deleteStudentById() {

	System.out.println("Nhap id sv can xoa: ");
	int id=Integer.parseInt(sc.nextLine());
	for (Student student : studentList) {
		if(student.getId()==id) {
			studentList.remove(student);
			break;
		}
	}
}

private static void sortStudentByGPA() {
Collections.sort(studentList,new Comparator<Student>() {

	@Override
	public int compare(Student o1, Student o2) {
		if(o1.getGpa()>o2.getGpa()) {
			return -1;
		}
		return 1;
	}
});
	
}

private static void sortStudentByName() {
	Collections.sort(studentList,new Comparator<Student>() {

		@Override
		public int compare(Student o1, Student o2) {
			return -o1.getName().compareToIgnoreCase(o2.getName());
			//(a-z) khi them -1;
		}
	});
		
	}
private static void displayStudent() {
	for (Student student : studentList) {
		student.display();
	}	
}
private static void saveFile() {
System.out.println("Bat dau luu");
FileOutputStream fos=null;
ObjectOutputStream obj=null;

try {
	fos=new FileOutputStream("student.txt",true);
	obj=new ObjectOutputStream(fos);
	for (Student student : studentList) {
		String line=student.getFileLine();
		byte[] b=line.getBytes("UTF_8");
		
		fos.write(b);
	}

} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}finally {
	if(fos!=null) {
		try {
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	if(obj!=null) {
		try {
			obj.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
}

static void showMenu() {
	System.out.println("1.themsv:");
	System.out.println("2.sua sv theop id");
	System.out.println("3.xoa sv theo id");
	System.out.println("4.sap xep theo gpa");
	System.out.println("5.sap xep theo ten");
	System.out.println("6.hien thi");
	System.out.println("7.luu vao file student.txt");
	System.out.println("8.Doc noi dung tu student.txt");
	System.out.println("9.Thoat");
	System.out.println("chon");
	
}
}
