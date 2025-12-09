package alvarico.allynn.strut;

import alvarico.allynn.model.User;
import alvarico.allynn.service.RetreiveAllUsersService;

import java.util.List;

public class GetAllUserAction {

    private List<User> users;
    private RetreiveAllUsersService service = new RetreiveAllUsersService();
    private String username;
    private User user;

    public String list() {
        System.out.println(this.getClass().getName() + ": loading all users");
        users = service.getAllUsers();
        System.out.println(this.getClass().getName() + ": loaded " + users.size() + " users");
        return "SUCCESS";
    }

    public String view() {
        System.out.println(getClass().getName() + ": viewing user " + username);
        user = service.getUserByUsername(username);
        return "SUCCESS";
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<User> getUsers() {
        return users;
    }
}
