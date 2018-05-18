package mickor78.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import mickor78.FileOrganizer.*;


public class PlayerUtil {

    private ObservableList<TrackList> listOfPlaylist = FXCollections.observableArrayList();
    private TrackList currentTracklist;
    private Track currentTrack;
    private Media currentMedia;
    private Media nextTrack;
    private Media previousTrack;
    private MediaPlayer player;


    public void addTrackToCurrentTracklist(Track track){currentTracklist.addToPlaylist(track);}

    public PlayerUtil() {
        currentTracklist = new TrackList();
    }

    public void addPlaylistToListOfPlaylist(TrackList newTrackList){
        listOfPlaylist.add(newTrackList);
    }

    public void removeCurrentSetOfTracklist(){
        listOfPlaylist.removeAll();
    }

    public void setCurrentTracklist(TrackList currentTracklist) {
        this.currentTracklist = currentTracklist;
    }

    public void setCurrentMedia(Track track){
        currentMedia = new Media(track.getFile().toURI().toString());
        currentTrack=track;
    }



    public void playCurrentTrack(){
        initialPlayer();
        player.play();
    }

    public void play(){
        if(player != null) {
                player.play();
        }
    }

    public void pause(){
        player.pause();
    }

    public void stop(){
        player.stop();
    }

    public void initialPlayer() {
        player = new MediaPlayer(currentMedia);
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
}
