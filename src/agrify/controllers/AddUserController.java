package agrify.controllers;

import agrify.entities.User;
import agrify.services.ServiceUser;
import agrify.utils.DataSource;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author tbagh
 */

public class AddUserController {

   @FXML
    private Button AddUser0Btn;
   
       @FXML
    private Label AddUserMessage;

    @FXML
    private Button AddUserBackBtn1;

    @FXML
    private TextField UserEmailField;

    @FXML
    private TextField UserFNameField;

    @FXML
    private TextField UserLNameField;

    @FXML
    private TextField UserPasswordField;

    @FXML
    private TextField UserPhoneField;

    @FXML
    private ComboBox<String> UserRoleField;

    @FXML
    private ComboBox<String> UserSexField;

    @FXML
    private TextField UserUsernameField;
    
    
    
    
    
    public void initialize() {

  ObservableList<String> sexList = FXCollections.observableArrayList(
                "Homme", "Femme");
                UserSexField.setItems(sexList);
                UserSexField.setValue("Select --------"); 

    ObservableList<String> RoleList = FXCollections.observableArrayList(
                "User", "Admin");
                UserRoleField.setItems(RoleList);
                UserRoleField.setValue("Select --------"); 
}
    

    
    

  @FXML
void Add0User(ActionEvent event) throws IOException 

{
    System.out.println("Database instance connection");
    System.out.println(DataSource.getInstance().getConnection());
    ServiceUser userService = new ServiceUser(DataSource.getInstance().getConnection());
    
    String nom = UserFNameField.getText();
    String prenom = UserLNameField.getText();
    String email = UserEmailField.getText();
    String telephone = UserPhoneField.getText();
    String role = UserRoleField.getValue(); 
    String genre = UserSexField.getValue(); 
    int nbrAbsence = 0; 
    String username = UserUsernameField.getText();
    String password = UserPasswordField.getText();
    
    
    User user = new User(nom, prenom, email, telephone, role, genre, nbrAbsence, username, password);
    userService.ajouter(user);
    
        Parent signUpRoot = FXMLLoader.load(getClass().getResource("/agrify/views/UserHome.fxml"));
        Scene signUpScene = new Scene(signUpRoot);
   
        Stage signUpStage = new Stage();
        signUpStage.initStyle(StageStyle.TRANSPARENT);
        signUpStage.setScene(signUpScene);
        signUpStage.show();

        Stage splashSignInStage = (Stage) AddUser0Btn.getScene().getWindow();
    splashSignInStage.close();
}


    @FXML
    void AddUserBack(ActionEvent event) throws Exception
    {

        Parent signUpRoot = FXMLLoader.load(getClass().getResource("/agrify/views/UserHome.fxml"));
        Scene signUpScene = new Scene(signUpRoot);
   
        Stage signUpStage = new Stage();
        signUpStage.initStyle(StageStyle.TRANSPARENT);
        signUpStage.setScene(signUpScene);
        signUpStage.show();

        Stage splashSignInStage = (Stage) AddUserBackBtn1.getScene().getWindow();
        splashSignInStage.close();
    }

    
    @FXML
    void Role(ActionEvent event) 
      {
        String selectedRole = UserRoleField.getSelectionModel().getSelectedItem();
        System.out.println("Selected Role: " + selectedRole);
      }

    @FXML
    void Sex(ActionEvent event) 
      {
          
        String selectedSex = UserSexField.getSelectionModel().getSelectedItem();
        System.out.println("Selected Sex: " + selectedSex);
      
      }
    
}
