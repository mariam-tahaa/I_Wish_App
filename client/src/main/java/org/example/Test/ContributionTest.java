//package org.example.Test;
//
//import org.example.Models.Contribution;
//import org.example.Services.ContributionService;
//
//import java.math.BigDecimal;
//import java.util.List;
//
//public class ContributionTest {
//
//    public static void main(String[] args) {
//
//        ContributionService service = new ContributionService();
//
//        int currentUserId = 1;
//        int giftId = 2;
//
//        System.out.println("=== ADD CONTRIBUTION ===");
//        Contribution c = new Contribution();
//        c.setGiftId(giftId);
//        c.setPercentage(new BigDecimal("25"));
//
//        boolean added = service.addContribution(c, currentUserId);
//        System.out.println("Added: " + added);
//
//        System.out.println("\n=== GET MY CONTRIBUTIONS ===");
//        List<Contribution> myContributions =
//                service.getFullUserContributions(currentUserId);
//
//        for (Contribution con : myContributions) {
//            System.out.println(
//                    "ID: " + con.getContributionId()
//                            + " Gift: " + con.getGiftId()
//                            + " %: " + con.getPercentage()
//            );
//        }
//
//        if (!myContributions.isEmpty()) {
//            Contribution first = myContributions.get(0);
//
//            System.out.println("\n=== UPDATE CONTRIBUTION ===");
//            boolean updated =
//                    service.updateContributionPercentage(
//                            first.getContributionId(),
//                            new BigDecimal("40")
//                    );
//            System.out.println("Updated: " + updated);
//
//            System.out.println("\n=== DELETE CONTRIBUTION ===");
//            boolean deleted =
//                    service.deleteContribution(first.getContributionId());
//            System.out.println("Deleted: " + deleted);
//        }
//    }
//}
