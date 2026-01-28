//package org.example.Test;
//
//import org.example.Models.User;
//import org.example.Services.FriendsService;
//
//import java.util.List;
//
//public class FriendTest {
//
//    public static void main(String[] args) {
//
//        FriendsService friendsService = new FriendsService();
//
//        int currentUserId = 2; // Replace with a real user ID from your DB
//
//        // 1. Get all friends
//        System.out.println("===== GET ALL FRIENDS =====");
//        List<Integer> friendIds = friendsService.getAllFriends(currentUserId);
//        System.out.println("Friend IDs: " + friendIds);
//
//        // 2. Get info of first friend
//        if (!friendIds.isEmpty()) {
//            int friendId = friendIds.get(0);
//            User friend = friendsService.getUserById(friendId);
//            System.out.println("Friend info: " + (friend != null ? friend.getUserName() : "Not found"));
//
//            // 3. Unfriend the first friend
//            boolean unfriended = friendsService.unfriend(friendId, currentUserId);
//            System.out.println("Unfriended " + friendId + ": " + unfriended);
//        } else {
//            System.out.println("No friends found to test unfriend.");
//        }
//    }
//}
