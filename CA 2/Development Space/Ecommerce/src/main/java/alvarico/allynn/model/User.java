package alvarico.allynn.model;

import java.util.ArrayList;

public class User {
    private String fullname;
    private String username;
    private String password;
    private String email;

    public User() {}

    public User(String fullname, String username, String password, String email) {
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public void setFullname(String fullname) { this.fullname = fullname; }

    public void setUsername(String username) { this.username = username; }

    public void setPassword(String password) { this.password = password; }

    public void setEmail(String email) { this.email = email; }

    public String getFullname() { return fullname; }

    public String getUsername() { return username; }


    public String getPassword() { return password; }

    public String getEmail() { return email; }
}

