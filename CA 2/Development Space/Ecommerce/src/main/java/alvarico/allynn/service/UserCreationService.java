package alvarico.allynn.service;

import alvarico.allynn.model.Product;
import alvarico.allynn.model.User;

import java.util.ArrayList;

public class UserCreationService {

    private User user;

    public String createUser(){
        String fullName = "Allynn Alvarico";
        String username = "alvarico123";
        String password = "securePassword!";

        user = new User(fullName, username, password);

        return "User created";
    }

    public String addProductToUser(){
        ProductCreationService ps = new ProductCreationService();
        ps.createProduct("Item 1");
        System.out.println("Product Created");
        user.addProduct(ps.getProduct());
        System.out.println("Product Added to User");
        
        // String product = ps.getProduct();

        // user.addProduct(product);
        // for (int i = 1; i <= 3; i++) {
        //     user.addProduct(ps.createAnotherProduct("Product " + i, "Description for product " + i, 10.0 * i));
        // }

        // user.addProduct(ps.createAnotherProduct("Another Product", "Another product description.", 29.99));

        return "Product added to user";
    }

    public User getUser() {
        return user;
    }

    public ArrayList<String> getUserProducts() {
        return user.getProducts();
    }

}
