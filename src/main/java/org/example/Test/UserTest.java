//package org.example.Test;
//
//import org.example.Models.User;
//import org.example.Services.UserService;
//
//public class UserTest {
//
//    public static void main(String[] args) {
//
//        UserService userService = new UserService();
//
//        System.out.println("=== REGISTER TEST ===");
//        User u = new User();
//        u.setUserName("Farida");
//        u.setMail("farida@test.com");
//        u.setPass("123456");
//
//        String registerResult = userService.register(u, "123456");
//        System.out.println(registerResult);
//
//        System.out.println("\n=== LOGIN TEST ===");
//        User loggedUser = userService.loginAndGetUser(
//                "farida@test.com",
//                "123456"
//        );
//
//        if (loggedUser != null) {
//            System.out.println("Login OK");
//            System.out.println("User ID: " + loggedUser.getUserId());
//        } else {
//            System.out.println("Login FAILED");
//        }
//    }
//}
