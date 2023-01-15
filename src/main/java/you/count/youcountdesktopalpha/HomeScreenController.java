package you.count.youcountdesktopalpha;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;


import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class HomeScreenController implements Initializable {

    Hero hero;
    Timer timer;
    MediaPlayer mediaPlayer;
    AnchorPane storePane;

    int mainMenuOpen = 0;

    @FXML AnchorPane homeScreenPane;
    @FXML HBox moneyPane;

    @FXML
    ProgressBar healthProgressBar, hungerProgressBar, thirstProgressBar, pleasureProgressBar;

    @FXML
    ImageView mainCharImage, backgroundHomeScreen, moneyImage, inventoryIconImageView, houseIcon;

    @FXML
    Label moneyLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Hero creation
        hero = new Hero();
        hero.setBodyImage(mainCharImage);

        Image image = new Image("image/billy.png");
        Image backgroundImage = new Image("image/village_house.png");
        Image moneyImageIcon = new Image(("image/money_icon.png"));
        Image inventoryIcon = new Image("image/inventory_icon.png");
        Image houseImage = new Image("image/house_icon.png");

        //Media initialization
        try {
            Media music = new Media(getClass().getResource("/music/main_theme.mp3").toURI().toString());
            mediaPlayer = new MediaPlayer(music);
            mediaPlayer.setVolume(0.2);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        //Creating scene graphics
        houseIcon.setImage(houseImage);
        inventoryIconImageView.setImage(inventoryIcon);
        moneyImage.setImage(moneyImageIcon);
        mainCharImage.setImage(image);
        backgroundHomeScreen.setImage(backgroundImage);

        settingUpListeners();

    }

    public void settingUpListeners(){

        moneyPane.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                try {
                    showStore();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        });

        inventoryIconImageView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    showStore();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }

    public void feedHero(){ hero.eat(15); }
    public void drinkHero(){ hero.drink(16); }
    public void pleaseHero(){ hero.receivePleasure(8); }

    public void showStore() throws IOException {

        if (mainMenuOpen == 1) {

            homeScreenPane.getChildren().remove(storePane);
            mainMenuOpen = 0;
            return; }




//        Label testLabel = new Label();
//        testLabel.setText("TEST STORE STRING");
//
//        storePane = new AnchorPane();
//        storePane.setPrefSize(500, 500);
//        storePane.setStyle("-fx-background-color: blue");
//        storePane.getChildren().addAll(testLabel);
//
        FXMLLoader fxmlLoader = new FXMLLoader(TamaGachi.class.getResource("storeMenuDirectory/storeMenu.fxml"));
        storePane = fxmlLoader.load();

        homeScreenPane.getChildren().addAll(storePane);

        double parentWidth = homeScreenPane.getWidth();
        double parentHeight = homeScreenPane.getHeight();

        storePane.setLayoutX(parentWidth/2-(storePane.getPrefWidth()/2));
        storePane.setLayoutY(parentHeight/2-(storePane.getPrefHeight()/2));

        mainMenuOpen = 1;

    }

    public void heroMove(){
        hero.move();
    }

    //Life cycle of main Char - this methods has cycle inside
    public void startLifeCycle(ActionEvent event){

        moneyLabel.setText(String.valueOf(hero.getMoney()));

        if (timer != null) {return;}
        //mediaPlayer.play();

        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    //heroMove();
                    hero.live();
                    //DEATH

                    hungerProgressBar.setProgress((double) hero.getHunger()/100);
                    thirstProgressBar.setProgress((double) hero.getThirst()/100);
                    pleasureProgressBar.setProgress((double) hero.getPleasure()/100);


                });

            }
        };

        timer.scheduleAtFixedRate(task, 0, 100);
    }


}
