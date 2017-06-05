package controller;

import db.DbHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

/**
 * Created by lodo4ka on 05/06/2017.
 */
public class LoginController implements Initializable {


    private Scene secondScene;

    public void setSecondScene(Scene secondScene) {
        this.secondScene = secondScene;
    }

    DbHandler dbHandler;

    @FXML
    private Label resultLabel;
    @FXML
    private TextField txtUserName;
    @FXML
    private PasswordField txtPass;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dbHandler = new DbHandler("jdbc:sqlite:HomeWorkNumberTwelve/DB/registration.sqlite");

        HashMap<String, String> columnMap = new HashMap<>();
        columnMap.put("name", "text");
        columnMap.put("password", "text");


        dbHandler.createTable("user", columnMap);
    }

    @FXML
    public void btnLogin(ActionEvent actionEvent) throws IOException {

        String textField = txtUserName.getText();
        String passField = txtPass.getText();

        HashMap<String, String> columnInsertMap = new HashMap<>();
        columnInsertMap.put("name", textField);
        columnInsertMap.put("password", passField);

        dbHandler.insertInto("user", columnInsertMap);

        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(secondScene);
    }
}
