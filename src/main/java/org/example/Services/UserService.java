package org.example.Services;

import com.google.gson.Gson;
import org.example.DTO.LoginDTO;
import org.example.DTO.RegisterDTO;
import org.example.Models.Request;
import org.example.Models.Response;
import org.example.Models.User;
import org.example.Network.SocketClient;

public class UserService {

    private final Gson gson = new Gson();

    // ================= REGISTER =================
    public String register(User user, String rePassword) {

        RegisterDTO dto = new RegisterDTO();
        dto.setUserName(user.getUserName());
        dto.setEmail(user.getMail());
        dto.setPassword(user.getPass());
        dto.setRePassword(rePassword);

        Request request = new Request();
        request.setType("USER");
        request.setAction("REGISTER");
        request.setBody(gson.toJson(dto));

        Response response = SocketClient.sendRequest(request);

        return response.getMessage();
    }

    // ================= LOGIN (STATUS ONLY) =================
    public String login(String email, String password) {

        LoginDTO dto = new LoginDTO();
        dto.setEmail(email);
        dto.setPassword(password);

        Request request = new Request();
        request.setType("USER");
        request.setAction("LOGIN");
        request.setBody(gson.toJson(dto));

        Response response = SocketClient.sendRequest(request);

        return response.getStatus();
    }

    // ================= LOGIN + USER OBJECT =================
    public User loginAndGetUser(String email, String password) {

        LoginDTO dto = new LoginDTO();
        dto.setEmail(email);
        dto.setPassword(password);

        Request request = new Request();
        request.setType("USER");
        request.setAction("LOGIN");
        request.setBody(gson.toJson(dto));

        Response response = SocketClient.sendRequest(request);

        if (!"SUCCESS".equals(response.getStatus())) {
            return null;
        }

        return gson.fromJson(response.getBody(), User.class);
    }

    // ================= GET USER BY ID =================
    public User getUserById(int userId) {

        Request request = new Request();
        request.setType("USER");
        request.setAction("GET_BY_ID");
        request.setBody(String.valueOf(userId));

        Response response = SocketClient.sendRequest(request);

        if (!"SUCCESS".equals(response.getStatus())) {
            return null;
        }

        return gson.fromJson(response.getBody(), User.class);
    }
}
