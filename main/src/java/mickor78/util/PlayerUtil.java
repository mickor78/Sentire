package mickor78.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import mickor78.FileOrganizer.*;


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

    public void addTrackToCurrentTracklist(Track track) {
        currentTracklist.addToPlaylist(track);
    }

    public PlayerUtil() {
        currentTracklist = new TrackList();
    }

    public void addPlaylistToListOfPlaylist(TrackList newTrackList) {
        listOfPlaylist.add(newTrackList);
    }

    public void removeCurrentSetOfTracklist() {
        listOfPlaylist.removeAll();
    }

    public void setCurrentTracklist(TrackList currentTracklist) {
        this.currentTracklist = currentTracklist;
    }

    public void setCurrentMedia(Track track) {
        currentMedia = new Media(track.getFile().toURI().toString());
        currentTrack = track;
        currentTrackIndex = currentTracklist.getPlaylist().indexOf(track);


        currentIsLast = currentTrackIndex == currentTracklist.getPlaylist().size()-1;
        currentIsFirst = currentTrackIndex == 0;

        if (!currentIsLast) nextTrack = currentTracklist.getPlaylist().get(currentTrackIndex + 1);
        if (!currentIsFirst) previousTrack = currentTracklist.getPlaylist().get(currentTrackIndex - 1);

    }


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

    public void playCurrentTrack() {
        initialPlayer();
        player.play();
    }

    public void play() {
        if (player != null) {
            player.play();
        }
    }

    public void pause() {
        player.pause();
    }

    public void stop() {
        player.stop();
    }

    public void initialPlayer() {
        playerInitialized = true;
        if (player != null) player.stop();
        player = new MediaPlayer(currentMedia);
        repeat(repeat);
    }


    public ObservableList<TrackList> getAll() {
        return listOfPlaylist;
    }

    public TrackList getCurrentTracklist() {
        return currentTracklist;
    }

    public MediaPlayer getPlayer() {
        return player;
    }

    public MediaPlayer getMediaPlayer() {
        return player;
    }

    public Track getCurrentTrack() {
        return currentTrack;
    }

    public void setRate(double speed) {
        player.setRate(speed);
    }

    public void removeTracklist(TrackList currentPlaylist) {
        listOfPlaylist.remove(currentPlaylist);
    }

    public void addPlaylistToPlayback(TrackList currentPlaylist) {
        for (Track t : currentPlaylist.getPlaylist()
                ) {
            currentTracklist.addToPlaylist(t);
        }
    }

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

    public boolean isPlayerInitialized() {
        return playerInitialized;
    }
}
