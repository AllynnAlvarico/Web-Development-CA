package alvarico.allynn;

import alvarico.allynn.model.User;
import alvarico.allynn.service.UserCreationService;
import alvarico.allynn.strut.LoginAction;
import alvarico.allynn.test.LoginTest;
import alvarico.allynn.test.RegistrationTest;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

//        registrationTest1();
//        registrationTest2();
//        loginTest();
//        System.out.println("---------------------");
//        loginTest("echo1", "123");
//        System.out.println("---------------------");
////        loginTest("test101", "testpass101");
//        System.out.println("---------------------");

//        LoginAction la = new LoginAction();
//
//        la.login();

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

    public static void loginTest() {
        System.out.println("Starting Login Test...");
        LoginTest loginTest = new LoginTest();
        loginTest.loginTest();
        System.out.println("Login Test Completed.");

        /** Issue 1: Wrong Database selection
         * Had issue with unknown database but its an easy fix on the DatabaseConnection class
         * just need to change from tu914 from laptop database to webdev for desktop database
         * */

        /** Issue: Fixed
         * The issue was I was still calling the the same schema in laptop then I had to change the pc connection
         * to a 'getPcSchema()' method to return the webdev schema then add it to the connection url for pc
         */
    }

    public static void loginTest(String inputUsername, String inputPassword) {
        System.out.println("Starting Login Test 2...");
        LoginTest loginTest = new LoginTest();
        loginTest.loginTest(inputUsername, inputPassword);
        System.out.println("Login Test 2 Completed.");

        /**
         * Test Passed with different credentials
         */

        /**
         * Test Passed with invalid credentials
         * returned null user as expected and showed login failed message
         */

    }
}