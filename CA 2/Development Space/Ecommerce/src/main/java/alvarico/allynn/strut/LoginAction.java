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

    public LoginAction() {
    }

    public String login() {
        System.out.println(this.getClass().getName() +  ": Login attempt for user: " + username);
//        username = "admin1";
//        password = "123";
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        User user = authService.authenticateUser(username, password);
        if (user == null) {
            System.out.println("Authentication failed for user: " + username);
            return "error";
        }
//        email = user.getEmail();
//        fullname = user.getFullname();

        if (user != null) {
//            session = new HashMap<>();
//            session = ActionContext.getContext().getSession();
//            session.put("currentUser", username);
//            storeUsername(user);
            System.out.println("Authenticated User: " + user.getUsername());
            System.out.println("Authenticated Fullname: " + user.getFullname());
            System.out.println("Authenticated Email: " + user.getEmail());

            fullname = user.getFullname();
            email = user.getEmail();
            session.put("currentUser", username);
            session.put("fullName", fullname);
            session.put("email", email);
            System.out.println(this.getClass().getName() + ": Login action completed.");
            return "success";
        } else {
            return "error";
        }

    }

    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }


    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

//    public String storeUsername(User user) {
//        System.out.println(this.getClass().getName() + ": Accessing storeUsername method.");
//        session.put("currentUser", username);
//        session.put("fullName", user.getFullname());
//        session.put("email", user.getEmail());
//        return "success";
//    }

    @Override
    public void setSession(Map session) {
        this.session = session;
    }
}
