package you.count.youcountdesktopalpha;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class HomeScreenController implements Initializable {

    Hero hero;
    Timer timer;
    MediaPlayer mediaPlayer;


    @FXML
    ImageView mainCharImage, backgroundHomeScreen;

    @FXML
    Label hungerLabel, thirstLabel, pleasureLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        hero = new Hero();
        hero.setBodyImage(mainCharImage);

        Image image = new Image("image/billy.png");
        Image backgroundImage = new Image("image/main_background.png");

        try {
            Media music = new Media(getClass().getResource("/music/main_theme.mp3").toURI().toString());
            mediaPlayer = new MediaPlayer(music);
            mediaPlayer.setVolume(0.2);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }



        mainCharImage.setImage(image);
        backgroundHomeScreen.setImage(backgroundImage);

    }

    public void feedHero(){ hero.eat(15); }
    public void drinkHero(){ hero.drink(16); }
    public void pleaseHero(){ hero.receivePleasure(8); }


    public void heroMove(){
        hero.move();
    }

    public void startLifeCycle(ActionEvent event){

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

                    hungerLabel.setText(String.valueOf(hero.getHunger()));
                    thirstLabel.setText(String.valueOf(hero.getThirst()));
                    pleasureLabel.setText(String.valueOf(hero.getPleasure()));

                });

            }
        };

        timer.scheduleAtFixedRate(task, 0, 100);
    }


}
