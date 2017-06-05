package controller;

import db.DbHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;


/**
 * Created by lodo4ka on 05/06/2017.
 */
public class CheckingLogin implements Initializable {


    DbHandler dbHandler;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dbHandler = new DbHandler("jdbc:sqlite:HomeWorkNumberTwelve/DB/registration.sqlite");
    }

    @FXML
    TextField txtUserNameS;

    @FXML
    PasswordField txtPassS;

    @FXML
    Label resultLabelS;


    @FXML
    public void btnCheck(ActionEvent actionEvent) throws SQLException {

        String name = txtUserNameS.getText();
        String pass = txtPassS.getText();

        userExists(name, pass);

}

    void userExists(String name , String pass) throws SQLException {

        List<String> list = Arrays.asList("name", "password");

        HashMap<String, String> conditionMAp = new HashMap<>();
        conditionMAp.put("name", name);
        conditionMAp.put("password", pass);

        ResultSet resultSet = dbHandler.select(list, "user", conditionMAp);

        if (resultSet.next()){
            resultLabelS.setText("User is valid");
        }
        else {
            resultLabelS.setText("User is not valid");
        }

    }
}