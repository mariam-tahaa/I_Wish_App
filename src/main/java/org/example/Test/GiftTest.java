//package org.example.Test;
//
//import org.example.Models.Gift;
//import org.example.Services.GiftService;
//
//import java.math.BigDecimal;
//import java.util.List;
//
//public class GiftTest {
//
//    public static void main(String[] args) {
//        try {
//            System.out.println("Starting GiftServiceTest...");
//
//            GiftService service = new GiftService();
//
//            int userId = 1; // لازم يكون موجود في DB
//
//            // ========== ADD GIFT ==========
//            System.out.println("\nAdding new gift...");
//            Gift gift = new Gift();
//            gift.setGiftName("New Test Gift");
//            gift.setDescription("Old Description");
//            gift.setPrice(new BigDecimal("250.00"));
//            gift.setOwnerUserId(userId);
//            
//            String addResult = service.addGift(gift);
//            System.out.println("Add Gift Result: " + addResult);
//
//            // ========== GET USER GIFTS ==========
//            System.out.println("\nFetching gifts for userId: " + userId);
//            List<Gift> gifts = service.getUserGifts(userId);
//
//            System.out.println("Number of gifts: " + gifts.size());
//            for (Gift g : gifts) {
//                System.out.println(
//                        "ID=" + g.getGiftId() +
//                        ", Name=" + g.getGiftName() +
//                        ", Price=" + g.getPrice() +
//                        ", Description=" + g.getDescription()+
//                        ", Status=" + g.getStatus()
//                );
//            }
//
//            // ========== UPDATE GIFT ==========
//            if (!gifts.isEmpty()) {
//                Gift firstGift = gifts.get(8);
//                System.out.println("\nUpdating gift ID: " + firstGift.getGiftId());
//
//                firstGift.setDescription("Updated Gift Discription");
//
//                boolean updateResult = service.updateGift(firstGift);
//                System.out.println("Update Result: " + updateResult);
//            }
//
//            // ========== DELETE GIFT ==========
//            if (!gifts.isEmpty()) {
//                int giftId = gifts.get(0).getGiftId();
//                System.out.println("\nDeleting gift ID: " + giftId);
//
//                String deleteResult = service.deleteGift(giftId, userId);
//                System.out.println("Delete Result: " + deleteResult);
//            }
//
//        } catch (Exception e) {
//            System.err.println("Error in GiftServiceTest: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//}