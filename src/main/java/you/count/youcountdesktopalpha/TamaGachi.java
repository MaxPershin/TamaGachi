package you.count.youcountdesktopalpha;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;


public class TamaGachi extends Application {


    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(TamaGachi.class.getResource("main_screen.fxml"));
        AnchorPane root = fxmlLoader.load();

        Image image = new Image("image/main_menu_background.png");

        root.setBackground(new Background(new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));


        Scene scene = new Scene(root);
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                event.consume();
                on_exit();
            }});


        stage.setTitle("TamaGachi!");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void on_exit(){

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Ты точно уверен?");
        alert.setHeaderText("Ты получил достаточно удовольствия?");
        alert.setContentText("Уверен?");

        if(alert.showAndWait().get() == ButtonType.OK) {

            Platform.exit();

        }
    }

    public static void main(String[] args) {
        launch();
    }
}