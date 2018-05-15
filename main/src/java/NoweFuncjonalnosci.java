import FileOrganizer.Track;
import FileOrganizer.TrackList;
import javafx.collections.ObservableList;
import util.TrackListUtil;

import java.io.*;
import java.util.Scanner;

public class NoweFuncjonalnosci {

    private TrackList playlista1 = new TrackList();
    private String Path;

    public static void main(String[] args) {
        TrackListUtil nf = new TrackListUtil();

        nf.setSamplePath();
        nf.searchInPathAndAddToPlaylist();
        nf.showPlaylist();




    }


}
