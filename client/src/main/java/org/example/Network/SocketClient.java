package org.example.Network;

import com.google.gson.Gson;
import org.example.Models.Request;
import org.example.Models.Response;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class SocketClient {

    private static final String HOST = "localhost";
    private static final int PORT = 8081;
    private static final Gson gson = new Gson();

    public static Response sendRequest(Request request) {
        try (Socket socket = new Socket(HOST, PORT);
             DataOutputStream out = new DataOutputStream(socket.getOutputStream());
             DataInputStream in = new DataInputStream(socket.getInputStream())) {

            // Convert request to JSON
            String jsonRequest = gson.toJson(request);

            // Send request
            out.writeUTF(jsonRequest);
            out.flush();

            // Receive response
            String jsonResponse = in.readUTF();
            return gson.fromJson(jsonResponse, Response.class);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
