package view;

import java.sql.*;
import java.util.Scanner;

import DATABASE.ClassDAO;
import DATABASE.LearnDAO;
import DATABASE.StudentDAO;
import model.Student;

public class StudentManagementApp {
    private static StudentDAO studentDAO;
    private static LearnDAO learnDAO;
    private static ClassDAO classDAO;
    private static Connection connection;

    public static void main(String[] args) {
        // Giả sử connection đã được thiết lập
        connection = getDatabaseConnection();
        
        studentDAO = new StudentDAO(connection);
        learnDAO = new LearnDAO(connection);
        classDAO = new ClassDAO(connection);

        Scanner scanner = new Scanner(System.in);

        // Đăng nhập
        System.out.print("Enter email to login: ");
        String email = scanner.nextLine();
        Student student = studentDAO.getStudentByEmail(email);
        if (student != null) {
            System.out.println("Welcome " + student.getName());
        } else {
            System.out.println("Invalid email. Please try again.");
        }

        // Các chức năng khác như thêm sinh viên vào lớp
        System.out.println("Enter ClassID to enroll: ");
        int classID = scanner.nextInt();
        learnDAO.addStudentToClass(student.getStudentID(), classID);
        System.out.println("Student enrolled successfully.");

        // In danh sách sinh viên trong lớp
        System.out.println("List of students in class " + classID + ": ");
        for (Student s : studentDAO.getStudentsInClass(classID)) {
            System.out.println(s.getName());
        }
    }

    private static Connection getDatabaseConnection() {
        // Hàm giả lập thiết lập kết nối đến cơ sở dữ liệu (cần cài đặt kết nối thực tế)
        return null;
    }
}

