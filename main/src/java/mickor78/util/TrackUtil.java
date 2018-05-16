package mickor78.util;

import mickor78.FileOrganizer.Track;
import javafx.scene.media.Media;

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
    private Track track;

    public TrackUtil(Track track) {
        this.track = track;
    }


    public static Track callTrackUtil(Track track) {
        TrackUtil trackUtil = new TrackUtil(track);
        trackUtil.setTitle();
        trackUtil.setArtist();
        trackUtil.setPath();
        trackUtil.setMedia();
        Track filledTrack = trackUtil.getTrack();
        return  filledTrack;
    }

    private void setPath() {
        track.setPath(track.getFile().getPath());
    }

    private void setArtist() {
        String author = track.getFile().getName().split("-")[0];
        track.setArtist(author);
    }

    private void setTitle() {
        String name;
        if(track.getFile().getName().split("-").length>=2)
            name = track.getFile().getName().split("-")[1];
        else
            name = track.getFile().getName();
        track.setTitle(name);
    }

    public Track getTrack() {
        return track;
    }


    public void setMedia() {
      Media media = new Media(track.getFile().toURI().toString());
    }
}
