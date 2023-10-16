package agrify.controllers;

import agrify.entities.Field;
import agrify.services.ServiceField;
import agrify.utils.DataSource;
import java.io.IOException;
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

public class FieldDeleteController {

    @FXML
    private Button DeleteBackFieldBtn1;

    @FXML
    private Button DeleteDeleteFieldBtn;

    @FXML
    private TextField DeleteFieldSearchFieldTextfile;

    @FXML
    private Button DeleteSearchFieldBtn;

    @FXML
    private Label EditUserMessage11;

 @FXML
    private TableView<Field> FieldHome; 
    @FXML
    private TableColumn<Field, Integer> FieldHome_id; 
    @FXML
    private TableColumn<Field, String> FieldHome_nom;
    @FXML
    private TableColumn<Field, Integer> FieldHome_quantité;
    @FXML
    private TableColumn<Field, Double> FieldHome_superficie;
    @FXML
    private TableColumn<Field, String> FieldHome_type;
    
    private boolean isSearching = false;


    
    
    
        private ServiceField serviceField; // Initialize the ServiceField
        private ObservableList<Field> fieldsList;

        
 @FXML
void initialize() {
    // Initialize your service and observable list
    serviceField = new ServiceField(DataSource.getInstance().getConnection());
    fieldsList = FXCollections.observableArrayList();

    // Associate the table columns with Field properties
    FieldHome_id.setCellValueFactory(new PropertyValueFactory<>("field_Id"));
    FieldHome_nom.setCellValueFactory(new PropertyValueFactory<>("field_Nom"));
    FieldHome_quantité.setCellValueFactory(new PropertyValueFactory<>("field_quantity"));
    FieldHome_superficie.setCellValueFactory(new PropertyValueFactory<>("field_Superficie"));
    FieldHome_type.setCellValueFactory(new PropertyValueFactory<>("field_type"));

    // Set the items in the table
    FieldHome.setItems(fieldsList);

    // Load the field data into the table
    loadFieldData();
}

private void loadFieldData() {
    List<Field> fields = serviceField.getAll(); // Modify this based on your ServiceField
    fieldsList.addAll(fields);
}
    
    
    
    
    
    
    
    
    
    
    
    @FXML
    void DeleteBackField(ActionEvent event) throws IOException{
      // Load the sign-Up interface
   Parent signUpRoot = FXMLLoader.load(getClass().getResource("/agrify/views/FiledHome.fxml"));
   Scene signUpScene = new Scene(signUpRoot);
   

   // Create a new stage for the sign-in interface
   Stage signUpStage = new Stage();
   signUpStage.initStyle(StageStyle.TRANSPARENT);
   signUpStage.setScene(signUpScene);
   signUpStage.show();

   // Close the splash screen stage
   Stage splashSignInStage = (Stage) DeleteBackFieldBtn1.getScene().getWindow();
   splashSignInStage.close();
    }

    
    
@FXML
void DeleteDeleteField(ActionEvent event) {
    if (isSearching) {
        if (fieldsList.isEmpty()) {
            EditUserMessage11.setText("No field selected for deletion.");
        } else {
            Field selectedField = FieldHome.getSelectionModel().getSelectedItem();
            if (selectedField != null) {
                serviceField.supprimerByName(selectedField.getField_Nom()); // Use the supprimerByName method
                EditUserMessage11.setText("Field deleted successfully.");
                fieldsList.remove(selectedField); // Remove the selected field from the list
            } else {
                EditUserMessage11.setText("Please select a field to delete.");
            }
        }
    } else {
        EditUserMessage11.setText("Search for fields first, please.");
    }
}







    @FXML
    void DeleteSearchField(ActionEvent event) throws SQLException {
        {
            String searchName = DeleteFieldSearchFieldTextfile.getText();
                if (!searchName.isEmpty())  
                  {
                    try 
                    {
                        fieldsList.clear();
                        fieldsList.addAll(serviceField.searchFieldsByName(searchName));
                        isSearching = true;
                    } 
                    catch (SQLException ex) 
                        {
                            EditUserMessage11.setText("An error occurred while searching for users.");
                            ex.printStackTrace();
                        }
                  } 
                else 
                  {
                    EditUserMessage11.setText("Please enter a name to search for.");
                  }
        }

}
}
