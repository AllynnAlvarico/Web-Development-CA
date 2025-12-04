package alvarico.allynn.service;

import alvarico.allynn.configuration.DatabaseConnection;
import alvarico.allynn.dao.UserDAO;
import alvarico.allynn.model.User;
import alvarico.allynn.model.Product;

public class UserCreationService {
    private DatabaseConnection dbConfig = new DatabaseConnection();
    private User user;
    private UserDAO userDAO = new UserDAO(dbConfig.getLaptopSchema());

    public String createUser(String fullname, String username, String password, String email) {
        try {
            user = new User();
            user.setFullname(fullname);
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);

            userDAO.registerUser(user);
            return "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    public User getUser() {
        return user;
    }}