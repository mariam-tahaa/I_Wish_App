package org.example.Controllers;

import java.io.IOException;

import org.example.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class IndexController {
    @FXML
    private Button loginBtn;

    @FXML
    private Button rgstBtn;

    @FXML
    private void goToLogin(ActionEvent event) throws IOException {
        App.setRoot("login");
    }

    @FXML
    private void goToRegister(ActionEvent event) throws IOException {
        App.setRoot("register");
    }
}
