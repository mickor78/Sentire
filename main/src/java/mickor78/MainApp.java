package mickor78;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import mickor78.GUIConrollers.PlayerController;

import java.io.IOException;

/**
 *
 * @author Michal Korzeniewski
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
        this.primaryStage.setTitle("Sonora");

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

            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/mickor78/fxml/Player.fxml"));
            AnchorPane anchorPane = loader.load();

            PlayerController playerController = loader.getController();
            playerController.setMainApp(this);

            //Show the sceme containing the stackPane
            Scene scene = new Scene(anchorPane);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
}
