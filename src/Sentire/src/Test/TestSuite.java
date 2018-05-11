import FileOrganizer.Track;
import FileOrganizer.TrackList;
import javafx.collections.ObservableList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.TrackListUtil;

/**
 * @author Michal Korzeniewski
 */
public class TestSuite {

    @Before
    public void before() {
        System.out.println("TrackUtil test");
    }
    @Test
    public void testSaveTrackList(){
        TrackList trackList = new TrackList(1,"foo","foo");
        TrackListUtil trackListUtil = new TrackListUtil();
        trackListUtil.saveTrackList(trackList);
    }

    @Test
    public void testGetAll(){
        TrackList trackList = new TrackList(1,"foo","foo");
        TrackListUtil trackListUtil = new TrackListUtil();
        trackListUtil.saveTrackList(trackList);
        ObservableList<TrackList> list = trackListUtil.getAll();
    }


}
