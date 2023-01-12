package you.count.youcountdesktopalpha;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.util.Timer;
import java.util.TimerTask;

public class HelloController {
    @FXML Pane paneMain;
    @FXML private Label labelTimer;

    int time = 0;

    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {

            Platform.runLater(() -> {
                time++;
                labelTimer.setText(String.valueOf(time));

            });

        }
    };




    @FXML
    protected void onStartButtonClick(ActionEvent event) {

        timer.scheduleAtFixedRate(task, 0, 1000);

    }

    @FXML
    protected void onStopButtonClick(ActionEvent event){

        timer.cancel();

    }


}