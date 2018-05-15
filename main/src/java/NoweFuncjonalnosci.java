import FileOrganizer.Track;
import FileOrganizer.TrackList;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import util.PlayerUtil;
import util.TrackListUtil;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

import static javafx.application.Application.launch;

public class NoweFuncjonalnosci extends Application{

    private TrackList playlista1 = new TrackList();
    private String Path;


    public static void main(String args[])
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        TrackListUtil nf = new TrackListUtil();

        nf.setSamplePath();
        nf.searchInPathAndAddToPlaylist();
        nf.showPlaylist();

        PlayerUtil playerUtil = new PlayerUtil();


        Scanner in = new Scanner(System.in);
        int index = in.nextInt();
        Track track = nf.getTrackList().getPlaylist().get(index);
        playerUtil.setCurrentTrack(track);
        playerUtil.playCurrentTrack();



        primaryStage.setTitle("Audio Player 1");
        primaryStage.setWidth(200);
        primaryStage.setHeight(200);

        primaryStage.show();

    }
}
