package DATABASE;

import java.sql.*;

public class LearnDAO {
    private Connection connection;

    public LearnDAO(Connection connection) {
        this.connection = connection;
    }

    // Thêm sinh viên vào lớp học
    public void addStudentToClass(int studentID, int classID) {
        String query = "INSERT INTO Learn (StudentID, ClassID) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, studentID);
            stmt.setInt(2, classID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

