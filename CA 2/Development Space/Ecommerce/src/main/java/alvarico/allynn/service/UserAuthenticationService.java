package alvarico.allynn.service;

import alvarico.allynn.configuration.DatabaseConnection;
import alvarico.allynn.dao.UserDAO;
import alvarico.allynn.model.User;

public class UserAuthenticationService {
    private DatabaseConnection dbConfig = new DatabaseConnection();
    private User user;
    private UserDAO userDAO = new UserDAO(dbConfig.getLaptopSchema());

    public User authenticateUser(String username, String password) {
        System.out.println("Authenticating user: " + username);
        return userDAO.validateUser(username, password);
    }

    public User getUserFromDatabase() {
        System.out.println("Loading User from database");
        return user;
    }
}

