package agrify.controllers;

import agrify.entities.User;
import agrify.services.ServiceUser;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 *
 * @author tbagh
 */


public class UserBestController {
    
    

    @FXML
    private Button BestUserSearchBtn;

    @FXML
    private TableColumn<User, String> BestUserUser_Nom;

    @FXML
    private TableColumn<User, Integer> BestUserUser_id;

    @FXML
    private TableColumn<User, Integer> BestUserUser_nbrabscence;

    @FXML
    private TableColumn<User, String> BestUserUser_prenom;

    @FXML
    private TableView<User> BestUserView;

    @FXML
    private Label EditUserMessage11;

    @FXML
    private Label EditUserMessage111;

    @FXML
    private Button UserBestBackBtn;

    @FXML
    private TextField BestUserSearchYear;

    private ServiceUser userService;

      
    
      
  @FXML
void BestUserSearch(ActionEvent event)
{
    try 
      {
        int year = Integer.parseInt(BestUserSearchYear.getText());
        User userBest = userService.getUserBest(year);

            if (userBest != null)
              {
                ObservableList<User> observableUser = FXCollections.observableArrayList(userBest);
                BestUserView.setItems(observableUser);
              } 
            else 
              {
                System.out.println("No user found for the specified year.");
               }
      } 
    catch (NumberFormatException ex) 
      {
        System.out.println("Invalid year input. Please enter a valid year.");
      } 
    catch (SQLException ex) 
      {
        System.out.println("An error occurred while searching for the best user.");
        ex.printStackTrace();
      }
}


    @FXML
    void UserBestBack(ActionEvent event)throws Exception
    
    {
        Parent signUpRoot = FXMLLoader.load(getClass().getResource("/agrify/views/UserHome.fxml"));
        Scene signUpScene = new Scene(signUpRoot);
   
        Stage signUpStage = new Stage();
        signUpStage.initStyle(StageStyle.TRANSPARENT);
        signUpStage.setScene(signUpScene);
        signUpStage.show();

        Stage splashSignInStage = (Stage) UserBestBackBtn.getScene().getWindow();
        splashSignInStage.close();

    }
}
