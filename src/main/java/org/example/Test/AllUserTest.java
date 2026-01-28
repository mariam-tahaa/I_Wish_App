//package org.example.Test;
//
//import org.example.Services.AllUsersService;
//
//import java.util.List;
//
//public class AllUserTest {
//    public static void main(String[] args) {
//        try {
//            System.out.println("Starting AllUserTest...");
//
//            AllUsersService service = new AllUsersService();
//
//            // Test with a specific user ID
//            int currentUserId = 1; // Make sure this ID exists in your database
//
//            System.out.println("Fetching users for userId: " + currentUserId);
//
//            List<String> users = service.getAllUsersWithFriendshipStatus(currentUserId);
//
//            System.out.println("Number of users fetched: " + users.size());
//            System.out.println("All users:");
//            for (String user : users) {
//                System.out.println(user);
//            }
//
//        } catch (Exception e) {
//            System.err.println("Error in test: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//}