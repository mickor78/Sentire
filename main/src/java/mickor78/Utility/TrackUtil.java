package mickor78.Utility;

import mickor78.FileOrganizer.Track;
import javafx.scene.media.Media;

import java.util.Arrays;
import java.util.List;
/**
 * Utilities to deal with Track.
 *
 * @author Michał Korzeniewski
 */

public class TrackUtil {

    public static final List<String> SUPPORTED_FILE_EXTENSIONS = Arrays.asList(".mp3",".wav");
    private Track track;

    public TrackUtil(Track track) {
        this.track = track;
    }

    /**
     * for given track set all information
     *
     * @param track
     * @return
     */
    public static Track callTrackUtil(Track track) {
        TrackUtil trackUtil = new TrackUtil(track);
        trackUtil.setTitle();
        trackUtil.setArtist();
        trackUtil.setPath();
        trackUtil.setMedia();
        Track filledTrack = trackUtil.getTrack();
        return  filledTrack;
    }

    /**
     * set path from file
     */
    private void setPath() {
        track.setPath(track.getFile().getPath());
    }

    /**
     * set artist from name of file
     */
    private void setArtist() {
        String author = track.getFile().getName().split("-")[0].split("\\.")[0];
        track.setArtist(author);
    }

    /**
     * set Title from name of file
     */
    private void setTitle() {
        String name;
        if(track.getFile().getName().split("-").length>=2)
            name = track.getFile().getName().split("-")[1].split("\\.")[0];
        else
            name = track.getFile().getName().split("\\.")[0];
        track.setTitle(name);
    }

    public Track getTrack() {
        return track;
    }

    /**
     * set media of track
     */

    public void setMedia() {
      Media media = new Media(track.getFile().toURI().toString());
      track.setMedia(media);
    }
}
