package agrify.controllers;

import agrify.entities.User;
import agrify.services.ServiceUser;
import agrify.utils.DataSource;
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
import javafx.scene.control.cell.PropertyValueFactory;
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

      
    
    
public void initialize() 
{
    userService = new ServiceUser(DataSource.getInstance().getConnection());
    initializeTableColumns();
    loadUserData();
}
    

private void loadUserData() 
    
{
        List<User> users = userService.getAll();
        BestUserView.getItems().setAll(users);
    }

private void initializeTableColumns() 
    
    {
        BestUserUser_id.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        BestUserUser_nbrabscence.setCellValueFactory(new PropertyValueFactory<>("user_nbrabscence"));
        BestUserUser_Nom.setCellValueFactory(new PropertyValueFactory<>("user_nom"));
        BestUserUser_prenom.setCellValueFactory(new PropertyValueFactory<>("user_prenom"));
    }
    
      
   @FXML
void BestUserSearch(ActionEvent event) {
    try {
        int year = Integer.parseInt(BestUserSearchYear.getText());
        User userBest = userService.getUserBest(year);

        if (userBest != null) {
            ObservableList<User> observableUser = FXCollections.observableArrayList(userBest);
            BestUserView.setItems(observableUser);
            EditUserMessage11.setText(""); // Clear the error message
        } else {
            BestUserView.getItems().clear();
            EditUserMessage11.setText("No user found for the specified year.");
        }
    } catch (NumberFormatException ex) {
        EditUserMessage11.setText("Invalid year input. Please enter a valid year.");
    } catch (SQLException ex) {
        EditUserMessage11.setText("An error occurred while searching for the best user.");
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
