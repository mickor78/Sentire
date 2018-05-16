package FileOrganizer;

import javafx.collections.ObservableList;
import mickor78.FileOrganizer.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class TrackListTest {

    private TrackList testTrackList;
    private Track testTrack;
    private File foo;

    @Before
    public void setUp() throws Exception {
        testTrackList = new TrackList(1,"TestPlaylist","fooPath");
        testTrack = new Track(foo,"Test","Test");
    }

    @Test
    public void addToPlaylist() {
        testTrackList.addToPlaylist(testTrack);
    }

    @Test
    public void deleteFromPlaylist() {
        testTrackList.addToPlaylist(testTrack);
        testTrackList.deleteFromPlaylist(0);
    }

    @Test
    public void isPathEmpty() {
        testTrackList.setPath("");
        Assert.assertTrue(testTrackList.isPathEmpty());
    }
}