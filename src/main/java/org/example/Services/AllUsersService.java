package org.example.Services;

import com.google.gson.Gson;
import org.example.DTO.FriendActionDTO;
import org.example.Models.Request;
import org.example.Models.Response;
import org.example.Network.SocketClient;

import java.util.Arrays;
import java.util.List;

public class AllUsersService {

    private Gson gson = new Gson();

    // A. Get all users with friendship status
    public List<String> getAllUsersWithFriendshipStatus(int currentUserId) {
        try {
            Request request = new Request(
                    "ALL_USERS",
                    "GET_ALL_USERS",
                    String.valueOf(currentUserId)
            );

            Response response = SocketClient.sendRequest(request);

            if (response == null) {
                System.err.println("Response is null from SocketClient");
                return List.of();
            }

            System.out.println("Response Status: " + response.getStatus());
            System.out.println("Response Message: " + response.getMessage());
            System.out.println("Response Data: " + response.getBody());

            if ("SUCCESS".equals(response.getStatus()) && response.getBody() != null) {
                try {
                    String[] users = gson.fromJson(response.getBody(), String[].class);
                    if (users != null) {
                        return Arrays.asList(users);
                    } else {
                        System.err.println("Parsed users array is null");
                    }
                } catch (Exception e) {
                    System.err.println("Error parsing JSON: " + e.getMessage());
                    e.printStackTrace();
                }
            } else {
                System.err.println("Response not SUCCESS or data is null");
            }

            return List.of();

        } catch (Exception e) {
            System.err.println("Exception in getAllUsersWithFriendshipStatus: " + e.getMessage());
            e.printStackTrace();
            return List.of();
        }
    }

    // B. Send friend request
    public boolean sendFriendRequest(int receiverId, int senderId) {
        try {
            FriendActionDTO dto = new FriendActionDTO();
            dto.setSenderId(senderId);
            dto.setReceiverId(receiverId);

            Request request = new Request(
                    "ALL_USERS",
                    "SEND_REQUEST",
                    gson.toJson(dto)
            );

            Response response = SocketClient.sendRequest(request);

            if (response == null) {
                System.err.println("Null response when sending friend request");
                return false;
            }

            System.out.println("Send friend request response: " + response.getStatus());
            return "SUCCESS".equals(response.getStatus());

        } catch (Exception e) {
            System.err.println("Exception in sendFriendRequest: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // C. Unfriend
    public boolean unfriend(int friendId, int userId) {
        try {
            FriendActionDTO dto = new FriendActionDTO();
            dto.setSenderId(userId);
            dto.setReceiverId(friendId);

            Request request = new Request(
                    "ALL_USERS",
                    "UNFRIEND",
                    gson.toJson(dto)
            );

            Response response = SocketClient.sendRequest(request);

            if (response == null) {
                System.err.println("Null response when unfriending");
                return false;
            }

            System.out.println("Unfriend response: " + response.getStatus());
            return "SUCCESS".equals(response.getStatus());

        } catch (Exception e) {
            System.err.println("Exception in unfriend: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}