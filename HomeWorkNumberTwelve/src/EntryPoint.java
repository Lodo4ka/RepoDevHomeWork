import controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Created by lodo4ka on 05/06/2017.
 */
public class EntryPoint extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader firstFXMLLoader = new FXMLLoader();

        firstFXMLLoader.setLocation(this.getClass().getResource("view/login.fxml"));
        AnchorPane firstPane = (AnchorPane) firstFXMLLoader.load();
        Scene firstScene = new Scene(firstPane);

        FXMLLoader secondFXMLLoader = new FXMLLoader();
        secondFXMLLoader.setLocation(getClass().getResource("view/checkingLogin.fxml"));
        AnchorPane secondPane = (AnchorPane) secondFXMLLoader.load();
        Scene secondScene = new Scene(secondPane);

        LoginController loginController = (LoginController) firstFXMLLoader.getController();
        loginController.setSecondScene(secondScene);

        primaryStage.setScene(firstScene);
        primaryStage.setTitle("Welcome");
        primaryStage.show();

    }
}
