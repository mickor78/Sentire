package GUIConrollers;

import FileOrganizer.Track;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class PlayerController {
    private Media media = new Media("/music/bip.mp3");
    private MediaPlayer mediaPlayer;
    @FXML
    void initialize(){
        System.out.println("Poszlo");
    }

    @FXML
    void handlePlayTrigger() {
        mediaPlayer.play();
    }


}
