package you.count.youcountdesktopalpha;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import you.count.youcountdesktopalpha.interfaces.Item;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Inventory {

    ArrayList<Item> inventoryItems;
    AnchorPane inventoryPane;
    int inventoryOpen;
    MediaPlayer openMedia;
    MediaPlayer closeMedia;

    public  Inventory() throws URISyntaxException {

        inventoryItems = new ArrayList<>();
        inventoryOpen = 0;

        Media closeSound = new Media(getClass().getResource("/music/inventoryCloseSound.mp3").toURI().toString());
        closeMedia = new MediaPlayer(closeSound);
        Media openSound = new Media(getClass().getResource("/music/inventoryOpenSound.mp3").toURI().toString());
        openMedia = new MediaPlayer(openSound);

    }

    public void addItem(Item item){

        inventoryItems.add(item);

    }

    public Item getItem(){

        return null;

    }

    public AnchorPane showInventory(AnchorPane rootPane) throws IOException, URISyntaxException {

        if (inventoryOpen == 1) {

            closeMedia.seek(new Duration(0));
            closeMedia.play();


            rootPane.getChildren().remove(inventoryPane);
            inventoryOpen = 0;
            return null; }


        FXMLLoader fxmlLoader = new FXMLLoader(TamaGachi.class.getResource("storeMenuDirectory/inventoryMenu.fxml"));
        inventoryPane = fxmlLoader.load();

        rootPane.getChildren().addAll(inventoryPane);

        double parentWidth = rootPane.getWidth();
        double parentHeight = rootPane.getHeight();

        inventoryPane.setLayoutX(parentWidth/2-(inventoryPane.getPrefWidth()/2));
        inventoryPane.setLayoutY(parentHeight/2-(inventoryPane.getPrefHeight()/2));

        openMedia.seek(new Duration(0));
        openMedia.play();

        inventoryOpen = 1;

        return inventoryPane;

    }


}
