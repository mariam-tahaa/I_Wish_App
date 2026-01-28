package org.example.Services;

import com.google.gson.Gson;
import org.example.Models.Contribution;
import org.example.Models.Request;
import org.example.Models.Response;
import org.example.Network.SocketClient;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import org.example.DTO.UpdateContributionDTO;

public class ContributionService {

    private final Gson gson = new Gson();

    // ================= ADD CONTRIBUTION =================
    public boolean addContribution(Contribution contribution, int currentUserId) {

        Request request = new Request(
                "CONTRIBUTION",
                "ADD",
                gson.toJson(contribution),
                String.valueOf(currentUserId)
        );
        System.out.println("Adding contribution");
        System.out.println(currentUserId);
        Response response = SocketClient.sendRequest(request);
        return "SUCCESS".equals(response.getStatus());
    }

    // ================= GET USER CONTRIBUTIONS =================
    public List<Contribution> getFullUserContributions(int userId) {

        Request request = new Request(
                "CONTRIBUTION",
                "GET_MY_CONTRIBUTIONS",
                String.valueOf(userId)
        );

        Response response = SocketClient.sendRequest(request);

        if (!"SUCCESS".equals(response.getStatus()) || response.getBody() == null) {
            return List.of();
        }

        Contribution[] arr =
                gson.fromJson(response.getBody(), Contribution[].class);

        return Arrays.asList(arr);
    }

    // ================= GET CONTRIBUTIONS BY GIFT =================
    public List<Contribution> getContributionsByGiftId(int giftId) {

        Request request = new Request(
                "CONTRIBUTION",
                "GET_BY_GIFT",
                String.valueOf(giftId)
        );

        Response response = SocketClient.sendRequest
        (request);

        if (!"SUCCESS".equals(response.getStatus()) || response.getBody() == null) {
            return List.of();
        }

        Contribution[] arr =
                gson.fromJson(response.getBody(), Contribution[].class);

        return Arrays.asList(arr);
    }

    // ================= UPDATE PERCENTAGE =================
    public boolean updateContributionPercentage(
            int contributionId,
            BigDecimal newPercentage
    ) {
        UpdateContributionDTO dto =
        new UpdateContributionDTO(contributionId, newPercentage);
        
        Request request = new Request(
                "CONTRIBUTION",
                "UPDATE_PERCENTAGE",
                gson.toJson(dto)
        );

        Response response = SocketClient.sendRequest(request);
        return "SUCCESS".equals(response.getStatus());
    }

    // ================= DELETE CONTRIBUTION =================
    public boolean deleteContribution(int contributionId) {

        Request request = new Request(
                "CONTRIBUTION",
                "DELETE",
                String.valueOf(contributionId)
        );

        Response response = SocketClient.sendRequest(request);
        return "SUCCESS".equals(response.getStatus());
    }
}
