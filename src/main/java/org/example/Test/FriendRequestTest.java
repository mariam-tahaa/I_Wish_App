//package org.example.Test;
//
//import org.example.Models.FriendRequest;
//import org.example.Services.FriendRequestsService;
//
//import java.util.List;
//
//public class FriendRequestTest {
//
//    public static void main(String[] args) {
//        FriendRequestsService service = new FriendRequestsService();
//
//        // Replace this with the actual userId of the logged-in user
//        int currentUserId = 4;  
//
//        System.out.println("===== GET PENDING FRIEND REQUESTS =====");
//        List<FriendRequest> pendingRequests = service.getPendingFriendRequests(currentUserId);
//        if (pendingRequests.isEmpty()) {
//            System.out.println("No pending requests found.");
//        } else {
//            for (FriendRequest fr : pendingRequests) {
//                System.out.println("Request ID: " + fr.getReqId()+
//                                   ", From user: " + fr.getSenderId());
//            }
//        }
//
//        // If there are pending requests, try accepting the first one
//        if (!pendingRequests.isEmpty()) {
//            int requestIdToAccept = pendingRequests.get(0).getReqId();
//            boolean accepted = service.acceptRequest(requestIdToAccept, currentUserId);
//            System.out.println("Accept request ID " + requestIdToAccept + ": " + accepted);
//        }
//
//        // If there are pending requests left, try declining the next one
//        if (pendingRequests.size() > 1) {
//            int requestIdToDecline = pendingRequests.get(1).getReqId();
//            boolean declined = service.declineRequest(requestIdToDecline, currentUserId);
//            System.out.println("Decline request ID " + requestIdToDecline + ": " + declined);
//        }
//    }
//}
