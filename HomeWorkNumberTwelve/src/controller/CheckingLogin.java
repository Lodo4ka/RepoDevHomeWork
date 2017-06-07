package controller;

import entity.User;
import exception.ProductShopException;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import repository.db.DbHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import service.LoginService;

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
public class CheckingLogin {

    private Scene thirdScene;

    private LoginService loginService = new LoginService();
    @FXML
    TextField txtUserNameS;

    @FXML
    PasswordField txtPassS;

    @FXML
    Label resultLabelS;


    public void setThirdScene(Scene thirdScene) {
        this.thirdScene = thirdScene;
    }

    @FXML
    public void btnCheck(ActionEvent actionEvent) throws SQLException {


        try{
            String name = txtUserNameS.getText();
            String pass = txtPassS.getText();


            User user = new User(name, pass);


            boolean authorised = loginService.authorised(user);

            if (authorised) {
                resultLabelS.setText("User is authorised");
                Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                primaryStage.setScene(thirdScene);
            } else {
                resultLabelS.setText("Login or password incorrect");
            }
        }
       catch (ProductShopException e){
           System.out.println();
       }



    }
}