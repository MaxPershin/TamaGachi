package you.count.youcountdesktopalpha;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Hero {

    int is_alive;
    int hunger, thirst, pleasure;
    int moving;

    int hunger_multiplier = 20;
    int thirst_multiplier = 40;
    int pleasure_multiplier = 60;

    ImageView myBodyView;

    public Hero() {

        is_alive = 1;
        moving = 0;
        hunger = 100* hunger_multiplier;
        thirst = 100* thirst_multiplier;
        pleasure = 100* pleasure_multiplier;

    }

    public void setBodyImage(ImageView myBodyView){
        this.myBodyView = myBodyView;
    }

    public void walk(){

        double durationWalk = 0.3;
        double jumpingComponent = durationWalk/7.5;

        TranslateTransition horizontalWalk = new TranslateTransition();
        TranslateTransition verticalJumping = new TranslateTransition();

        horizontalWalk.setByX(200);
        horizontalWalk.setDuration(Duration.minutes(durationWalk));
        horizontalWalk.setNode(myBodyView);
        horizontalWalk.setAutoReverse(true);
        horizontalWalk.setCycleCount(2);
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

    public void move(){

        if (moving == 1) { return; }
        moving = 1;
        walk();

    }

    public void live(){

        hunger--;
        thirst--;
        pleasure--;

        setAlive();

    }

    public void setAlive(){
        if (!(hunger > 0 & thirst > 0)) {
            is_alive = 0;
        }
    }

    public void eat(int amount){ hunger+=amount* hunger_multiplier; }

    public void drink(int amount){ thirst+=amount* thirst_multiplier; }

    public void receivePleasure(int amount){ pleasure+=amount* pleasure_multiplier; }

    public int getHunger() {
        return hunger/ hunger_multiplier;
    }

    public int getThirst() {
        return thirst/ thirst_multiplier;
    }

    public int getPleasure() {
        return pleasure/ pleasure_multiplier;
    }
}
