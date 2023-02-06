package you.count.youcountdesktopalpha;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import you.count.youcountdesktopalpha.interfaces.Item;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InventoryController implements Initializable {

    @FXML
    TilePane tilePane;

    @FXML
    AnchorPane itemRoot;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        init();

    }

    public void init(){

        try {

            for (Item item : Hero.staticHero.inventory.inventoryItems){

                FXMLLoader fxmlLoader = new FXMLLoader(TamaGachi.class.getResource("storeMenuDirectory/inventoryItemGui.fxml"));
                itemRoot = fxmlLoader.load();
                InventoryItemController controller = fxmlLoader.getController();
                controller.setUp(item, this);
                tilePane.getChildren().addAll(itemRoot);

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void refresh(){

        tilePane.getChildren().clear();
        init();

    }


}
