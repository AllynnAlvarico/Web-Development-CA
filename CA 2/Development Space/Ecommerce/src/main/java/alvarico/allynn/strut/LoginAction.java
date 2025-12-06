package alvarico.allynn.strut;

import alvarico.allynn.model.User;
import alvarico.allynn.service.UserAuthenticationService;
import com.opensymphony.xwork2.ActionContext;

import java.util.Map;

public class LoginAction {

    private String username;
    private String password;

    private UserAuthenticationService authService = new UserAuthenticationService();

    public String login() {
        System.out.println(this.getClass().getName() +  ": Login attempt for user: " + username);
        User user = authService.authenticateUser(username, password);

        if (user != null) {
            Map<String, String> session = ActionContext.getContext().getSession();
            session.put("currentUser", user.getUsername());
            session.put("fullName", user.getFullname());
            session.put("email", user.getEmail());

            return "success";
        } else {
            return "error";
        }

    }

    public void setUsername(String username) { this.username = username; }

    public void setPassword(String password) { this.password = password; }

    public String getUsername() { return username; }

    public String getPassword() { return password; }
}
