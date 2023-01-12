package you.count.youcountdesktopalpha;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {

    @FXML
    Button buttonPlay;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        buttonPlay.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> buttonPlay.setStyle("-fx-background-color: HOTPINK;"));
        buttonPlay.addEventHandler(MouseEvent.MOUSE_EXITED, event -> buttonPlay.setStyle(""));

    }

    public void startPlaying(ActionEvent event) throws IOException {

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("home_screen.fxml"));

        AnchorPane pane = loader.load();
        Scene scene = new Scene(pane);

        stage.setScene(scene);
        stage.show();


    }

}
