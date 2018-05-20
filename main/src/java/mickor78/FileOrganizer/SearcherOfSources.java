package mickor78.FileOrganizer;

import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import mickor78.Utility.TrackListUtil;

import java.io.File;


/**
 * Class with static method, witch handle searching music in folder
 *
 * @author Michal Korzeniewski
 */
public class SearcherOfSources {
    /**
     * Staic method searching music in choosen folders
     *
     * @return TrackList
     */
    public static TrackList invoke() {
        Stage dialogStage = new Stage();
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Wybierz katalog z plikami mp3");
        File selectedDirectory = chooser.showDialog(dialogStage);

        //creating tracklist
        TrackListUtil trackListUtil = new TrackListUtil();
        trackListUtil.setPath(selectedDirectory.getPath());
        trackListUtil.searchInPathAndAddToPlaylist();

        //create Tracklist and add to playerUtil
        return trackListUtil.getTrackList();
    }
}