package alvarico.allynn.service;

import alvarico.allynn.model.User;

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

}
