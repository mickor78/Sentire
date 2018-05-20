package mickor78.FileOrganizer;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

/**
 * Tracklist class holding playlist
 *
 * @author Michal Korzeniewski
 */
public class TrackList {

    private StringProperty name;
    private StringProperty path;
    private ObservableList<Track> playlist = FXCollections.observableArrayList();

    /**
     * Default constructor
     */
    public TrackList() {this("Name","Path");}

    /**
     * Constructor with initial data.
     *
     * @param path
     * @param name
     */

    public TrackList(String name, String path) {
        this.name = new SimpleStringProperty(name);
        this.path = new SimpleStringProperty(path);
    }

    /**
     * Added new track to Observable list
     *
     * @param newTrack
     */

    public void addToPlaylist (Track newTrack){
        this.playlist.add(newTrack);
    }

    /**
     * Remove track from playlist by index
     *
     * @param index
     */

    public void deleteFromPlaylist (int index){
        this.playlist.remove(index);
    }

    /**
     * Returns ObservableList playlist with ability to changing list.
     *
     * @return ObservableList playlist
     */
    public ObservableList<Track> getPlaylist(){
        return this.playlist;
    }




    public StringProperty getName() {
        return name;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public String getPath() {
        return path.getValue();
    }

    public StringProperty pathProperty() {
        return path;
    }

    public void setPath(String path) {
        this.path.set(path);
    }

    /**
     * If Path is empty return true
     * @return boolean
     */
    public boolean isPathEmpty(){ return (0==path.getValue().length());}

    public void deletePlaylist() {
        playlist.removeAll();
    }



    public void setPlaylist(ObservableList<Track> playlist) {
        this.playlist = playlist;
    }
}
