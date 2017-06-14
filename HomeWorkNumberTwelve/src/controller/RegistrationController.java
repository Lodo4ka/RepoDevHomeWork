package controller;

import entity.User;
import exception.ProductShopException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.RegistrationService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by lodo4ka on 05/06/2017.
 */
public class RegistrationController {


    private Scene secondScene;


    private RegistrationService registrationService = new RegistrationService();


    @FXML
    private TextField txtUserName;
    @FXML
    private PasswordField txtPass;

    public void setSecondScene(Scene secondScene) {
        this.secondScene = secondScene;
    }



    @FXML
    public void register(ActionEvent actionEvent) throws IOException {

       try{
           String textField = txtUserName.getText();
           String passField = txtPass.getText();

           User user = new User(textField, passField);

           registrationService.register(user);

           Parent home_page_parent = FXMLLoader.load(getClass().getResource("/view/checkingLogin.fxml"));
           Scene home_page_scene = new Scene(home_page_parent);
           Stage app_stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
           app_stage.hide();
           app_stage.setScene(home_page_scene);
           app_stage.show();

       }
       catch (ProductShopException e){

       }
    }
}
