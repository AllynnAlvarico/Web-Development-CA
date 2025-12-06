package alvarico.allynn.dao;

import alvarico.allynn.model.User;
import alvarico.allynn.configuration.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private DatabaseConnection dbConfig = new DatabaseConnection();
    private String schemaName;

    public UserDAO(String schemaName) {
        this.schemaName = schemaName;
    }

    public void registerUser(User user) throws SQLException {
        dbConfig.setSchema(this.schemaName);
        String sql = "INSERT INTO user_table (fullname, username, password, email) VALUES (?, ?, ?, ?)";
        try (Connection conn = dbConfig.getDesktopConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getFullname());
            pstmt.setString(2, user.getUsername());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getEmail());
            pstmt.executeUpdate();
        }
    }

    public User validateUser(String username, String password) {
        dbConfig.setSchema(this.schemaName);
        String sql = "SELECT * FROM user_table WHERE username = ? AND password = ?";
        try (Connection conn = dbConfig.getDesktopConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setFullname(rs.getString("fullname"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
