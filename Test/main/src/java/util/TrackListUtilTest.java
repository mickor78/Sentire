package util;

import mickor78.FileOrganizer.*;
import mickor78.util.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class TrackListUtilTest {

    private TrackListUtil trackListUtil;
    private TrackList testTrackList;
    private Track testTrack;
    private File foo;
    private String Path;

    @BeforeEach
    void setUp() throws URISyntaxException {
        URI uri = getClass().getResource("/mp3").toURI();
        Path = TrackListUtil.cleanURL(uri.getPath());
        testTrackList = new TrackList(1,"TestPlaylist",Path);
        testTrack = new Track(foo,"Test",Path);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void setPathByUser() {
//TODO
        //        ByteArrayInputStream in = new ByteArrayInputStream("fooPath".getBytes());
//        System.setIn(in);
//        trackListUtil.setPathByUser();
//        System.out.println(trackListUtil.getPlaylista1().getPath());
    }


    @Test
    void searchInPathAndAddToPlaylist() {
        //TODO
    }

    @Test
    void showPlaylist() {
    }

    @Test
    void getPlaylista1() {
    }
}