package alvarico.allynn.test;

import alvarico.allynn.model.User;
import alvarico.allynn.service.UserAuthenticationService;

public class LoginTest {
    public void loginTest() {
        UserAuthenticationService authService = new UserAuthenticationService();

        // Use a real user from user_table
        String testUsername = "alvarico6";
        String testPassword = "securePassword!6";

        User user = authService.authenticateUser(testUsername, testPassword);

        if (user != null) {
            System.out.println("LOGIN SUCCESS");
            System.out.println("Username: " + user.getUsername());
            System.out.println("Fullname: " + user.getFullName());
            System.out.println("Email: " + user.getEmail());
        } else {
            System.out.println("LOGIN FAILED (invalid username or password)");
        }
    }

    public void loginTest(String username, String password) {
        UserAuthenticationService authService = new UserAuthenticationService();

        // Use a real user from user_table
        String testUsername = username;
        String testPassword = password;

        User user = authService.authenticateUser(testUsername, testPassword);

        if (user != null) {
            System.out.println("LOGIN SUCCESS");
            System.out.println("Username: " + user.getUsername());
            System.out.println("Fullname: " + user.getFullName());
            System.out.println("Email: " + user.getEmail());
        } else {
            System.out.println("LOGIN FAILED (invalid username or password)");
        }
    }
}
