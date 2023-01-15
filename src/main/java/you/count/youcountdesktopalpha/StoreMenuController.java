package you.count.youcountdesktopalpha;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollToEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StoreMenuController implements Initializable {

    @FXML
    TilePane tilePane;

    @FXML
    AnchorPane item;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        try {


            for (int i = 0; i<24; i++){

                FXMLLoader fxmlLoader = new FXMLLoader(TamaGachi.class.getResource("storeMenuDirectory/menuItemGui.fxml"));
                item = fxmlLoader.load();
                tilePane.getChildren().addAll(item);

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
