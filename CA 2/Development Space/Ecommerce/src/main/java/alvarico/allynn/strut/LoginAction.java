package alvarico.allynn.strut;

import alvarico.allynn.model.User;
import alvarico.allynn.service.UserAuthenticationService;
import com.opensymphony.xwork2.ActionContext;
import java.util.Map;

public class LoginAction {

    private String username;
    private String password;

    private UserAuthenticationService authService = new UserAuthenticationService();

    public String execute() {
        User user = authService.authenticateUser(username, password);
        if (user != null) {
            Map<String, Object> session = ActionContext.getContext().getSession();
            session.put("loggedUser", user.getUsername());
            session.put("fullName", user.getFullname());
            return "success";
        } else {
            return "error";
        }
    }

    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
}
