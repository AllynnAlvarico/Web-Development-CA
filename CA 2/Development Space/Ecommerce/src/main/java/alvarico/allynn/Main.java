package alvarico.allynn;

import alvarico.allynn.model.User;
import alvarico.allynn.service.UserCreationService;
import alvarico.allynn.test.RegistrationTest;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

//        registrationTest1();
//        registrationTest2();

    }

    public static void registrationTest1() {
        RegistrationTest rtest = new RegistrationTest();
        rtest.registerTest("10");
        /** Test Passed
         *  Able to register user via terminal or just back end
         * **/
    }

    public static void registrationTest2(){
        RegistrationTest rtest = new RegistrationTest();
        rtest.registrationTest2("6");

        /** Test Failed due to similar username it needs to be a unique as require on mysql
         *  Will change the sql table or should I not? hmmmmm
         *  If I want to test it again make sure the username does not have a duplicate
         *  As I created it on the mysql as a constraint to my backend.
         * **/

        /** Test 4 passed as it broke the process because of duplicate email.
         * **/

        /** Having issues on Registering here as it will take data
         *  Then it registers but after that it will complain about the fullname to be empty or Null
         *
         *  Issue Found!!! On the class of UserCreationService
         *  it requires the setters to be filled in than the constructors!!!
         *  I found another issue I was creating a new User again than reusing the USER and getting the data
         *  this is why I was having issues
         * **/

        /** Issue is Fixed on registering
         * **/
    }
}