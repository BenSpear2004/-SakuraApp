module edu.utsa.cs3743.sakuraapplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    requires javafx.graphics;
    requires edu.utsa.cs3743.sakuraapplication;


    opens edu.utsa.cs3743.sakuraapplication to javafx.fxml;
    exports edu.utsa.cs3743.sakuraapplication;
    exports edu.utsa.cs3743.sakuraapplication.Controller;
    opens edu.utsa.cs3743.sakuraapplication.Controller to javafx.fxml;
}