package alvarico.allynn.service;

import alvarico.allynn.configuration.DatabaseConnection;
import alvarico.allynn.dao.UserDAO;
import alvarico.allynn.model.User;

public class UserAuthenticationService {
    private DatabaseConnection dbConfig = new DatabaseConnection();
    private User user;
    private UserDAO userDAO = new UserDAO(dbConfig.getLaptopSchema());

    public User authenticateUser(String username, String password) {
        System.out.println(this.getClass().getName() +  ": Authenticating user: " + username);
        user = userDAO.validateUser(username, password);
        return user;
    }

    public User getUserFromDatabase() {
        System.out.println(this.getClass().getName() +  ": Loading User from database");
        return user;
    }
}

