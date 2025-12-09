package alvarico.allynn.test;

import alvarico.allynn.model.User;
import alvarico.allynn.service.RetreiveAllUsersService;

import java.util.List;

public class RetrievingAllUsersTest {

    RetreiveAllUsersService service = new RetreiveAllUsersService();

    private List<User> users;


    public String testList() {
        System.out.println("=== RetrievingAllUsersTest: start ===");
        users = service.getAllUsers();
        System.out.println("Total users found: " + users.size());
        for (User u : users) {
            System.out.println("User -> username=" + u.getUsername() + ", fullname=" + u.getFullname() +", email=" + u.getEmail());
        }
        return "SUCCESS";
    }

//    public List<User> getUsers() {
//        return users;
//    }
}
