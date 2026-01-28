package org.example.DTO;
public class FriendRequestActionDTO {
    private int requestId;
    private int currentUserId;

    public int getRequestId() {
        return requestId;
    }

    public int getCurrentUserId() {
        return currentUserId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public void setCurrentUserId(int currentUserId) {
        this.currentUserId = currentUserId;
    }
    
}
