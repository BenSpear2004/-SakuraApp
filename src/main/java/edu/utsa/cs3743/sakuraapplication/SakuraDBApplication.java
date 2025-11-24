package edu.utsa.cs3743.sakuraapplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SakuraDBApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SakuraDBApplication.class.getResource("/edu/utsa/cs3743/sakuraapplication/FXML/Cart.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("SakuraDB");
        stage.setScene(scene);
        stage.show();
    }
}
