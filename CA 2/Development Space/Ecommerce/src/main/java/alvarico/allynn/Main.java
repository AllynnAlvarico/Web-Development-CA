package alvarico.allynn;

import alvarico.allynn.model.User;
import alvarico.allynn.service.UserCreationService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        UserCreationService ucs = new UserCreationService();

        ucs.createUser();
        // ucs.addProductToUser();

        System.out.println("User and product setup complete.");
        System.out.println("User" + ucs.getUser().getUsername());
        // System.out.println(ucs.getUser().getFullname());
        // System.out.println("Display Products");
        // for (int index = 0; index < ucs.getUserProducts().size(); index++) {
        //     System.out.println("Product: " + ucs.getUserProducts().get(index).toString());
        // }

    }
}