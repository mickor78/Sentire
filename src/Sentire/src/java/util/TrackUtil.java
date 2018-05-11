package util;

import FileOrganizer.Track;
import FileOrganizer.TrackList;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.media.Media;

import java.io.File;
import java.util.Arrays;
import java.util.List;
/**
 * Utilities to deal with Track.
 *
 * @author Michał Korzeniewski
 * @email mickor78@gmail.com
 */

public class TrackUtil {

    public static final List<String> SUPPORTED_FILE_EXTENSIONS = Arrays.asList(".mp3",".wav");

    /**
     * Get playback from tracklist
     *
     * @param trackList
     * @return ObservableList<Track> tracks
     */

    public static ObservableList<Track> getAll(TrackList trackList) {

        ObservableList<Track> tracks = FXCollections.observableArrayList();

        File dir = new File(trackList.getPath());
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Cannot find audio source directory: " + dir + " please supply a directory as a command line argument");
        }

        for (String file : dir.list((File dir1, String name) -> {
            for(String ext : SUPPORTED_FILE_EXTENSIONS) {
                if (name.endsWith(ext)) {
                    return true;
                }
            }
            return false;
        }))
        {
            String fileURL = dir + "\\" + file;
            String mediaURL = "file:///" + fileURL;

            Track track = new Track();
            Media media = new Media(mediaURL);
            track.setFileName(file.split("-")[0]);
            track.setAlbum(file.split("-")[1]);
            track.setMedia(media);
            track.setFileName(file);
            track.setPath(dir + "/" + file);
            tracks.add(track);
        }

        return tracks;
    }
}
