import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 *
 * @author Michal Korzeniewski
 * @email mickor78@gmai.com
 */
public class MainApp extends Application {

    private Stage primaryStage;

    /**
     * Consructor
     */

    public MainApp() {
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Sentire");

        //Undecorated window
        this.primaryStage.initStyle(StageStyle.TRANSPARENT);

        //Set the program icon
        // TODO
        //this.primaryStage.getIcons().add();

        initPlayer();
        }


    /**
     * Show player and init controller
     */

    public void initPlayer() {

        try {
            //Load player overview
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/Player.fxml"));
            AnchorPane anchorPane = loader.load();

            //Show the sceme containing the stackPane
            Scene scene = new Scene(anchorPane);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
