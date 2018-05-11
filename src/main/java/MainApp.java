import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Michal Korzeniewski
 * @email mickor78@gmai.com
 */
public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

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



    }
}
