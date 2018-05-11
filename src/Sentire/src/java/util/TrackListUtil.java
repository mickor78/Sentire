package util;

import FileOrganizer.TrackList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import java.util.prefs.Preferences;

/**
 * Utilities to deal with Tracklists.
 *
 * @author Michał Korzeniewski
 * @email mickor78@gmail.com
 */

public class TrackListUtil {

    private static final String TRACKLIST_NODE = "sonora.tracklists";
    private static final String TRACKLIST_NUMBER = "TRACKLIST_NUMBER";
    private static final String TRACKLIST_NAME = "TRACKLIST_";
    private static final String TRACKLIST_PATH = "TRACKLIST_PATH_";

    private static final Preferences prefs = Preferences.userRoot().node(TRACKLIST_NODE);

    /**
     * Save tracklist in preferences.
     *
     * @param trackList
     */
    public static void saveTrackList(TrackList trackList) {
        int trackListNumber = prefs.getInt(TRACKLIST_NUMBER, 0) + 1;
        prefs.put(TRACKLIST_NAME + trackListNumber, trackList.getName());
        prefs.put(TRACKLIST_PATH + trackListNumber, trackList.getPath());
        prefs.putInt(TRACKLIST_NUMBER, trackListNumber);
    }

    /**
     * Get all tracklists stored in user preferences.
     *
     * @return List
     */
    public static ObservableList<TrackList> getAll() {

        ObservableList<TrackList> trackLists = FXCollections.observableArrayList();

        for(int index = 1; index <= prefs.getInt(TRACKLIST_NUMBER, 0); index++) {
            String listName = prefs.get(TRACKLIST_NAME + index, null);
            String listPath = prefs.get(TRACKLIST_PATH + index, null);
            TrackList trackList = new TrackList(index, listName, listPath);
            trackLists.add(trackList);
        }

        return trackLists;
    }







}
