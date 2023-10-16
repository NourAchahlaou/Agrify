package agrify.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
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



public class SigninController {

    @FXML
    private Button HomeBackBtn;

    @FXML
    private Button SgininBtn0;

    @FXML
    private Hyperlink SgininSignUpHyperBtn;

    @FXML
    private TextField SgininUsername;

    @FXML
    private PasswordField Signinpsswd;

    
    
@FXML
 void HomeBack(ActionEvent event)throws Exception
         
    {
        Parent signUpRoot = FXMLLoader.load(getClass().getResource("/agrify/views/Home.fxml"));
        Scene signUpScene = new Scene(signUpRoot);

        Stage signUpStage = new Stage();
        signUpStage.initStyle(StageStyle.TRANSPARENT);
        signUpStage.setScene(signUpScene);
        signUpStage.show();

        Stage splashSignInStage = (Stage) HomeBackBtn.getScene().getWindow();
        splashSignInStage.close();
    }




@FXML
void Sginin0(ActionEvent event)  throws Exception

{

   Parent signUpRoot = FXMLLoader.load(getClass().getResource("/agrify/views/AdminDashboard.fxml"));
   Scene signUpScene = new Scene(signUpRoot);

   Stage signUpStage = new Stage();
   signUpStage.initStyle(StageStyle.TRANSPARENT);
   signUpStage.setScene(signUpScene);
   signUpStage.show();

   Stage splashSignInStage = (Stage) SgininBtn0.getScene().getWindow();
   splashSignInStage.close();

}




@FXML
 void SgininSignUpHyper(ActionEvent event) throws Exception
 
    {
        Parent signUpRoot = FXMLLoader.load(getClass().getResource("/agrify/views/register.fxml"));
        Scene signUpScene = new Scene(signUpRoot);

        Stage signUpStage = new Stage();
        signUpStage.initStyle(StageStyle.TRANSPARENT);
        signUpStage.setScene(signUpScene);
        signUpStage.show();

        Stage splashSignInStage = (Stage) SgininSignUpHyperBtn.getScene().getWindow();
        splashSignInStage.close();
 
    }

}
