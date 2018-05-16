package mickor78.util;


import javafx.collections.ObservableList;
import mickor78.FileOrganizer.*;

import java.io.*;

/**
 * Utilities to deal with Tracklists.
 *
 * @author Michał Korzeniewski
 * @email mickor78@gmail.com
 */

public class TrackListUtil {
    private TrackList trackList = new TrackList();
    private String Path;
    private String name;

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
        this.trackList = playlista1;
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

        trackList.setPath(Path);
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
        trackList.setPath(Path);
    }

    /**
     * Search in Path inside class
     *
     */

    public void searchInPathAndAddToPlaylist(){
        File pathFile = new File(Path);
        name = pathFile.getName();
        setNameToTrackList();
        File[] matchingFiles = pathFile.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File pathname, String name) {
                return name.endsWith(".mp3");
            }
        });

        for (File i: matchingFiles) {
            Track track = new Track(i);
            track = TrackUtil.callTrackUtil(track);
            trackList.addToPlaylist(track);
        }
    }


    /**
     * show Playlist on console
     */

    public void showPlaylist(){
        ObservableList<Track> forShowPlaylist = trackList.getPlaylist();
        int index = 0;
        for (Track t:forShowPlaylist
                ) {
            index++;
                System.out.println(index+".\t"+t.getTitle()+"\t"+t.getArtist());
        }
    }

    /**
     * Methods returns tracklist
     *
     * @return TrackList
     */
    public TrackList getTrackList() {
        return trackList;
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

    public void setTrackList(TrackList trackList) {
        this.trackList = trackList;
    }

    public void setNameToTrackList(){
        trackList.setName(name);
    }
}
