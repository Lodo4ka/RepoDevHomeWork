import controller.CheckingLogin;
import controller.ProductTableController;
import controller.RegistrationController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
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

        FXMLLoader thirdFXMLLoader = new FXMLLoader();
        thirdFXMLLoader.setLocation(getClass().getResource("view/productTable.fxml"));
        Pane thirdPane = (Pane)thirdFXMLLoader.load();
        Scene thirdScene = new Scene(thirdPane);

        FXMLLoader fourthFXMLLoader = new FXMLLoader();
        fourthFXMLLoader.setLocation(getClass().getResource("view/orderInfo.fxml"));
        AnchorPane fourthPane = (AnchorPane)fourthFXMLLoader.load();
        Scene fourthScene = new Scene(fourthPane);

        RegistrationController registrationController = (RegistrationController) firstFXMLLoader.getController();
        registrationController.setSecondScene(secondScene);

        CheckingLogin checkingLogin = (CheckingLogin)secondFXMLLoader.getController();
        checkingLogin.setThirdScene(thirdScene);

        ProductTableController productTableController = (ProductTableController)thirdFXMLLoader.getController();
        productTableController.setFourthScene(fourthScene);

        primaryStage.setScene(firstScene);
        primaryStage.setTitle("Welcome");
        primaryStage.show();
    }
}
