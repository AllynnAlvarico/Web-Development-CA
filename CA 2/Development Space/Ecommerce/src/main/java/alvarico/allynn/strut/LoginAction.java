package alvarico.allynn.strut;

import alvarico.allynn.model.User;
import alvarico.allynn.service.UserAuthenticationService;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class LoginAction implements SessionAware {

    private Map<String, Object> session;

    private String fullname;
    private String username;
    private String password;
    private String email;
//    ArrayList<Product> productList = new ArrayList<>();

    private UserAuthenticationService authService = new UserAuthenticationService();

    public LoginAction() {
        System.out.println(this.getClass().getName() + ": LoginAction constructor called.");
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
//            System.out.println(this.getClass().getName() + ": Initializing session map.");
            System.out.println("Clearing any existing session data.");
            session.clear();
            System.out.println("Session data cleared.");
//            session = new HashMap<>();
//            session = ActionContext.getContext().getSession();
//            session.put("currentUser", username);
//            storeUsername(user);
            System.out.println("Authenticated User: " + user.getUsername());
            System.out.println("Authenticated Fullname: " + user.getFullName());
            System.out.println("Authenticated Email: " + user.getEmail());

            fullname = user.getFullName();
            email = user.getEmail();
            session.put("currentUser", username);
            session.put("fullName", fullname);
            session.put("email", email);
//            session.put("productList", productList);
            System.out.println(this.getClass().getName() + ": Login action completed.");
            // Found bug here and found a solution
            System.out.println("Creating BidSystemAction instance and setting session.");
            BidSystemAction bidSystemAction = new BidSystemAction();
            System.out.println(this.getClass().getName() + ": Setting session in BidSystemAction.");
            bidSystemAction.setSession(session);
            System.out.println("Finished setting session in BidSystemAction.");
            return "success";
        } else {
            return "error";
        }
    }

    public String logout() {
//        https://docs.oracle.com/javase/8/docs/api/java/util/Map.html
        System.out.println(this.getClass().getName() + ": Logging out user: " + session.get("currentUser"));
        System.out.println("Clearing user from map 'session' data.");
        session.clear();
        System.out.println("user is cleared from the map 'session' data.");
        return "logout";
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

    public Map<String, Object> getSession() {
        return session;
    }
}
