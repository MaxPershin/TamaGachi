package you.count.youcountdesktopalpha.items;

import javafx.scene.image.Image;
import javafx.scene.media.Media;
import you.count.youcountdesktopalpha.MediaHost;
import you.count.youcountdesktopalpha.interfaces.Item;

import java.net.URISyntaxException;

public class BottleOfWater implements Item {


    String name, description;
    int weight, waterSupply, foodSupply, pleasureSupply;
    Image myPic;
    Media myMedia;

    public BottleOfWater() throws URISyntaxException {

        name = "Бутылочка воды";
        description = "Живительная сила";
        waterSupply = 5;
        foodSupply = 0;
        pleasureSupply = 1;

        myPic = MediaHost.waterImage;
        myMedia = new Media(getClass().getResource("/music/waterSound.mp3").toURI().toString());
    }


    @Override
    public Media getMedia() {
        return myMedia;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getWeight() {
        return 0;
    }

    @Override
    public Item consume() {
        return null;
    }

    @Override
    public int getWaterSupply() {
        return waterSupply;
    }

    @Override
    public int getFoodSupply() {
        return foodSupply;
    }

    @Override
    public int getPleasureSupply() {
        return pleasureSupply;
    }

    @Override
    public Image getImage() {
        return myPic;
    }
}
