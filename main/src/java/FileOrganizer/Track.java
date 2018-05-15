package FileOrganizer;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import javafx.scene.media.Media;

import java.io.File;

/**
 * @author Michal Korzeniewski
 * @mail mickor78@gmail.com
 */

public class Track {


    private File file;
    private StringProperty fileName;
    private StringProperty path;
    private Media media;
    private StringProperty album;
    private StringProperty artist;
    private StringProperty title;
    private StringProperty year;
    private Image image;


    /**
     * Default constructor
     */
    public Track(){this(null,null,null);};


    /**
     * Constructor with some initial data.
     *
     * @param fileName
     * @param file
     * @param path
     */
    public Track(File file, String fileName, String path) {
        this.file = file;
        this.fileName = new SimpleStringProperty(fileName);
        this.path = new SimpleStringProperty(fileName);
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileName() {
        return fileName.get();
    }

    public StringProperty fileNameProperty() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName.set(fileName);
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

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public String getAlbum() {
        return album.get();
    }

    public StringProperty albumProperty() {
        return album;
    }

    public void setAlbum(String album) {
        this.album.set(album);
    }

    public String getArtist() {
        return artist.get();
    }

    public StringProperty artistProperty() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist.set(artist);
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getYear() {
        return year.get();
    }

    public StringProperty yearProperty() {
        return year;
    }

    public void setYear(String year) {
        this.year.set(year);
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}

