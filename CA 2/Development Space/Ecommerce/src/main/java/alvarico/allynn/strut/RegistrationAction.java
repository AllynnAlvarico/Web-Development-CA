package alvarico.allynn.strut;

import alvarico.allynn.service.UserCreationService;

public class RegistrationAction {
    private String fullname, username, password, email;
    private UserCreationService service = new UserCreationService();

    public String register() {
        String outputResult = service.createUser(fullname, username, password, email);
        if (outputResult.equals("SUCCESS")){
            return "User Registered";
        } else {
            return "Register Unsuccessful";
        }
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
