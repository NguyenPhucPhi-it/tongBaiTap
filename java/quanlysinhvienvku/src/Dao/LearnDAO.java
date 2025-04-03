package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import quanlysinhvienvku.DatabaseConnection;

public class LearnDAO {
    public void addStudentToClass(int studentID, int classID) {
        String sql = "INSERT INTO Learn (StudentID, ClassID) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, studentID);
            stmt.setInt(2, classID);
            stmt.executeUpdate();
            System.out.println("Sinh viên đã được thêm vào lớp.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
