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
            pstmt.setString(1, user.getFullName());
            pstmt.setString(2, user.getUsername());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getEmail());
            pstmt.executeUpdate();
        }
    }

    public User validateUser(String username, String password) {
        System.out.println(this.getClass().getName() +  ": Validating user: " + username);
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
                System.out.println(this.getClass().getName() +  ": User validated: " + username);
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> getAllUsers() {
        System.out.println(this.getClass().getName() +  ": getting all users");
        System.out.println("Method: getAllUsers");
        dbConfig.setSchema(this.schemaName);

        List<User> users = new ArrayList<>();

        String sql = "SELECT username, fullname, email FROM user_table";

        try (Connection conn = dbConfig.getDesktopConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                User u = new User();
                u.setUsername(rs.getString("username"));
                u.setFullname(rs.getString("fullname"));
                u.setEmail(rs.getString("email"));
                users.add(u);
            }
            System.out.println(this.getClass().getName() +  ": Retrieved " + users.size() + " users.");
            System.out.println("Method: getAllUsers completed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    public User getUserByUsername(String username) {
        System.out.println(this.getClass().getName() +  ": getting user by username: " + username);
        String sql = "SELECT username, fullname, email FROM user_table WHERE username = ?";

        try (Connection conn = dbConfig.getDesktopConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    User u = new User();
                    u.setUsername(rs.getString("username"));
                    u.setFullname(rs.getString("fullname"));
                    u.setEmail(rs.getString("email"));
                    return u;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
