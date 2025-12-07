package alvarico.allynn.strut;

import alvarico.allynn.model.User;
import alvarico.allynn.service.UserAuthenticationService;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.interceptor.SessionAware;

import java.util.HashMap;
import java.util.Map;

public class LoginAction implements SessionAware {

    private Map<String, Object> session;

    private String fullname;
    private String username;
    private String password;
    private String email;

    private UserAuthenticationService authService = new UserAuthenticationService();

    public String login() {
        System.out.println(this.getClass().getName() +  ": Login attempt for user: " + username);
        User user = authService.authenticateUser(username, password);

        if (user != null) {
            HashMap<String, String> sessionInfo = (HashMap<String, String>) ActionContext.getContext().getSession();
            sessionInfo.put("currentUser", user.getUsername());
            sessionInfo.put("fullName", user.getFullname());
            sessionInfo.put("email", user.getEmail());
            return "success";
        } else {
            return "error";
        }

    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) { this.username = username; }

    public void setPassword(String password) { this.password = password; }

    public String getUsername() { return username; }

    public String getPassword() { return password; }

    public String getEmail() {
        return email;
    }

    public String storeUsername() {
        session.put("currentUser", getUsername());
        session.put("currentUserEmail", getEmail());
        return "success";
    }

    @Override
    public void setSession(Map map) {
        this.session = map;
    }
}
