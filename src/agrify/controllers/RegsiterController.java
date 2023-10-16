package agrify.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 *
 * @author tbagh
 */

public class RegsiterController {

    @FXML
    private Button RegisterBackBtn;

    @FXML
    private Button RegisterBtn0;

    @FXML
    private TextField RegisterEmaill;

    @FXML
    private TextField RegisterName;

    @FXML
    private TextField RegisterPassword;

    @FXML
    private ComboBox<?> RegisterRole;

    @FXML
    private Hyperlink RegisterUpHyperBtn;

    @FXML
    private TextField RegisterUsername;

    @FXML
    void Register0(ActionEvent event) {

    }

@FXML
 void RegisterBack(ActionEvent event)throws Exception
         
 {
   Parent signUpRoot = FXMLLoader.load(getClass().getResource("/agrify/views/Home.fxml"));
   Scene signUpScene = new Scene(signUpRoot);

   Stage signUpStage = new Stage();
   signUpStage.initStyle(StageStyle.TRANSPARENT);
   signUpStage.setScene(signUpScene);
   signUpStage.show();

   Stage splashSignInStage = (Stage) RegisterBackBtn.getScene().getWindow();
   splashSignInStage.close();
}
 
 

@FXML
void RegisterUpHyper(ActionEvent event) throws Exception

{
   Parent signUpRoot = FXMLLoader.load(getClass().getResource("/agrify/views/signin.fxml"));
   Scene signUpScene = new Scene(signUpRoot);
   
   Stage signUpStage = new Stage();
   signUpStage.initStyle(StageStyle.TRANSPARENT);
   signUpStage.setScene(signUpScene);
   signUpStage.show();

   Stage splashSignInStage = (Stage) RegisterUpHyperBtn.getScene().getWindow();
   splashSignInStage.close();

}

@FXML
void register0(ActionEvent event) 
    {

    }

}
