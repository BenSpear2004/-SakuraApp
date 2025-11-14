module edu.utsa.cs3743.sakuraapplication {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.utsa.cs3743.sakuraapplication to javafx.fxml;
    exports edu.utsa.cs3743.sakuraapplication;
}