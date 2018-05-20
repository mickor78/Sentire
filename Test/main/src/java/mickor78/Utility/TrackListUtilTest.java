package mickor78.Utility;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import mickor78.FileOrganizer.*;
import mickor78.Utility.*;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

import static mickor78.Utility.CleanURL.cleanURL;

class TrackListUtilTest {

    private TrackListUtil trackListUtil;
    private ObservableList<Track> testPlaylist;
    private TrackList testTrackList;
    private Track testTrack;
    private File foo;
    private String Path;
    private String filePath;
    private String outContent;

    @BeforeEach
    void setUp() throws URISyntaxException {
        URI PathUri = getClass().getResource("/mp3").toURI();
        Path = cleanURL(PathUri.getPath());
        testTrackList = new TrackList("TestPlaylist", Path);

        URI FileUri = getClass().getResource("/mp3/bip.mp3").toURI();
        filePath = cleanURL(FileUri.getPath());
        foo = new File(filePath);
        testTrack = new Track(foo, "Test", filePath);
        testTrack = TrackUtil.callTrackUtil(testTrack);


        trackListUtil = new TrackListUtil();
        testPlaylist = FXCollections.observableArrayList();
        testPlaylist.add(testTrack);

        testTrackList.setPlaylist(testPlaylist);


    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void setPathByUser() {
        String data = null;
        try {
            data = this.getClass().getResource("/mp3").toURI().toString();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        trackListUtil.setPathByUser();
        Assert.assertEquals(trackListUtil.getTrackList().getPath(), data);
    }


    @Test
    void searchInPathAndAddToPlaylist() {
        trackListUtil.setPath(this.getClass().getResource("/mp3").getPath());

        try {
            trackListUtil.searchInPathAndAddToPlaylist();
        } catch (Exception ignored) {
        }
        Assert.assertEquals(trackListUtil.getTrackList().getPlaylist().get(0).getFile().getPath(), testTrack.getFile().getPath());

    }

    @Test
    void shuffleTest() {
        trackListUtil.setTrackList(testTrackList);
        trackListUtil.shuffle();
    }
}