package alvarico.allynn.service;

import alvarico.allynn.configuration.DatabaseConnection;
import alvarico.allynn.dao.UserDAO;
import alvarico.allynn.model.User;

import java.util.List;

public class RetreiveAllUsersService {
    private DatabaseConnection dbConfig = new DatabaseConnection();
    private UserDAO userDAO = new UserDAO(dbConfig.getPcSchema());

    public List<User> getAllUsers() {
        List<User> users = userDAO.getAllUsers();

        System.out.println("UserListingService: loaded " + users.size() + " users");
        for (User u : users) {
            System.out.println(" - " + u.getUsername()
                    + " | " + u.getFullname()
                    + " | " + u.getEmail());
        }

        return users;
    }
    public User getUserByUsername(String username) {
        return userDAO.getUserByUsername(username);
    }
}
