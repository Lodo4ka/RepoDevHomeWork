package controller;

import entity.User;
import exception.ProductShopException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import service.LoginService;
import utils.Context;


import java.io.IOException;
import java.sql.SQLException;



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


    @FXML
    public void btnCheck(ActionEvent actionEvent) throws SQLException {


        try{
            String name = txtUserNameS.getText();
            String pass = txtPassS.getText();


            User user = new User(name, pass);


            int userId = loginService.authorised(user);

            if (userId > 0) {
                Context.setUser(user);
                resultLabelS.setText("User is authorised");
                try {
                    Parent home_page_parent = FXMLLoader.load(getClass().getResource("/view/productTable.fxml"));
                    Scene home_page_scene = new Scene(home_page_parent);
                    Stage app_stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    app_stage.hide();
                    app_stage.setScene(home_page_scene);
                    app_stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                resultLabelS.setText("Login or password incorrect");
            }
        }
       catch (ProductShopException e){
           System.out.println();
       }



    }
}