package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import quanlysinhvienvku.DatabaseConnection;
import quanlysinhvienvku.Student;

public class StudentDAO {
    public void addStudent(Student student) {
        String sql = "INSERT INTO Student (name, age, email, gpa) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getName());
            stmt.setString(3, student.getEmail());
            stmt.setFloat(4, student.getGpa());
            stmt.executeUpdate();
            System.out.println("Thêm sinh viên thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
