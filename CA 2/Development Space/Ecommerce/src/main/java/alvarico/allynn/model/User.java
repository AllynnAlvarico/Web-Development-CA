package alvarico.allynn.model;

import java.util.ArrayList;

public class User {
    private String fname;
    private String lname;
    private String username;
    private String password;
    private String email;
    private ArrayList<Product> products;
    public User() {

    }

    public User(String fname, String lname, String username, String password, String email) {
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.products = new ArrayList<>();
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
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

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String fullName() {
        return this.fname + " " + this.lname;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}
