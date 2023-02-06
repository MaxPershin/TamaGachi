package you.count.youcountdesktopalpha;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import you.count.youcountdesktopalpha.interfaces.Item;


public class InventoryItemController {


    @FXML
    Label mainLabel, waterLabel, foodLabel, pleasureLabel;

    @FXML
    ImageView itemImageView;

    Item item;
    InventoryController inventoryController;

    public void setUp(Item item, InventoryController inventoryController){

        this.inventoryController = inventoryController;
        this.item = item;
        mainLabel.setText(item.getName());
        waterLabel.setText(String.valueOf(item.getWaterSupply()));
        foodLabel.setText(String.valueOf(item.getFoodSupply()));
        pleasureLabel.setText(String.valueOf(item.getPleasureSupply()));


        itemImageView.setImage(item.getImage());



    }

    public void consume(ActionEvent event){

        Hero.staticHero.consume(item);
        inventoryController.refresh();




    }
}
