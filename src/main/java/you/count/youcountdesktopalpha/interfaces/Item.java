package you.count.youcountdesktopalpha.interfaces;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import you.count.youcountdesktopalpha.Hero;

public interface Item {

    public Media getMedia();

    public String getName();

    public String getDescription();

    public int getWeight();

    public Item consume();

    public int getWaterSupply();
    public int getFoodSupply();
    public int getPleasureSupply();

    public Image getImage();
}
