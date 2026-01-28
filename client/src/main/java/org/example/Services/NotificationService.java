package org.example.Services;

import com.google.gson.Gson;
import org.example.Models.Notification;
import org.example.Models.Request;
import org.example.Models.Response;
import org.example.Network.SocketClient;
import org.example.DTO.NotificationDTO;

import java.util.Arrays;
import java.util.List;

public class NotificationService {

    private Gson gson = new Gson();

    // ========== GET ALL NOTIFICATIONS ==========
    public List<Notification> getAllNotifications(int currentUserId) {
        try {
            Request request = new Request(
                    "NOTIFICATION",
                    "GET_ALL_NOTIFICATIONS",
                    String.valueOf(currentUserId)
            );

            Response response = SocketClient.sendRequest(request);

            if (response != null &&
                "SUCCESS".equals(response.getStatus()) &&
                response.getBody() != null) {

                Notification[] notifications =
                        gson.fromJson(response.getBody(), Notification[].class);
                return Arrays.asList(notifications);
            }

            return List.of();

        } catch (Exception e) {
            System.err.println("Exception in getAllNotifications: " + e.getMessage());
            e.printStackTrace();
            return List.of();
        }
    }

    // ========== MARK NOTIFICATION AS READ ==========
    public boolean markNotificationAsRead(int notificationId) {
        try {
            NotificationDTO dto = new NotificationDTO();
            dto.setNotificationId(notificationId);

            Request request = new Request(
                    "NOTIFICATION",
                    "MARK_AS_READ",
                    gson.toJson(dto)
            );

            Response response = SocketClient.sendRequest(request);

            if (response == null) {
                System.err.println("Null response when marking notification as read");
                return false;
            }

            return "SUCCESS".equals(response.getStatus());

        } catch (Exception e) {
            System.err.println("Exception in markNotificationAsRead: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}