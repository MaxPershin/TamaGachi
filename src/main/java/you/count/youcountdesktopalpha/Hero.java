package you.count.youcountdesktopalpha;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import you.count.youcountdesktopalpha.interfaces.Environment;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import you.count.youcountdesktopalpha.interfaces.Item;
import you.count.youcountdesktopalpha.items.Borsch;
import you.count.youcountdesktopalpha.items.BottleOfWater;

import java.net.URISyntaxException;
import java.util.concurrent.ThreadLocalRandom;

public class Hero {

    int is_alive;
    int hunger, thirst, pleasure;
    int moving;

    int hunger_multiplier = 20;
    int thirst_multiplier = 40;
    int pleasure_multiplier = 60;

    int money;
    ImageView myBodyView;
    MediaPlayer heroVoice;

    public Inventory inventory;

    public static Hero staticHero;

    public Hero() throws URISyntaxException {

        staticHero = this;

        is_alive = 1;
        moving = 0;
        hunger = 100* hunger_multiplier;
        thirst = 100* thirst_multiplier;
        pleasure = 100* pleasure_multiplier;
        money = 300;

        inventory = new Inventory();

        inventory.addItem(new Borsch());
        inventory.addItem(new BottleOfWater());
        inventory.addItem(new Borsch());

        Environment house = new VillageHouse();

        Environment livingPlace = house;
        Environment currentPlace = house;



    }

    public void setBodyImage(ImageView myBodyView){
        this.myBodyView = myBodyView;
    }

    public void walk(){

        double screenOveralWidth = myBodyView.getScene().getWindow().getWidth();
        double myPositionOnScreen = myBodyView.getLayoutX()+myBodyView.getTranslateX();
        double myPositionByMyCenter = (myBodyView.getFitWidth()/2) + myPositionOnScreen;

        double durationWalk = ThreadLocalRandom.current().nextDouble(0.01, 0.15);
        double myWalkLength = ThreadLocalRandom.current().nextDouble(myPositionByMyCenter*-1, screenOveralWidth-myPositionByMyCenter);

        double jumpingComponent = durationWalk/7.5;

        TranslateTransition horizontalWalk = new TranslateTransition();
        TranslateTransition verticalJumping = new TranslateTransition();

        horizontalWalk.setByX(myWalkLength);
        horizontalWalk.setDuration(Duration.minutes(durationWalk));
        horizontalWalk.setNode(myBodyView);
        horizontalWalk.setAutoReverse(true);
        horizontalWalk.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                verticalJumping.stop();
                moving = 0;
            }
        });

        verticalJumping.setByY(25);
        verticalJumping.setDuration(Duration.minutes(jumpingComponent));
        verticalJumping.setNode(myBodyView);

        verticalJumping.setAutoReverse(true);
        verticalJumping.setCycleCount(Animation.INDEFINITE);

        horizontalWalk.play();
        verticalJumping.play();

    }

    public void behave(){

        int chanceOfBehave = ThreadLocalRandom.current().nextInt(0, 200);

        System.out.println(chanceOfBehave);

        if (chanceOfBehave == 0) {
            move();
        }


    }

    public void move(){
        if (moving == 1) { return; }
        moving = 1;
        walk();
    }

    public void live(){

        hunger--;
        thirst--;
        pleasure--;


        behave();
        setAlive();

    }

    public void setAlive(){
        if (!(hunger > 0 & thirst > 0)) {
            is_alive = 0;
        }
    }

    public void playConsumeSound(Item item){

        heroVoice = new MediaPlayer(item.getMedia());
        heroVoice.setVolume(0.7);
        heroVoice.play();

    }

    public void consume(Item item) {

        playConsumeSound(item);

        hunger+=item.getFoodSupply()*hunger_multiplier;
        thirst+=item.getWaterSupply()*thirst_multiplier;
        pleasure+=item.getPleasureSupply()*pleasure_multiplier;

        inventory.inventoryItems.remove(item);

        if (hunger > 100*hunger_multiplier){hunger = 100*hunger_multiplier;}
        if (thirst > 100*thirst_multiplier){thirst = 100*thirst_multiplier;}
        if (pleasure > 100*pleasure_multiplier){pleasure = 100*pleasure_multiplier;}


    }


    public int getHunger() {
        return hunger/ hunger_multiplier;
    }

    public int getThirst() {
        return thirst/ thirst_multiplier;
    }

    public int getPleasure() {
        return pleasure/ pleasure_multiplier;
    }

    public int getMoney(){ return money; }

}
