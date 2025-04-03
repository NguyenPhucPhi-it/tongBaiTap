package DATABASE;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Student;

public class StudentDAO {
    private Connection connection;

    public StudentDAO(Connection connection) {
        this.connection = connection;
    }

    // CRUD: Create student
    public void addStudent(Student student) {
        String query = "INSERT INTO Student (name, age, email, gpa) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getAge());
            stmt.setString(3, student.getEmail());
            stmt.setDouble(4, student.getGpa());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // CRUD: Read student by email
    public Student getStudentByEmail(String email) {
        String query = "SELECT * FROM Student WHERE email = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Student(rs.getInt("StudentID"), rs.getString("name"),
                        rs.getInt("age"), rs.getString("email"), rs.getDouble("gpa"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // CRUD: Update student
    public void updateStudent(Student student) {
        String query = "UPDATE Student SET name = ?, age = ?, gpa = ? WHERE email = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getAge());
            stmt.setDouble(3, student.getGpa());
            stmt.setString(4, student.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // CRUD: Delete student
    public void deleteStudent(String email) {
        String query = "DELETE FROM Student WHERE email = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, email);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lấy tất cả sinh viên trong một lớp học
    public List<Student> getStudentsInClass(int classID) {
        List<Student> students = new ArrayList<>();
        String query = "SELECT s.StudentID, s.name, s.age, s.email, s.gpa " +
                       "FROM Student s JOIN Learn l ON s.StudentID = l.StudentID WHERE l.ClassID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, classID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                students.add(new Student(rs.getInt("StudentID"), rs.getString("name"),
                        rs.getInt("age"), rs.getString("email"), rs.getDouble("gpa")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}

