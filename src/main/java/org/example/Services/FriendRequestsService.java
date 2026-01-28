package org.example.Services;

import com.google.gson.Gson;
import org.example.DTO.FriendRequestActionDTO;
import org.example.Models.FriendRequest;
import org.example.Models.Request;
import org.example.Models.Response;
import org.example.Network.SocketClient;

import java.util.Arrays;
import java.util.List;

public class FriendRequestsService {

    private final Gson gson = new Gson();

    // A. Get all pending friend requests for current user
    public List<FriendRequest> getPendingFriendRequests(int userId) {
        try {
            Request request = new Request(
                    "FRIEND_REQUEST",
                    "GET_PENDING",
                    String.valueOf(userId)
            );

            Response response = SocketClient.sendRequest(request);

            if (response == null) {
                System.err.println("Response is null");
                return List.of();
            }

            if ("SUCCESS".equals(response.getStatus()) && response.getBody() != null) {
                FriendRequest[] array = gson.fromJson(response.getBody(), FriendRequest[].class);
                return Arrays.asList(array);
            }

            return List.of();

        } catch (Exception e) {
            System.err.println("Error getting pending requests: " + e.getMessage());
            e.printStackTrace();
            return List.of();
        }
    }

    // B. Accept a friend request
    public boolean acceptRequest(int requestId, int currentUserId) {
        try {
            FriendRequestActionDTO dto = new FriendRequestActionDTO();
            dto.setRequestId(requestId);
            dto.setCurrentUserId(currentUserId);

            Request request = new Request(
                    "FRIEND_REQUEST",
                    "ACCEPT",
                    gson.toJson(dto)
            );

            Response response = SocketClient.sendRequest(request);

            if (response == null) {
                System.err.println("Null response when accepting request");
                return false;
            }

            System.out.println("Accept request response: " + response.getStatus());
            return "SUCCESS".equals(response.getStatus());

        } catch (Exception e) {
            System.err.println("Error accepting request: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // C. Decline a friend request
    public boolean declineRequest(int requestId, int currentUserId) {
        try {
            FriendRequestActionDTO dto = new FriendRequestActionDTO();
            dto.setRequestId(requestId);
            dto.setCurrentUserId(currentUserId);

            Request request = new Request(
                    "FRIEND_REQUEST",
                    "DECLINE",
                    gson.toJson(dto)
            );

            Response response = SocketClient.sendRequest(request);

            if (response == null) {
                System.err.println("Null response when declining request");
                return false;
            }

            System.out.println("Decline request response: " + response.getStatus());
            return "SUCCESS".equals(response.getStatus());

        } catch (Exception e) {
            System.err.println("Error declining request: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
