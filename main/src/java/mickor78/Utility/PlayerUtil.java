package mickor78.Utility;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import mickor78.FileOrganizer.*;

/**
 * MediaPlayer JavaFX Object utility
 *
 * @author Michal Korzeniewski
 */
public class PlayerUtil {

    private ObservableList<TrackList> listOfPlaylist = FXCollections.observableArrayList();
    private TrackList currentTracklist;
    private Track currentTrack;
    private int currentTrackIndex;
    private boolean currentIsLast;
    private boolean currentIsFirst;
    private Media currentMedia;
    private Track nextTrack;
    private Track previousTrack;
    private MediaPlayer player;

    private boolean repeat;
    private boolean playerInitialized;

    /**
     * adding current track to play by player
     * @param track
     */
    public void addTrackToCurrentTracklist(Track track) {
        currentTracklist.addToPlaylist(track);
    }

    /**
     * Default constructor
     */
    public PlayerUtil() {
        currentTracklist = new TrackList();
    }

    /**
     * add iput Tracklist to playback queue
     * @param newTrackList
     */
    public void addPlaylistToListOfPlaylist(TrackList newTrackList) {
        listOfPlaylist.add(newTrackList);
    }

    /**
     * set current tracklist o play
     * @param currentTracklist
     */

    public void setCurrentTracklist(TrackList currentTracklist) {
        this.currentTracklist = currentTracklist;
    }

    /**
     * set current media in MediaPlayer
     * @param track
     */
    public void setCurrentMedia(Track track) {
        currentMedia = new Media(track.getFile().toURI().toString());
        currentTrack = track;
        currentTrackIndex = currentTracklist.getPlaylist().indexOf(track);


        //next and previous track util
        currentIsLast = currentTrackIndex == currentTracklist.getPlaylist().size()-1;
        currentIsFirst = currentTrackIndex == 0;

        if (!currentIsLast) nextTrack = currentTracklist.getPlaylist().get(currentTrackIndex + 1);
        if (!currentIsFirst) previousTrack = currentTracklist.getPlaylist().get(currentTrackIndex - 1);

    }


    /**
     * Play next track
     */
    public void playNext() {
        if (player != null) {
            if (!currentIsLast) {
                setCurrentMedia(nextTrack);
                player.stop();
                initialPlayer();
                player.play();
            } else {
                initialPlayer();
                play();
            }
        }
    }

    /**
     * Play previous track
     */
    public void playPrevious() {
        if (player != null) {
            if (!currentIsFirst) {
                setCurrentMedia(previousTrack);
                player.stop();
                initialPlayer();
                player.play();
            } else {
                initialPlayer();
                play();
            }
        }
    }

    public Track getNextTrack() {
        return nextTrack;
    }

    public Track getPreviousTrack() {
        return previousTrack;
    }

    /**
     * Play given track
     */
    public void playCurrentTrack() {
        initialPlayer();
        player.play();
    }

    /**
     * Play current track in player
     */
    public void play() {
        if (player != null) {
            player.play();
            }
    }

    /**
     * pause
     */
    public void pause() {
        player.pause();
    }

    /**
     * stop
     */
    public void stop() {
        player.stop();
    }

    /**
     * initialize player
     */
    public void initialPlayer() {
        playerInitialized = true;
        if (player != null) player.stop();
        player = new MediaPlayer(currentMedia);

        //if repeat true repeat
        repeat(repeat);
    }

    /**
     * get all playlist
     * @return ObservableList<TrackList>
     */

    public ObservableList<TrackList> getAll() {
        return listOfPlaylist;
    }

    /**
     * get played tracklist
     * @return TrackList
     */
    public TrackList getCurrentTracklist() {
        return currentTracklist;
    }

    /**
     * get player
     * @return MediaPlayer
     */
    public MediaPlayer getPlayer() {
        return player;
    }

    public MediaPlayer getMediaPlayer() {
        return player;
    }

    /**
     * get current Track
     * @return Track
     */
    public Track getCurrentTrack() {
        return currentTrack;
    }

    /**
     * set speed rate
     * @param speed
     */
    public void setRate(double speed) {
        player.setRate(speed);
    }

    /**
     * remove playlist like given
     * @param currentPlaylist
     */
    public void removeTracklist(TrackList currentPlaylist) {
        listOfPlaylist.remove(currentPlaylist);
    }

    /**
     * add playlist to playback
     * @param currentPlaylist
     */
    public void addPlaylistToPlayback(TrackList currentPlaylist) {
        for (Track t : currentPlaylist.getPlaylist()
                ) {
            currentTracklist.addToPlaylist(t);
        }
    }

    /**
     * repeat if youWantTo
     * @param iWantTo
     */
    public void repeat(boolean iWantTo) {
        repeat = iWantTo;
            if(iWantTo) {
                player.setOnEndOfMedia(new Runnable() {
                    @Override
                    public void run() {
                        player.seek(Duration.ZERO);
                        repeat(iWantTo);
                    }
                });
            }
    }

    public Media getMedia() {
        return currentMedia;
    }

    /**
     * return true if  player is initialize
     * @return true if player is already initialized
     */

    public boolean isPlayerInitialized() {
        return playerInitialized;
    }
}
