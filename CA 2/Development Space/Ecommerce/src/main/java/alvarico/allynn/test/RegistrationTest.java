package alvarico.allynn.test;

import alvarico.allynn.model.User;
import alvarico.allynn.service.UserCreationService;
import alvarico.allynn.strut.RegistrationAction;

public class RegistrationTest {

    public void registerTest(String number) {
        RegistrationAction action = new RegistrationAction();
        action.setFullname("Test User " + number);
        action.setUsername("test" + number);
        action.setPassword("testpass" +number);
        action.setEmail("test"+ number + "@example.com");

        String result = action.register();
        System.out.println("Registration First Test Result: " + result);
    }

    public void registrationTest2(String number) {
        RegistrationAction action = new RegistrationAction();
        /**
         * This code line was the issue.
         * */
//        User usertest = new User("test1", "test10", "password", "abc@email.com");

        action.setFullname("Allynn Alvarico");
        action.setUsername("alvarico" + number);
        action.setPassword("securePassword!" + number);
        action.setEmail("allynn" + number +"@example.com");

        String result = action.register();
        System.out.println("Registration Second Test Result: " + result);
    }
}
