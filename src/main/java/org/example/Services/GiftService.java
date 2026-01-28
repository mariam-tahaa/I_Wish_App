package org.example.Services;

import com.google.gson.Gson;
import org.example.DTO.GiftActionDTO;
import org.example.Models.Gift;
import org.example.Models.Request;
import org.example.Models.Response;
import org.example.Network.SocketClient;

import java.util.Arrays;
import java.util.List;

public class GiftService {

    private Gson gson = new Gson();

    // ========== ADD GIFT ==========
    public String addGift(Gift gift) {
        try {
            GiftActionDTO dto = new GiftActionDTO();
            dto.setGiftName(gift.getGiftName());
            dto.setPrice(gift.getPrice());
            dto.setOwnerUserId(gift.getOwnerUserId());
            dto.setDescription(gift.getDescription());
            dto.setStatus(gift.getStatus());

            Request request = new Request(
                    "Gifts",
                    "ADD_GIFT",
                    gson.toJson(dto)
            );

            Response response = SocketClient.sendRequest(request);

            if (response == null) return "Server not responding";

            return response.getMessage();

        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    // ========== GET USER GIFTS ==========
    public List<Gift> getUserGifts(int userId) {
        try {
            Request request = new Request(
                    "Gifts",
                    "GET_USER_GIFTS",
                    String.valueOf(userId)
            );

            Response response = SocketClient.sendRequest(request);

            if (response != null && "SUCCESS".equals(response.getStatus())
                    && response.getBody() != null) {

                Gift[] gifts = gson.fromJson(response.getBody(), Gift[].class);
                return Arrays.asList(gifts);
            }

            return List.of();

        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    // ========== DELETE GIFT ==========
    public String deleteGift(int giftId, int userId) {
        try {
            GiftActionDTO dto = new GiftActionDTO();
            dto.setGiftId(giftId);
            dto.setOwnerUserId(userId);

            Request request = new Request(
                    "Gifts",
                    "DELETE_GIFT",
                    gson.toJson(dto)
            );

            Response response = SocketClient.sendRequest(request);

            if (response == null) return "Server not responding";

            return response.getMessage();

        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    // ========== UPDATE GIFT ==========
    public boolean updateGift(Gift gift) {
        try {
            GiftActionDTO dto = new GiftActionDTO();
            dto.setGiftId(gift.getGiftId());
            dto.setGiftName(gift.getGiftName());
            dto.setPrice(gift.getPrice());
            dto.setStatus(gift.getStatus());
            dto.setDescription(gift.getDescription());
            dto.setOwnerUserId(gift.getOwnerUserId());
            
            System.out.println("Client Service");
            System.out.println(gift.getDescription());
            Request request = new Request(
                    "Gifts",
                    "UPDATE_GIFT",
                    gson.toJson(dto)
            );

            Response response = SocketClient.sendRequest(request);

            return response != null && "SUCCESS".equals(response.getStatus());

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // ========== GET GIFT BY ID ==========
    public Gift getGiftById(int giftId) {
        try {
            Request request = new Request(
                    "Gifts",
                    "GET_GIFT_BY_ID",
                    String.valueOf(giftId)
            );

            Response response = SocketClient.sendRequest(request);

            if (response != null && "SUCCESS".equals(response.getStatus())
                    && response.getBody() != null) {

                return gson.fromJson(response.getBody(), Gift.class);
            }

            return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}