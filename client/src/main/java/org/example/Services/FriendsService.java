package org.example.Services;

import com.google.gson.Gson;
import org.example.DTO.FriendDTO;
import org.example.Models.Request;
import org.example.Models.Response;
import org.example.Models.User;
import org.example.Network.SocketClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class FriendsService {

    private Gson gson = new Gson();

    // A. Get all friends of a user
    public List<Integer> getAllFriends(int userId) {
        try {
            Request request = new Request(
                    "FRIENDS",
                    "GET_ALL_FRIENDS",
                    String.valueOf(userId)
            );

            Response response = SocketClient.sendRequest(request);
            if (response == null || !"SUCCESS".equals(response.getStatus())) {
                System.err.println("Failed to get friends: " + (response != null ? response.getMessage() : "No response"));
                return List.of();
            }

            // Response body is a JSON array of users
            User[] users = gson.fromJson(response.getBody(), User[].class);

            // Extract user IDs
            return Arrays.stream(users)
             .map(User::getUserId)
             .collect(Collectors.toList());

        } catch (Exception e) {
            System.err.println("Exception in getAllFriends: " + e.getMessage());
            e.printStackTrace();
            return List.of();
        }
    }

    // B. Unfriend a user
    public boolean unfriend(int friendId, int userId) {
        try {
            FriendDTO dto = new FriendDTO();
            dto.setUserId(userId);
            dto.setFriendId(friendId);

            Request request = new Request(
                    "FRIENDS",
                    "UNFRIEND",
                    gson.toJson(dto)
            );

            Response response = SocketClient.sendRequest(request);
            if (response == null) return false;

            return "SUCCESS".equals(response.getStatus());

        } catch (Exception e) {
            System.err.println("Exception in unfriend: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // C. Get user details by ID
    public User getUserById(int userId) {
        try {
            Request request = new Request(
                    "FRIENDS",
                    "GET_USER",
                    String.valueOf(userId)
            );

            Response response = SocketClient.sendRequest(request);
            if (response == null || !"SUCCESS".equals(response.getStatus())) return null;

            return gson.fromJson(response.getBody(), User.class);

        } catch (Exception e) {
            System.err.println("Exception in getUserById: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
