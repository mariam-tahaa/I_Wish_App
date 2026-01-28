module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;
    requires com.google.gson;

    opens org.example to javafx.fxml;
    exports org.example;

    exports org.example.Models;
    exports org.example.Services;
    exports org.example.Network;
    exports org.example.DTO;
    exports org.example.Controllers;

    opens  org.example.Models to com.google.gson;
    opens org.example.DTO to com.google.gson;
    opens org.example.Services to com.google.gson;
    opens org.example.Network to com.google.gson;
//    opens org.example.Controllers to com.google.gson;
    opens org.example.Controllers to javafx.fxml;
}
