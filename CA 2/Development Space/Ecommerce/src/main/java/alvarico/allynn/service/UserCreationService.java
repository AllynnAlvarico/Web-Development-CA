package alvarico.allynn.service;

import alvarico.allynn.model.Product;
import alvarico.allynn.model.User;

import java.util.ArrayList;

public class UserCreationService {

    private User user;

    public String createUser(){
        String firstName = "Alvarico";
        String lastName = "Allynn";
        String email = "allynn@demo.com";
        String username = "alvarico123";
        String password = "securePassword!";

        user = new User(firstName, lastName, username, password, email);

        return "User created";
    }

    public String addProductToUser(){
        ProductCreationService ps = new ProductCreationService();
        ps.createProduct();

        Product product = ps.getProduct();

        user.addProduct(product);
        for (int i = 1; i <= 3; i++) {
            user.addProduct(ps.createAnotherProduct("Product " + i, "Description for product " + i, 10.0 * i));
        }

        user.addProduct(ps.createAnotherProduct("Another Product", "Another product description.", 29.99));

        return "Product added to user";
    }

    public User getUser() {
        return user;
    }

    public ArrayList<Product> getUserProducts() {
        return user.getProducts();
    }

}
