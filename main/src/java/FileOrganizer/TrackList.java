package FileOrganizer;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class TrackList {

    private IntegerProperty id;
    private StringProperty name;
    private StringProperty path;
    private ObservableList<Track> playlist = FXCollections.observableArrayList();

    /**
     * Default constructor
     */
    public TrackList() {this(9999,"Name","Path");}

    /**
     * Constructor with initial data.
     *
     * @param id
     * @param path
     * @param name
     */

    public TrackList(Integer id, String name, String path) {
        this.id = new SimpleIntegerProperty(id);
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


    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getPath() {
        return path.get();
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
}
