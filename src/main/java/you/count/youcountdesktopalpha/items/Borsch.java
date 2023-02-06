package you.count.youcountdesktopalpha.items;

import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import you.count.youcountdesktopalpha.Hero;
import you.count.youcountdesktopalpha.MediaHost;
import you.count.youcountdesktopalpha.interfaces.Item;

import java.net.URISyntaxException;

public class Borsch implements Item {

    String name, description;
    int waterSupply, foodSupply, pleasureSupply;
    int weight;
    Image myPic;
    Media myMedia;

    public Borsch() throws URISyntaxException {

        name = "Борщик, красный";
        description = "Мощный суп, поднимающий из мертвых кого угодно";
        waterSupply = 4;
        foodSupply = 15;
        pleasureSupply = 2;

        myPic = MediaHost.borschImage;
        myMedia = new Media(getClass().getResource("/music/soupSound.mp3").toURI().toString());



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
        return this;
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
