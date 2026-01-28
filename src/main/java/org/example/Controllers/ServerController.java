package org.example.Controllers;

import java.io.IOException;

import org.example.App;

import javafx.fxml.FXML;

public class ServerController {

    @FXML
    private void startServer() {
        System.out.println("Server started");
    }

    @FXML
    private void stopServer() {
        System.out.println("Server stopped");
}
}
