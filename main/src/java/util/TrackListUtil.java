package util;


import FileOrganizer.Track;
import FileOrganizer.TrackList;
import javafx.collections.ObservableList;

import java.io.*;

/**
 * Utilities to deal with Tracklists.
 *
 * @author Michał Korzeniewski
 * @email mickor78@gmail.com
 */

public class TrackListUtil {
    private TrackList playlista1 = new TrackList();
    private String Path;

    /**
     * Default constructor
     */
    public TrackListUtil() {this(new TrackList(),"");
    }

    /**
     * Constructor with someinitial data
     *
     * @param playlista1
     * @param path
     */

    public TrackListUtil(TrackList playlista1, String path) {
        this.playlista1 = playlista1;
        Path = path;
    }

    /**
     * Read path to search tracks in imputed path
     *
     */
    public void setPathByUser(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Type a Path:");
        try {
            Path = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        playlista1.setPath(Path);
    }

    /**
     * Set path in class to call methods inside class
     *
     * @param path
     */
    public void setPath(String path) {
        Path = path;
    }

    /**
     * Set sample path
     */
    public void setSamplePath(){
        Path= "C:\\Users\\Ja\\Desktop\\PROZ\\Nowości Disco Polo  2017   08.02  -  09.02  2017";
        playlista1.setPath(Path);
    }

    /**
     * Search in Path inside class
     *
     */

    public void searchInPathAndAddToPlaylist(){
        File pathFile = new File(Path);
        File[] matchingFiles = pathFile.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File pathname, String name) {
                return name.endsWith(".mp3");
            }
        });

        for (File i: matchingFiles) {
            Track track = new Track(i,i.getName(),i.getPath());
            playlista1.addToPlaylist(track);
        }
    }

    /**
     * show Playlist on console
     */

    public void showPlaylist(){
        ObservableList<Track> forShowPlaylist = playlista1.getPlaylist();
        int index = 0;
        for (Track t:forShowPlaylist
                ) {
            index++;
            System.out.println(index+". "+t.getFileName());
        }
    }

    /**
     * Methods returns tracklist
     *
     * @return TrackList
     */
    public TrackList getPlaylista1() {
        return playlista1;
    }

    /**
     * Clean characters of URL
     *
     * @param url
     */
    public static String cleanURL(String url) {
        url = url.replace("\\", "\\");
        url = url.replaceAll(" ", "%20");
        url = url.replace("[", "%5B");
        url = url.replace("]", "%5D");
        return url;
    }
}
