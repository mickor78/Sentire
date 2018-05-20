package mickor78.Utility;

import javafx.scene.media.Media;
import mickor78.FileOrganizer.Track;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class TrackUtilTest {

    private Track testTrack;
    private File testfile;
    private String filePath;
    private String testName;
    private Media testMedia;

    @BeforeEach
    void setUp() {
        testTrack=new Track(new File(this.getClass().getResource("/mp3/bip.mp3").getFile()));
        filePath = this.getClass().getResource("/mp3/bip.mp3").getPath();
        testfile = new File(filePath);
        System.out.println(testfile.getName());
        testName = "bip";
        testMedia=new Media(testfile.toURI().toString());
    }

    /**
     * Integration test
     */
    @Test
    void callTrackUtil() {
        testTrack = TrackUtil.callTrackUtil(testTrack);
        Assert.assertEquals(testTrack.getTitle().getValue(),testName);
        Assert.assertEquals(testTrack.getFile(),testfile);
        Assert.assertEquals(testTrack.getArtist().getValue(),testName);
        Assert.assertEquals(testTrack.getMedia().getDuration(),testMedia.getDuration());


    }
}