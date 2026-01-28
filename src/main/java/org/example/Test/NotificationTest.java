//package org.example.Test;
//
//import org.example.Models.Notification;
//import org.example.Services.NotificationService;
//
//import java.util.List;
//
//public class NotificationTest {
//
//    public static void main(String[] args) {
//        try {
//            System.out.println("Starting NotificationServiceTest...");
//
//            NotificationService service = new NotificationService();
//
//            int currentUserId = 1; // لازم يكون موجود
//
//            // ========== GET ALL NOTIFICATIONS ==========
//            System.out.println("\nFetching notifications for userId: " + currentUserId);
//
//            List<Notification> notifications =
//                    service.getAllNotifications(currentUserId);
//
//            System.out.println("Number of notifications: " + notifications.size());
//
//            for (Notification n : notifications) {
//                System.out.println(
//                        "ID=" + n.getNotId()+
//                        ", Message=" + n.getContent()+
//                        ", Read=" + n.getStatus()
//                );
//            }
//
//            // ========== MARK FIRST NOTIFICATION AS READ ==========
//            if (!notifications.isEmpty()) {
//                int notificationId = notifications.get(0).getNotId();
//                System.out.println("\nMarking notification ID " + notificationId + " as read");
//
//                boolean result =
//                        service.markNotificationAsRead(notificationId);
//
//                System.out.println("Mark as read result: " + result);
//            }
//
//        } catch (Exception e) {
//            System.err.println("Error in NotificationServiceTest: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//}