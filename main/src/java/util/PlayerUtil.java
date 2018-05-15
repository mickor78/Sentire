package util;

import FileOrganizer.Track;
import FileOrganizer.TrackList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class PlayerUtil {

    private ObservableList<TrackList> listOfPlaylist = FXCollections.observableArrayList();
    private TrackList currentTracklist;
    private Media currentTrack;
    private Media nextTrack;
    private Media previousTrack;
    private MediaPlayer player;

    public void addPlaylistToListOfPlaylist(TrackList newTrackList){
        listOfPlaylist.add(newTrackList);
    }

    public void removeCurrentSetOfTracklist(){
        listOfPlaylist.removeAll();
    }

    public void setCurrentTracklist(TrackList currentTracklist) {
        this.currentTracklist = currentTracklist;
    }

    public void setCurrentTrack(Track track){
        currentTrack = new Media(track.getFile().toURI().toString());
    }

    public void playCurrentTrack(){
        player = new MediaPlayer(currentTrack);
        player.play();
    }


}
