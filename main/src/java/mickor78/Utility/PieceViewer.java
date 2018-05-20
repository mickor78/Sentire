package mickor78.Utility;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;

/**
 * class with static method showing alert with track information
 *
 * @author Michal Korzeniewski
 */
public  class PieceViewer {
    /**
     * static class with shows allert with informations about track
     * @param playerUtil
     */
    public static void invoke(PlayerUtil playerUtil) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Information about current track");
        alert.setHeaderText(playerUtil.getCurrentTrack().getTitle().getValue());
        alert.setContentText(playerUtil.getCurrentTrack().getArtist().getValue());
        alert.showAndWait();
    }
}