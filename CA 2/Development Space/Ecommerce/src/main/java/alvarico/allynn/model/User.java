package alvarico.allynn.model;

import java.util.ArrayList;

public class User {
    // private String fullname;
    private String username;
    private String password;
    // private ArrayList<String> products;
    public User() {

    }

    public User(String fullname, String username, String password) {
        // this.fullname = fullname;
        this.username = username;
        this.password = password;
        // this.products = new ArrayList<>();
    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // public void setFullname(String fname) {
    //     this.fullname = fname;
    // }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // public String getFullname() {
    //     return fullname;
    // }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // public void addProduct(String product) {
    //     this.products.add(product);
    // }

    // public ArrayList<String> getProducts() {
    //     return products;
    // }
}
