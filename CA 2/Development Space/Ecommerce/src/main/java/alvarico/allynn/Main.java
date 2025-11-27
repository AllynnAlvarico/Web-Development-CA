package alvarico.allynn;

import alvarico.allynn.model.User;
import alvarico.allynn.service.UserCreationService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        UserCreationService ucs = new UserCreationService();

        ucs.createUser();
        ucs.addProductToUser();

        System.out.println("User and product setup complete.");
        System.out.println(ucs.getUser().fullName());

        for (var product : ucs.getUserProducts()) {
            System.out.println("Product: " + product.getName() + ", Price: " + product.getPrice());
        }

    }
}