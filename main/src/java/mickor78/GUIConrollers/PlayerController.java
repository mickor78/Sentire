package mickor78.GUIConrollers;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaPlayer;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import mickor78.FileOrganizer.Track;
import mickor78.FileOrganizer.TrackList;
import mickor78.MainApp;
import mickor78.util.PlayerUtil;
import mickor78.util.TrackListUtil;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.io.File;

public class PlayerController {

    @FXML
    private ListView<Track> playlistView;
    private  ObservableList<Track> observablePlayListView;

@FXML
private Label titleLabel;
@FXML
private Label autorLabel;

@FXML
private Label trackInfo;

@FXML
private Label fastLabel;

@FXML
private Slider sliderFast;


    @FXML
    private Button stopButton;

    @FXML
    private ListView<Track> listPlayback;
    private ObservableList<Track> observablePlaybackList;

    @FXML
    private Button playButton;

    @FXML
    private  Button removeTracklistButton;

    @FXML
    private Button addToPlaybackButton;


    @FXML
    private Button closeButton;

    @FXML
    private Button addPlaylistButton;

    @FXML
    private Button maxButton;

    @FXML
    private ListView<TrackList> trackListView;
    private ObservableList<TrackList> observableTrackList;

    private MainApp mainApp;

    private boolean played;
    private boolean maximalized;
    private PlayerUtil playerUtil;
    private Stage dialogStage;

    //current variables
    private TrackList playBackQueue;
    private TrackList currentPlaylist;
    private Track fooTrack;
    private double speed;
    private Track addToPlayBackTrack;


    /**
     * Set mainApp
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    /**
     * Custom close button
     */
    @FXML
    void handleClose() {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    void handleMaximalize() {
        if (maximalized) {
            maximalized=false;
            mainApp.getPrimaryStage().setMaximized(false);
            mainApp.getPrimaryStage().setMaxHeight(600);
            mainApp.getPrimaryStage().setMinWidth(300);
            mainApp.getPrimaryStage().centerOnScreen();
        } else {
            maximalized = true;
            mainApp.getPrimaryStage().setMaximized(true);
        }

    }



    private void setupTrackListView(){
        observableTrackList = playerUtil.getAll();
        trackListView.setItems(observableTrackList);

        // Set custom cell view
        trackListView.setCellFactory((ListView<TrackList> p) -> {
            ListCell<TrackList> cell = new ListCell<TrackList>() {
                @Override
                protected void updateItem(TrackList trackList, boolean bln) {
                    super.updateItem(trackList, bln);
                    if (trackList != null) {
                        setText(trackList.getName().getValue());
                    }
                }
            };
            return cell;
        });

        //Handle view tracklist on one click
        trackListView.setOnMouseClicked((MouseEvent click)->{
            if(click.getClickCount()==1){
                currentPlaylist.deletePlaylist();
                currentPlaylist = trackListView.getSelectionModel().getSelectedItem();
                refreshList(playlistView);
                setupPlaylistView();
            }
        });

    }

    private void setupPlaylistView(){
        observablePlayListView=currentPlaylist.getPlaylist();
        playlistView.setItems((observablePlayListView));

        playlistView.setCellFactory((ListView<Track> p) -> {
            ListCell<Track> cell = new ListCell<Track>() {
                @Override
                protected void updateItem(Track track, boolean bln) {
                    super.updateItem(track, bln);
                    if (track != null) {
                        setText(track.getTitle().getValue()+" "+track.getArtist().getValue());
                    }
                }
            };
            return cell;
        });

        playlistView.setOnMouseClicked((MouseEvent click)->{
            if(click.getClickCount()==1){
                addToPlayBackTrack=playlistView.getSelectionModel().getSelectedItem();
            }
        });

    }


    @FXML
    void removeTrackListHandle() {
        playerUtil.removeTracklist(currentPlaylist);
        setupTrackListView();
    }

    @FXML
    void addToPlaybackHandle() {
        playerUtil.addTrackToCurrentTracklist(addToPlayBackTrack);
        System.out.println("Wcisłem");
        refreshList(listPlayback);
        setupPlaybackView();
    }





    private void setupPlaybackView(){
        observablePlayListView = playerUtil.getCurrentTracklist().getPlaylist();
        listPlayback.setItems(observablePlayListView);

        listPlayback.setCellFactory((ListView<Track> p) -> {
            ListCell<Track> cell = new ListCell<Track>() {
                @Override
                protected void updateItem(Track track, boolean bln) {
                    super.updateItem(track, bln);
                    if (track != null) {
                        setText(track.getTitle().getValue()+" "+track.getArtist().getValue());
                    }
                }
            };
            return cell;
        });


        listPlayback.setOnMouseClicked((MouseEvent click)->{
            if(click.getClickCount()==2){
                playerUtil.setCurrentMedia(listPlayback.getSelectionModel().getSelectedItem());
                playerUtil.initialPlayer();
                handlePlayTrigger();
                setMediaInfo(listPlayback.getSelectionModel().getSelectedItem());
            }
        });
    }


    @FXML
    private void handlePlayTrigger(){
        played = playerUtil.getPlayer().getStatus().equals(MediaPlayer.Status.PLAYING);
        if(!played){
            playerUtil.play();
            playButton.setText("Pause");
        }else{
            playerUtil.pause();
            playButton.setText("Play");
        }
    }

    @FXML
    private void handleStopTrgger(){
        playerUtil.stop();
        playButton.setText("Play");
    }

    @FXML
    void handleAddPlaylist() {
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Wybierz katalog z plikami mp3");
        File selectedDirectory = chooser.showDialog(dialogStage);

        //creating tracklist
        TrackListUtil trackListUtil = new TrackListUtil();
        trackListUtil.setPath(selectedDirectory.getPath());
        trackListUtil.searchInPathAndAddToPlaylist();

        //create Tracklist and add to playerUtil
        TrackList newTrackList =trackListUtil.getTrackList();
        playerUtil.addPlaylistToListOfPlaylist(newTrackList);
        }


        @FXML
        private void handleTrackInfo(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Information about current track");
        alert.setHeaderText(playerUtil.getCurrentTrack().getTitle().getValue());
        alert.setContentText(playerUtil.getCurrentTrack().getArtist().getValue());
        alert.showAndWait();
        }



    @FXML
    void initialize() {
        playerUtil = new PlayerUtil();
        currentPlaylist = new TrackList();

        playingSpeedHandler();
        setupTrackListView();
    }

    private void playingSpeedHandler() {
        sliderFast.valueProperty().addListener(((observable, oldValue, newValue) -> {
            speed = Math.exp(Math.pow(newValue.doubleValue()/50,1.0));
            fastLabel.setText(String.format("%.2f",speed)+"x");
            playerUtil.setRate(speed);
        } ));
    }

    public void refreshTable(TableView table) {
        for (int i = 0; i < table.getColumns().size(); i++) {
            TableColumn tableColumn = ((TableColumn) (table.getColumns().get(i)));
            if(tableColumn.isVisible()) {
                tableColumn.setVisible(false);
                tableColumn.setVisible(true);
            }
        }
    }

    public void refreshList(ListView listView) {
        ObservableList<TrackList> items = listView.getItems();
        listView.setItems(null);
        listView.setItems(items);
    }

    public void setMediaInfo(Track track){
        titleLabel.setText(track.getTitle().getValue());
        autorLabel.setText(track.getArtist().getValue());
    }




}


