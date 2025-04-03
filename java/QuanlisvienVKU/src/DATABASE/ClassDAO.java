package DATABASE;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassDAO {
    private Connection connection;

    public ClassDAO(Connection connection) {
        this.connection = connection;
    }

    // Lấy danh sách tất cả lớp học
    public List<Class> getAllClasses() {
        List<Class> classes = new ArrayList<>();
        String query = "SELECT * FROM Class";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                classes.add(new Class(rs.getInt("ClassID"), rs.getString("description"), rs.getInt("numberOfCredits")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classes;
    }
}

