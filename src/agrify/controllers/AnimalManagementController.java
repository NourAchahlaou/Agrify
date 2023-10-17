/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agrify.controllers;

import agrify.entities.Animal;
import agrify.entities.AnimauxEnGestationEntity;
import agrify.entities.BesoinNutritionnelsEntity;
import agrify.entities.IngrediantEntity;
import agrify.entities.ValeurNutritionnelEntity;
import agrify.services.ServiceAnimal;
import agrify.services.ServiceAnimauxEnGestation;
import agrify.services.ServiceBesoinNutritionnel;
import agrify.services.ServiceIngredient;
import agrify.services.ServiceValeurNutritionnel;
import agrify.utils.Database;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author alien kami sama
 */
public class AnimalManagementController implements Initializable {

    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    @FXML
    private TextField popup_nombre_animal_management1;
    @FXML
    private TextField adf_popup_besoin_nutritionnel;

    @FXML
    private TextField adf_popup_ingredient_management;

    @FXML
    private AnchorPane anchor_ajouter_ingrediant111;

    @FXML
    private AnchorPane anchor_animaux_management;

    @FXML
    private AnchorPane anchor_besoin_nutritionnel;

    @FXML
    private AnchorPane anchor_ration_management;

    @FXML
    private AnchorPane anchor_ration_selection_ingredient;

    @FXML
    private AnchorPane anchor_valeur_nutritionnelles02;

    @FXML
    private AnchorPane anchor_valeur_nutritionnelles1;

    @FXML
    private AnchorPane anchor_valeur_nutritionnelles2;

    @FXML
    private AnchorPane anchor_btn_enregistrer_besoin_nutritionnel;

    @FXML
    private AnchorPane anchor_btn_modify_delete_besoin_nutritionnel;

    @FXML
    private TableView<AnimauxEnGestationEntity> animauxEnGestationTable;

    @FXML
    private BarChart<?, ?> bar_chart_produit;

    @FXML
    private Button btn_modify_popup_besoin_nutritionnel;

    @FXML
    private Button btn_delete_popup_besoin_nutritionnel;

    @FXML
    private Button btn_ajouter_animal;

    @FXML
    private Button btn_ajouter_besoin1;

    @FXML
    private Button btn_animaux;

    @FXML
    private Button btn_besoin_nutritionnel;

    @FXML
    private Button btn_betais_filter;

    @FXML
    private Button btn_betais_filter_animal_management;

    @FXML
    private Button btn_betais_filter_ration;

    @FXML
    private Button btn_cree_besoin;

    @FXML
    private Button btn_cree_ration;

    @FXML
    private Button btn_enregistrer;

    @FXML
    private Button btn_enregistrer_popup1_ration;

    @FXML
    private Button btn_enregistrer_popup2_besoin_nutritionnel;

    @FXML
    private Button btn_enregistrer_popup2_ingrediant_management;

    @FXML
    private Button btn_enregistrer_popup_animal_management;

    @FXML
    private Button btn_enregistrer_popup_besoin_nutritionnel;

    @FXML
    private Button btn_enregistrer_popup2_ration;

    @FXML
    private Button btn_exit;

    @FXML
    private Button btn_exit1;

    @FXML
    private Button btn_exit2;

    @FXML
    private Button btn_exit3;

    @FXML
    private Button btn_exit4;

    @FXML
    private Button btn_exit5;

    @FXML
    private Button btn_exit6;

    @FXML
    private Button btn_ingredient;

    @FXML
    private Button btn_ingredient_indiv;

    @FXML
    private Button btn_nourriture_animale;

    @FXML
    private Button btn_ovins_filter;

    @FXML
    private Button btn_ovins_filter_animal_management;

    @FXML
    private Button btn_ovins_filter_ration;

    @FXML
    private Button btn_rations;

    @FXML
    private Button btn_reclamation;

    @FXML
    private Button btn_reinitialisation_filtre;

    @FXML
    private Button btn_reinitialisation_filtre1;

    @FXML
    private Button btn_reinitialisation_filtre2;

    @FXML
    private Button btn_reinitialisation_filtre3;

    @FXML
    private Button btn_tableau_bord;

    @FXML
    private Button btn_tache;

    @FXML
    private Button btn_tous_filter;

    @FXML
    private Button btn_tous_filter_animal_management;

    @FXML
    private Button btn_tous_filter_ration;

    @FXML
    private Button btn_tous_ingredient;

    @FXML
    private TextField budget_popup_ration;

    @FXML
    private TextField ca_popup_besoin_nutritionnel;

    @FXML
    private TextField ca_popup_ingredient_management;

    @FXML
    private CheckBox chekbox_energie_popup_ingredient_management;

    @FXML
    private CheckBox chekbox_fibre_popup_ingredient_management;

    @FXML
    private CheckBox chekbox_mineral_popup_ingredient_management;

    @FXML
    private CheckBox chekbox_protien_popup_ingredient_management;

    @FXML
    private TableColumn<IngrediantEntity, String> colone_nom_ingredient_management;

    @FXML
    private TableColumn<Animal, String> colonee_ration_nom_ingredient;

    @FXML
    private TableColumn<Animal, String> colonne_age_animal_management;

    @FXML
    private TableColumn<BesoinNutritionnelsEntity, String> colonne_bute_production_besoin_nutritionnel;

    @FXML
    private TableColumn<IngrediantEntity, String> colonne_cout100_ingredient_management;

    @FXML
    private TableColumn<Animal, String> colonne_espece_animal_management;

    @FXML
    private TableColumn<BesoinNutritionnelsEntity, String> colonne_espece_besoin_nutritionnel;

    @FXML
    private TableColumn<Animal, String> colonne_nombre_animal_animal_management;

    @FXML
    private TableColumn<BesoinNutritionnelsEntity, String> colonne_nom_produit_besoin_nutritionnel;

    @FXML
    private TableColumn<Animal, String> colonne_poid_min_animal_management;

    @FXML
    private TableColumn<Animal, String> colonne_poids_max_animal_management;

    @FXML
    private TableColumn<BesoinNutritionnelsEntity, String> colonne_poids_max_besoin_nutritionnel;

    @FXML
    private TableColumn<BesoinNutritionnelsEntity, String> colonne_poidsmin_besoin_nutritionnel;

    @FXML
    private TableColumn<IngrediantEntity, String> colonne_principal_nutriment_ingredient_management;

    @FXML
    private TableColumn<?, ?> colonne_ration_adf;

    @FXML
    private TableColumn<?, ?> colonne_ration_bute_production;

    @FXML
    private TableColumn<?, ?> colonne_ration_ca;

    @FXML
    private TableColumn<?, ?> colonne_ration_eb;

    @FXML
    private TableColumn<?, ?> colonne_ration_fb;

    @FXML
    private TableColumn<?, ?> colonne_ration_ndf;

    @FXML
    private TableColumn<?, ?> colonne_ration_p;

    @FXML
    private TableColumn<?, ?> colonne_ration_pb;

    @FXML
    private TableColumn<?, ?> colonne_ration_prix100;

    @FXML
    private TableColumn<Animal, String> colonne_sexe_animal_management;

    @FXML
    private TableColumn<IngrediantEntity, String> colonne_source_ingredinet_management;

    @FXML
    private TableColumn<BesoinNutritionnelsEntity, String> colonne_status_besoin_nutritionnel;

    @FXML
    private TableColumn<?, ?> coloone_ration_espece;

    @FXML
    private ComboBox<String> combobox_bute_production_popup2_ration;

    @FXML
    private ComboBox<String> combobox_popup_espece_ration;

    @FXML
    private ComboBox<String> combobox_udm_popup_ingredient_management;

    @FXML
    private ComboBox<String> cree_ingredient_combobox;

    @FXML
    private TableColumn<AnimauxEnGestationEntity, Date> dashboard_elvage_imminent;

    @FXML
    private TableColumn<AnimauxEnGestationEntity, Date> dashboard_espece_animal_gestation;

    @FXML
    private TableColumn<AnimauxEnGestationEntity, String> dashboard_dateAdv_animal_gestation;

    @FXML
    private TableColumn<AnimauxEnGestationEntity, Date> dashboard_prep_elevage;

    @FXML
    private TextArea description_popup_ingredient_management;

    @FXML
    private TextField eb_popup_besoin_nutritionnel;

    @FXML
    private TextField eb_popup_ingredient_management;

    @FXML
    private ComboBox<String> espece_combobox;

    @FXML
    private ComboBox<String> espece_combobox_animal_management;

    @FXML
    private ComboBox<String> espece_combobox_ration;

    @FXML
    private TextField fb_popup_besoin_nutritionnel;

    @FXML
    private TextField fb_popup_ingredient_management;

    @FXML
    private TextField k_popup_besoin_nutritionnel;

    @FXML
    private TextField k_popup_ingredient_management;

    @FXML
    private Label label_betails_en_gestation;

    @FXML
    private Label label_nom_chef;

    @FXML
    private Label label_ovins_en_gestation;

    @FXML
    private Label label_poid_max_controller_animal_management;

    @FXML
    private Label label_poid_max_ration_controller;

    @FXML
    private Label label_poid_min_controller_animal_management;

    @FXML
    private Label label_poid_min_ration_controller;

    @FXML
    private Label label_rendement_mensuel_de_laine;

    @FXML
    private Label label_rendement_quotidien_en_miel;

    @FXML
    private Label label_rendement_quotidien_en_œufs;

    @FXML
    private Label label_title;

    @FXML
    private LineChart<?, ?> line_chart_nouveau_nes;

    @FXML
    private TextField mg_popup_besoin_nutritionnel;

    @FXML
    private TextField mg_popup_ingredient_management;

    @FXML
    private TextField ms_popup_besoin_nutritionnel;

    @FXML
    private TextField ms_popup_ingredient_management;

    @FXML
    private TextField ndf_popup_besoin_nutritionnel;

    @FXML
    private TextField ndf_popup_ingredient_management;

    @FXML
    private TextField nom_ingredient_popup_ingredient_management;

    @FXML
    private ComboBox<String> nutriment_principal_combobox;

    @FXML
    private ComboBox<String> nutriment_principal_combobox1;

    @FXML
    private ComboBox<String> nutriment_principal_combobox_ration;

    @FXML
    private TextField p_popup_besoin_nutritionnel;

    @FXML
    private TextField p_popup_ingredient_management;

    @FXML
    private AnchorPane page_animaux_management;

    @FXML
    private AnchorPane page_besoin_nutritionnels_management;

    @FXML
    private AnchorPane page_ingredient_main;

    @FXML
    private AnchorPane page_ration_managemnt;

    @FXML
    private AnchorPane page_tableau_bord;

    @FXML
    private TextField pb_popup_besoin_nutritionnel;

    @FXML
    private TextField pb_popup_ingredient_management;

    @FXML
    private ComboBox<String> plage_prix_combobox;

    @FXML
    private ComboBox<String> plage_quantite_combobox;

    @FXML
    private Slider popup2_poid_max_slider_ration;

    @FXML
    private Slider popup2_poid_min_slider_ration;

    @FXML
    private TextField popup_age_animal_management;

    @FXML
    private AnchorPane popup_animal_management;

    @FXML
    private AnchorPane popup_besoin_nutritionnels_management;

    @FXML
    private ComboBox<String> popup_combobox_espece_animal_amanagement;

    @FXML
    private ComboBox<String> popup_combox_bute_producion;

    @FXML
    private ComboBox<String> popup_espece_besoin_nutritionnel;

    @FXML
    private AnchorPane popup_ingredient_managment;

    @FXML
    private Label popup_poid_max_controller_besoin_nutritionnel;

    @FXML
    private Label popup_poid_min_controller_besoin_nutritionnel;

    @FXML
    private Slider popup_poids_max_slider_besoin_nutritionnel;

    @FXML
    private AnchorPane popup_ration_management;

    @FXML
    private TextField popup_sexe_animal_management;

    @FXML
    private TextField popup_sexe_besoin_nutritionnel;

    @FXML
    private Slider popup_slider_poids_min_besoin_nutritionnel;

    @FXML
    private ComboBox<String> popup_status_production_besoin_nutritionnel;

    @FXML
    private TextField prix_popup_ingredient_management;

    @FXML
    private TextField quantite_popup_ingredient_management;

    @FXML
    private TextField rechercher_input;

    @FXML
    private TextField rechercher_input1;

    @FXML
    private TextField rechercher_input2;

    @FXML
    private TextField rechercher_input3;

    @FXML
    private TextField sexe_popup2_ration;

    @FXML
    private Slider slide_poids_max_animal_management;

    @FXML
    private Slider slide_poids_min_animal_management;

    @FXML
    private TextArea source_popup_ingredient_management;

    @FXML
    private ComboBox<String> status_combobox;

    @FXML
    private ComboBox<String> status_combobox_animal_management;

    @FXML
    private ComboBox<String> status_combobox_ration;

    @FXML
    private TableView<Animal> table_anaimal_management;

    @FXML
    private TableView<BesoinNutritionnelsEntity> table_besoin_nutritionnel;

    @FXML
    private TableView<IngrediantEntity> table_igredient_management;

    @FXML
    private TableView<?> table_ration;

    @FXML
    private ComboBox<String> type_ingredient_popup_ingredient_management;
    //DataBase tools
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Statement statement;

    public void changeWithCombobox() {
        cree_ingredient_combobox.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if ("ingredient individual".equals(newValue)) {
                popup_ingredient_managment.setVisible(true);
                //
                anchor_valeur_nutritionnelles1.setVisible(true);
                anchor_valeur_nutritionnelles2.setVisible(false);

            } else {
                popup_ingredient_managment.setVisible(false);
            }
        });
    }

    //exit is done 
    public void exit(ActionEvent event) {
        if (event.getSource() == btn_exit) {
            popup_ingredient_managment.setVisible(false);
        } else if (event.getSource() == btn_exit1) {
            popup_ingredient_managment.setVisible(false);
        } else if (event.getSource() == btn_exit2) {
            popup_besoin_nutritionnels_management.setVisible(false);
        } else if (event.getSource() == btn_exit3) {
            popup_besoin_nutritionnels_management.setVisible(false);
        } else if (event.getSource() == btn_exit4) {
            popup_ration_management.setVisible(false);
        } else if (event.getSource() == btn_exit5) {
            popup_ration_management.setVisible(false);
        } else if (event.getSource() == btn_exit6) {
            popup_animal_management.setVisible(false);
        }
    }
    //

    // changerContinu est done
    public void changerContinu(ActionEvent event) {
        // pour accider lel gestion tableau de bord
        if (event.getSource() == btn_tableau_bord) {
            page_tableau_bord.setVisible(true);
            page_ingredient_main.setVisible(false);
            popup_ingredient_managment.setVisible(false);
            //
            anchor_valeur_nutritionnelles1.setVisible(false);
            anchor_valeur_nutritionnelles2.setVisible(false);
            //
            page_besoin_nutritionnels_management.setVisible(false);
            //
            popup_besoin_nutritionnels_management.setVisible(false);
            //
            anchor_besoin_nutritionnel.setVisible(false);
            anchor_valeur_nutritionnelles02.setVisible(false);
            //
            page_ration_managemnt.setVisible(false);
            //
            popup_ration_management.setVisible(false);
            //
            anchor_ration_selection_ingredient.setVisible(false);
            anchor_ration_management.setVisible(false);
            //
            page_animaux_management.setVisible(false);
            //
            popup_animal_management.setVisible(false);
            //
            anchor_animaux_management.setVisible(false);
            // pour accider lel gestion ingredient
        } else if (event.getSource() == btn_ingredient) {
            page_tableau_bord.setVisible(false);
            page_ingredient_main.setVisible(true);
            popup_ingredient_managment.setVisible(false);
            //
            anchor_valeur_nutritionnelles1.setVisible(false);
            anchor_valeur_nutritionnelles2.setVisible(false);
            //
            page_besoin_nutritionnels_management.setVisible(false);
            //
            popup_besoin_nutritionnels_management.setVisible(false);
            //
            anchor_besoin_nutritionnel.setVisible(false);
            anchor_valeur_nutritionnelles02.setVisible(false);
            //
            page_ration_managemnt.setVisible(false);
            //
            popup_ration_management.setVisible(false);
            //
            anchor_ration_selection_ingredient.setVisible(false);
            anchor_ration_management.setVisible(false);
            //
            page_animaux_management.setVisible(false);
            //
            popup_animal_management.setVisible(false);
            //
            anchor_animaux_management.setVisible(false);

            // pour accider lel gestion lel valeur % de neutrition 
        } else if (event.getSource() == btn_enregistrer_popup2_ingrediant_management) {
            page_tableau_bord.setVisible(false);
            page_ingredient_main.setVisible(true);
            popup_ingredient_managment.setVisible(true);
            //
            anchor_valeur_nutritionnelles1.setVisible(false);
            anchor_valeur_nutritionnelles2.setVisible(true);
            //
            page_besoin_nutritionnels_management.setVisible(false);
            //
            popup_besoin_nutritionnels_management.setVisible(false);
            //
            anchor_besoin_nutritionnel.setVisible(false);
            anchor_valeur_nutritionnelles02.setVisible(false);
            //
            page_ration_managemnt.setVisible(false);
            //
            popup_ration_management.setVisible(false);
            //
            anchor_ration_selection_ingredient.setVisible(false);
            anchor_ration_management.setVisible(false);
            //
            page_animaux_management.setVisible(false);
            //
            popup_animal_management.setVisible(false);
            //
            anchor_animaux_management.setVisible(false);
            // pour accider lel gestion lel gestion bsoin nutritionnel     
        } else if (event.getSource() == btn_besoin_nutritionnel) {
            page_tableau_bord.setVisible(false);
            page_ingredient_main.setVisible(false);
            popup_ingredient_managment.setVisible(false);
            //
            anchor_valeur_nutritionnelles1.setVisible(false);
            anchor_valeur_nutritionnelles2.setVisible(false);
            //
            page_besoin_nutritionnels_management.setVisible(true);
            //
            popup_besoin_nutritionnels_management.setVisible(false);
            //
            anchor_besoin_nutritionnel.setVisible(false);
            anchor_valeur_nutritionnelles02.setVisible(false);
            //
            page_ration_managemnt.setVisible(false);
            //
            popup_ration_management.setVisible(false);
            //
            anchor_ration_selection_ingredient.setVisible(false);
            anchor_ration_management.setVisible(false);
            //
            page_animaux_management.setVisible(false);
            //
            popup_animal_management.setVisible(false);
            //
            anchor_animaux_management.setVisible(false);
            // pour accider lel gestion lel creation bsoin nutritionnel  
        } else if (event.getSource() == btn_cree_besoin) {
            page_tableau_bord.setVisible(false);
            page_ingredient_main.setVisible(false);
            popup_ingredient_managment.setVisible(false);
            //
            anchor_valeur_nutritionnelles1.setVisible(false);
            anchor_valeur_nutritionnelles2.setVisible(false);
            //
            page_besoin_nutritionnels_management.setVisible(true);
            //
            popup_besoin_nutritionnels_management.setVisible(true);
            //
            anchor_besoin_nutritionnel.setVisible(true);
            anchor_valeur_nutritionnelles02.setVisible(false);
            //
            page_ration_managemnt.setVisible(false);
            //
            popup_ration_management.setVisible(false);
            //
            anchor_ration_selection_ingredient.setVisible(false);
            anchor_ration_management.setVisible(false);
            //
            page_animaux_management.setVisible(false);
            //
            popup_animal_management.setVisible(false);
            //
            anchor_animaux_management.setVisible(false);
        } else if (event.getSource() == btn_enregistrer_popup_besoin_nutritionnel) {
            page_tableau_bord.setVisible(false);
            page_ingredient_main.setVisible(false);
            popup_ingredient_managment.setVisible(false);
            //
            anchor_valeur_nutritionnelles1.setVisible(false);
            anchor_valeur_nutritionnelles2.setVisible(false);
            //
            page_besoin_nutritionnels_management.setVisible(true);
            //
            popup_besoin_nutritionnels_management.setVisible(true);
            //
            anchor_besoin_nutritionnel.setVisible(false);
            anchor_valeur_nutritionnelles02.setVisible(true);
            //
            page_ration_managemnt.setVisible(false);
            //
            popup_ration_management.setVisible(false);
            //
            anchor_ration_selection_ingredient.setVisible(false);
            anchor_ration_management.setVisible(false);
            //
            page_animaux_management.setVisible(false);
            //
            popup_animal_management.setVisible(false);
            //
            anchor_animaux_management.setVisible(false);
            //pour acceder lel valeur de nutrition de la partie gestion de besoin nutritionnel 
        } else if (event.getSource() == btn_enregistrer_popup2_besoin_nutritionnel) {
            page_tableau_bord.setVisible(false);
            page_ingredient_main.setVisible(false);
            popup_ingredient_managment.setVisible(false);
            //
            anchor_valeur_nutritionnelles1.setVisible(false);
            anchor_valeur_nutritionnelles2.setVisible(false);
            //
            page_besoin_nutritionnels_management.setVisible(true);
            //
            popup_besoin_nutritionnels_management.setVisible(true);
            //
            anchor_besoin_nutritionnel.setVisible(false);
            anchor_valeur_nutritionnelles02.setVisible(true);
            //
            page_ration_managemnt.setVisible(false);
            //
            popup_ration_management.setVisible(false);
            //
            anchor_ration_selection_ingredient.setVisible(false);
            anchor_ration_management.setVisible(false);
            //
            page_animaux_management.setVisible(false);
            //
            popup_animal_management.setVisible(false);
            //
            anchor_animaux_management.setVisible(false);
        } else if (event.getSource() == btn_rations) {
            page_tableau_bord.setVisible(false);
            page_ingredient_main.setVisible(false);
            popup_ingredient_managment.setVisible(false);
            //
            anchor_valeur_nutritionnelles1.setVisible(false);
            anchor_valeur_nutritionnelles2.setVisible(false);
            //
            page_besoin_nutritionnels_management.setVisible(false);
            //
            popup_besoin_nutritionnels_management.setVisible(false);
            //
            anchor_besoin_nutritionnel.setVisible(false);
            anchor_valeur_nutritionnelles02.setVisible(false);
            //
            page_ration_managemnt.setVisible(true);
            //
            popup_ration_management.setVisible(false);
            //
            anchor_ration_selection_ingredient.setVisible(false);
            anchor_ration_management.setVisible(false);
            //
            page_animaux_management.setVisible(false);
            //
            popup_animal_management.setVisible(false);
            //
            anchor_animaux_management.setVisible(false);
        } else if (event.getSource() == btn_cree_ration) {
            page_tableau_bord.setVisible(false);
            page_ingredient_main.setVisible(false);
            popup_ingredient_managment.setVisible(false);
            //
            anchor_valeur_nutritionnelles1.setVisible(false);
            anchor_valeur_nutritionnelles2.setVisible(false);
            //
            page_besoin_nutritionnels_management.setVisible(false);
            //
            popup_besoin_nutritionnels_management.setVisible(false);
            //
            anchor_besoin_nutritionnel.setVisible(false);
            anchor_valeur_nutritionnelles02.setVisible(false);
            //
            page_ration_managemnt.setVisible(true);
            //
            popup_ration_management.setVisible(true);
            //
            anchor_ration_selection_ingredient.setVisible(false);
            anchor_ration_management.setVisible(true);
            //
            page_animaux_management.setVisible(false);
            //
            popup_animal_management.setVisible(false);
            //
            anchor_animaux_management.setVisible(false);
        } else if (event.getSource() == btn_enregistrer_popup1_ration) {
            page_tableau_bord.setVisible(false);
            page_ingredient_main.setVisible(false);
            popup_ingredient_managment.setVisible(false);
            //
            anchor_valeur_nutritionnelles1.setVisible(false);
            anchor_valeur_nutritionnelles2.setVisible(false);
            //
            page_besoin_nutritionnels_management.setVisible(false);
            //
            popup_besoin_nutritionnels_management.setVisible(false);
            //
            anchor_besoin_nutritionnel.setVisible(false);
            anchor_valeur_nutritionnelles02.setVisible(false);
            //
            page_ration_managemnt.setVisible(true);
            //
            popup_ration_management.setVisible(true);
            //
            anchor_ration_selection_ingredient.setVisible(true);
            anchor_ration_management.setVisible(false);
            //
            page_animaux_management.setVisible(false);
            //
            popup_animal_management.setVisible(false);
            //
            anchor_animaux_management.setVisible(false);
        } else if (event.getSource() == btn_animaux) {
            page_tableau_bord.setVisible(false);
            page_ingredient_main.setVisible(false);
            popup_ingredient_managment.setVisible(false);
            //
            anchor_valeur_nutritionnelles1.setVisible(false);
            anchor_valeur_nutritionnelles2.setVisible(false);
            //
            page_besoin_nutritionnels_management.setVisible(false);
            //
            popup_besoin_nutritionnels_management.setVisible(false);
            //
            anchor_besoin_nutritionnel.setVisible(false);
            anchor_valeur_nutritionnelles02.setVisible(false);
            //
            page_ration_managemnt.setVisible(false);
            //
            popup_ration_management.setVisible(false);
            //
            anchor_ration_selection_ingredient.setVisible(false);
            anchor_ration_management.setVisible(false);
            //
            page_animaux_management.setVisible(true);
            //
            popup_animal_management.setVisible(false);
            //
            anchor_animaux_management.setVisible(false);
        } else if (event.getSource() == btn_ajouter_animal) {
            page_tableau_bord.setVisible(false);
            page_ingredient_main.setVisible(false);
            popup_ingredient_managment.setVisible(false);
            //
            anchor_valeur_nutritionnelles1.setVisible(false);
            anchor_valeur_nutritionnelles2.setVisible(false);
            //
            page_besoin_nutritionnels_management.setVisible(false);
            //
            popup_besoin_nutritionnels_management.setVisible(false);
            //
            anchor_besoin_nutritionnel.setVisible(false);
            anchor_valeur_nutritionnelles02.setVisible(false);
            //
            page_ration_managemnt.setVisible(false);
            //
            popup_ration_management.setVisible(false);
            //
            anchor_ration_selection_ingredient.setVisible(false);
            anchor_ration_management.setVisible(false);
            //
            page_animaux_management.setVisible(true);
            //
            popup_animal_management.setVisible(true);
            //
            anchor_animaux_management.setVisible(true);
        }
    }

    //
    public void DisplayUserID() {
        try {
            Database db = Database.getInstance(); // Get the Database instance.
            connect = db.getConnection(); // Ensure 'connect' is properly initialized.

            if (connect != null) {
                String sql = "SELECT * FROM `userinfo` WHERE `userID` = 2";
                prepare = connect.prepareStatement(sql); // Initialize the prepared statement.
                result = prepare.executeQuery(); // Initialize the result set.

                if (result.next()) {
                    label_nom_chef.setText(result.getString("userName"));
                }
            } else {
                System.out.println("Database connection is null.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        page_tableau_bord.setVisible(true);
        cree_ingredient_combobox.setItems(FXCollections.observableArrayList("Créer un nouvel ingrédient", "ingredient individual", "nuriture animal"));
        nutriment_principal_combobox.setItems(FXCollections.observableArrayList("Fibre", "Énergie", "Protéine", "Minéral"));
        combobox_bute_production_popup2_ration.setItems(FXCollections.observableArrayList("Viande", "Lait", "Œufs"));
        combobox_popup_espece_ration.setItems(FXCollections.observableArrayList("Moutons", "Bovins", "Poules", "Dindes", "abeilles"));
        combobox_udm_popup_ingredient_management.setItems(FXCollections.observableArrayList("Metric Ton", "kilogram"));
        espece_combobox.setItems(FXCollections.observableArrayList("Moutons", "Bovins", "Poules", "Dindes", "abeilles"));
        espece_combobox_animal_management.setItems(FXCollections.observableArrayList("Moutons", "Bovins", "Poules", "Dindes", "abeilles"));
        espece_combobox_ration.setItems(FXCollections.observableArrayList("Moutons", "Bovins", "Poules", "Dindes", "abeilles"));
        nutriment_principal_combobox.setItems(FXCollections.observableArrayList("Fibre", "Énergie", "Protéine", "Minéral"));
        nutriment_principal_combobox1.setItems(FXCollections.observableArrayList("Fibre", "Énergie", "Protéine", "Minéral"));
        nutriment_principal_combobox_ration.setItems(FXCollections.observableArrayList("Fibre", "Énergie", "Protéine", "Minéral"));
        plage_prix_combobox.setItems(FXCollections.observableArrayList("<1000", "1000-5000", "5000-10000", "10000<"));
        plage_quantite_combobox.setItems(FXCollections.observableArrayList("<1000", "1000-5000", "5000-10000", "10000<"));
        popup_combobox_espece_animal_amanagement.setItems(FXCollections.observableArrayList("Moutons", "Bovins", "Poules", "Dindes", "abeilles"));
        popup_combox_bute_producion.setItems(FXCollections.observableArrayList("Viande", "Lait", "Œufs"));
        popup_espece_besoin_nutritionnel.setItems(FXCollections.observableArrayList("Moutons", "Bovins", "Poules", "Dindes", "abeilles"));
        popup_status_production_besoin_nutritionnel.setItems(FXCollections.observableArrayList("En Gestation", "En Lactation", "En Croissance"));
        status_combobox.setItems(FXCollections.observableArrayList("En Gestation", "En Lactation", "En Croissance"));
        status_combobox_animal_management.setItems(FXCollections.observableArrayList("En Gestation", "En Lactation", "En Croissance"));
        status_combobox_ration.setItems(FXCollections.observableArrayList("En Gestation", "En Lactation", "En Croissance"));
        type_ingredient_popup_ingredient_management.setItems(FXCollections.observableArrayList("ingredient individuel", "sacs de nourriture"));
        DisplayUserID();
        popup_poids_max_slider_besoin_nutritionnel.valueProperty().addListener((observable, oldValue, newValue) -> {
            // Update the label as the slider value changes
            popup_poid_max_controller_besoin_nutritionnel.setText(String.valueOf(newValue.intValue()));
        });

        popup_slider_poids_min_besoin_nutritionnel.valueProperty().addListener((observable, oldValue, newValue) -> {
            // Update the label as the slider value changes
            popup_poid_min_controller_besoin_nutritionnel.setText(String.valueOf(newValue.intValue()));
        });
        //
        popup2_poid_min_slider_ration.valueProperty().addListener((observable, oldValue, newValue) -> {
            // Update the label as the slider value changes
            label_poid_min_ration_controller.setText(String.valueOf(newValue.intValue()));
        });

        popup2_poid_max_slider_ration.valueProperty().addListener((observable, oldValue, newValue) -> {
            // Update the label as the slider value changes
            label_poid_max_ration_controller.setText(String.valueOf(newValue.intValue()));
        });
        //
        slide_poids_min_animal_management.valueProperty().addListener((observable, oldValue, newValue) -> {
            // Update the label as the slider value changes
            label_poid_min_controller_animal_management.setText(String.valueOf(newValue.intValue()));
        });

        slide_poids_max_animal_management.valueProperty().addListener((observable, oldValue, newValue) -> {
            // Update the label as the slider value changes
            label_poid_max_controller_animal_management.setText(String.valueOf(newValue.intValue()));
        });
        //table views (ingredient)
        colone_nom_ingredient_management.setCellValueFactory(new PropertyValueFactory<>("nameIngredient"));
        colonne_source_ingredinet_management.setCellValueFactory(new PropertyValueFactory<>("loadedByIngredient"));
        colonne_cout100_ingredient_management.setCellValueFactory(new PropertyValueFactory<>("costIngredient"));
        colonne_principal_nutriment_ingredient_management.setCellValueFactory(new PropertyValueFactory<>("nutrimentPrincipalIngredient"));

        List<IngrediantEntity> ingrediants = loadIngrediantsFromDatabase();

        // Ajoutez les données à la table
        table_igredient_management.setItems(FXCollections.observableArrayList(ingrediants));
        //table Views (besoins nutritionnel)    
        colonne_nom_produit_besoin_nutritionnel.setCellValueFactory(new PropertyValueFactory<>("sexeBesoinNutritionnel"));
        colonne_espece_besoin_nutritionnel.setCellValueFactory(new PropertyValueFactory<>("especeBesoinNutritionnel"));
        colonne_status_besoin_nutritionnel.setCellValueFactory(new PropertyValueFactory<>("statutProductionBesoinNutritionnel"));
        colonne_bute_production_besoin_nutritionnel.setCellValueFactory(new PropertyValueFactory<>("buteProductionBesoinNutritionnel"));
        colonne_poids_max_besoin_nutritionnel.setCellValueFactory(new PropertyValueFactory<>("poidsMaxBesoinNutritionnel"));
        colonne_poidsmin_besoin_nutritionnel.setCellValueFactory(new PropertyValueFactory<>("poidsMinBesoinNutritionnel"));
        List<BesoinNutritionnelsEntity> Besoins = loadBesoinFromDatabase();
        table_besoin_nutritionnel.setItems(FXCollections.observableArrayList(Besoins));

        table_besoin_nutritionnel.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        // Retrieve the selected BesoinNutritionnelsEntity
                        BesoinNutritionnelsEntity selectedBesoinNutritionnel = newValue;

                        // Call the displaySelectedBesoinNutritionnel method to populate input fields
                        displaySelectedBesoinNutritionnel(selectedBesoinNutritionnel);
                    }
                }
        );
        //
        ObservableList<AnimauxEnGestationEntity> animauxEnGestationList = loadDataFromDatabase();

        // Display the data in the table
        animauxEnGestationTable.setItems(animauxEnGestationList);

        // Associate table columns with entity properties using PropertyValueFactory
        dashboard_elvage_imminent.setCellValueFactory(new PropertyValueFactory<>("vêlagePrévu"));
        dashboard_espece_animal_gestation.setCellValueFactory(new PropertyValueFactory<>("espece"));
        dashboard_dateAdv_animal_gestation.setCellValueFactory(new PropertyValueFactory<>("dateAvertissement"));
        dashboard_prep_elevage.setCellValueFactory(new PropertyValueFactory<>("preparationVêlage"));
        //
        ObservableList<Animal> animalList = loadAnimalFromDatabase();
        colonne_nombre_animal_animal_management.setCellValueFactory(new PropertyValueFactory<>("nombreAnimal"));
        colonne_espece_animal_management.setCellValueFactory(new PropertyValueFactory<>("especeAnimal"));
        colonne_poid_min_animal_management.setCellValueFactory(new PropertyValueFactory<>("poidsminRation"));
        colonne_poids_max_animal_management.setCellValueFactory(new PropertyValueFactory<>("poidsmaxRation"));
        colonne_age_animal_management.setCellValueFactory(new PropertyValueFactory<>("ageAnimal"));
        colonne_sexe_animal_management.setCellValueFactory(new PropertyValueFactory<>("sexeRation"));
        table_anaimal_management.setItems(animalList);

    }

    //display selected raw
    private void displaySelectedBesoinNutritionnel(BesoinNutritionnelsEntity selectedBesoinNutritionnel) {
        page_tableau_bord.setVisible(false);
        page_ingredient_main.setVisible(false);
        popup_ingredient_managment.setVisible(false);
        //
        anchor_valeur_nutritionnelles1.setVisible(false);
        anchor_valeur_nutritionnelles2.setVisible(false);
        //
        page_besoin_nutritionnels_management.setVisible(true);
        //
        popup_besoin_nutritionnels_management.setVisible(true);
        //
        anchor_besoin_nutritionnel.setVisible(true);
        anchor_valeur_nutritionnelles02.setVisible(false);
        anchor_btn_enregistrer_besoin_nutritionnel.setVisible(false);
        anchor_btn_modify_delete_besoin_nutritionnel.setVisible(true);
        //
        page_ration_managemnt.setVisible(false);
        //
        popup_ration_management.setVisible(false);
        //
        anchor_ration_selection_ingredient.setVisible(false);
        anchor_ration_management.setVisible(false);
        //
        page_animaux_management.setVisible(false);
        //
        popup_animal_management.setVisible(false);
        //
        anchor_animaux_management.setVisible(false);
        // Populate your input fields with the selected data
        popup_espece_besoin_nutritionnel.setValue(selectedBesoinNutritionnel.getEspeceBesoinNutritionnel());
        popup_status_production_besoin_nutritionnel.setValue(selectedBesoinNutritionnel.getStatutProductionBesoinNutritionnel());
        popup_sexe_besoin_nutritionnel.setText(selectedBesoinNutritionnel.getSexeBesoinNutritionnel());
        popup_slider_poids_min_besoin_nutritionnel.setValue(selectedBesoinNutritionnel.getPoidsMinBesoinNutritionnel());
        popup_poids_max_slider_besoin_nutritionnel.setValue(selectedBesoinNutritionnel.getPoidsMaxBesoinNutritionnel());
        popup_combox_bute_producion.setValue(selectedBesoinNutritionnel.getButeProductionBesoinNutritionnel());
    }

    //modify 
    @FXML
    private void modifySelectedBesoinNutritionnel() {
        // Get the selected BesoinNutritionnelsEntity from the table view
        BesoinNutritionnelsEntity selectedBesoinNutritionnel = table_besoin_nutritionnel.getSelectionModel().getSelectedItem();

        if (selectedBesoinNutritionnel != null) {
            // Get the updated values from your input fields
            String espece = popup_espece_besoin_nutritionnel.getValue();
            String statutProduction = popup_status_production_besoin_nutritionnel.getValue();
            String sexe = popup_sexe_besoin_nutritionnel.getText();
            double poidsMin = popup_slider_poids_min_besoin_nutritionnel.getValue();
            double poidsMax = popup_poids_max_slider_besoin_nutritionnel.getValue();
            String buteProduction = popup_combox_bute_producion.getValue();

            // Update the selectedBesoinNutritionnel
            selectedBesoinNutritionnel.setEspeceBesoinNutritionnel(espece);
            selectedBesoinNutritionnel.setStatutProductionBesoinNutritionnel(statutProduction);
            selectedBesoinNutritionnel.setSexeBesoinNutritionnel(sexe);
            selectedBesoinNutritionnel.setPoidsMinBesoinNutritionnel(poidsMin);
            selectedBesoinNutritionnel.setPoidsMaxBesoinNutritionnel(poidsMax);
            selectedBesoinNutritionnel.setButeProductionBesoinNutritionnel(buteProduction);

            // Now, update the entity in your database
            ServiceBesoinNutritionnel service = new ServiceBesoinNutritionnel(Database.getInstance().getConnection());
            service.update(selectedBesoinNutritionnel);

            // Refresh the table view
            table_besoin_nutritionnel.refresh();
        } else {
            System.out.println("No item selected for modification.");
        }
    }

//tableview (affichage)
    private ObservableList<AnimauxEnGestationEntity> loadDataFromDatabase() {
        // Implement this method to fetch data from your database
        ServiceAnimauxEnGestation service = new ServiceAnimauxEnGestation(Database.getInstance().getConnection());
        // Example of fetching data (replace with your actual database query)
        List<AnimauxEnGestationEntity> dataFromDatabase = service.getSpecificColumnsFromDatabase();
        return FXCollections.observableArrayList(dataFromDatabase);
    }

    private ObservableList<BesoinNutritionnelsEntity> loadBesoinFromDatabase() {
        ServiceBesoinNutritionnel service = new ServiceBesoinNutritionnel(Database.getInstance().getConnection());
        // Implement this method to fetch specific columns from the database
        List<BesoinNutritionnelsEntity> dataFromDatabase = service.getSpecificColumnsFromDatabase();
        return FXCollections.observableArrayList(dataFromDatabase);
    }

    private ObservableList<IngrediantEntity> loadIngrediantsFromDatabase() {

        ServiceIngredient service = new ServiceIngredient(Database.getInstance().getConnection());

        List<IngrediantEntity> dataFromDatabase = service.getSpecificColumnsFromDatabase();
        return FXCollections.observableArrayList(dataFromDatabase);
    }
     private ObservableList<Animal> loadAnimalFromDatabase() {
ServiceAnimal service = new ServiceAnimal(Database.getInstance().getConnection());

        List<Animal> dataFromDatabase = service.getSpecificColumnsFromDatabase();
        return FXCollections.observableArrayList(dataFromDatabase);    }

    //ajout
    @FXML
    void AddIngredient(ActionEvent event) throws IOException {
        page_tableau_bord.setVisible(false);
        page_ingredient_main.setVisible(true);
        popup_ingredient_managment.setVisible(true);
        //
        anchor_valeur_nutritionnelles1.setVisible(false);
        anchor_valeur_nutritionnelles2.setVisible(true);
        //
        page_besoin_nutritionnels_management.setVisible(false);
        //
        popup_besoin_nutritionnels_management.setVisible(false);
        //
        anchor_besoin_nutritionnel.setVisible(false);
        anchor_valeur_nutritionnelles02.setVisible(false);
        //
        page_ration_managemnt.setVisible(false);
        //
        popup_ration_management.setVisible(false);
        //
        anchor_ration_selection_ingredient.setVisible(false);
        anchor_ration_management.setVisible(false);
        //
        page_animaux_management.setVisible(false);
        //
        popup_animal_management.setVisible(false);
        //
        anchor_animaux_management.setVisible(false);
        System.out.println("Database instance connection");
        System.out.println(Database.getInstance().getConnection());
        ServiceIngredient ingredientService = new ServiceIngredient(Database.getInstance().getConnection());
        String nom = nom_ingredient_popup_ingredient_management.getText();
        String type = type_ingredient_popup_ingredient_management.getValue();
        String description = description_popup_ingredient_management.getText();
        String prix = prix_popup_ingredient_management.getText();
        String quantite = quantite_popup_ingredient_management.getText();
        String udm = combobox_udm_popup_ingredient_management.getValue();
        String source = source_popup_ingredient_management.getText();

// Declare and initialize the nutrimentPrincipal variable
        String nutrimentPrincipal = "";

        if (chekbox_fibre_popup_ingredient_management.isSelected()) {
            nutrimentPrincipal = "Fibre";
        } else if (chekbox_energie_popup_ingredient_management.isSelected()) {
            nutrimentPrincipal = "Energie";
        } else if (chekbox_mineral_popup_ingredient_management.isSelected()) {
            nutrimentPrincipal = "Mineral";
        } else if (chekbox_protien_popup_ingredient_management.isSelected()) {
            nutrimentPrincipal = "Protien";
        }

        IngrediantEntity ingredient = new IngrediantEntity(nom, type, description, prix, quantite, udm, source, nutrimentPrincipal);
        ingredientService.ajouter(ingredient);
    }

    @FXML
    void addValeurNutritionnel(ActionEvent event) throws IOException {
        System.out.println("Database instance connection");
        System.out.println(Database.getInstance().getConnection());
        ServiceValeurNutritionnel serviceValeurNutritionnel
                = new ServiceValeurNutritionnel(Database.getInstance().getConnection());

        String pbText = pb_popup_ingredient_management.getText();
        String fbText = fb_popup_ingredient_management.getText();
        String adfText = adf_popup_ingredient_management.getText();
        String ndfText = ndf_popup_ingredient_management.getText();
        String msText = ms_popup_ingredient_management.getText();
        String ebText = eb_popup_ingredient_management.getText();
        String caText = ca_popup_ingredient_management.getText();
        String pText = p_popup_ingredient_management.getText();
        String mgText = mg_popup_ingredient_management.getText();
        String kText = k_popup_ingredient_management.getText();

        // Parse the text values to double
        double pb = Double.parseDouble(pbText);
        double fb = Double.parseDouble(fbText);
        double adf = Double.parseDouble(adfText);
        double ndf = Double.parseDouble(ndfText);
        double ms = Double.parseDouble(msText);
        double eb = Double.parseDouble(ebText);
        double ca = Double.parseDouble(caText);
        double p = Double.parseDouble(pText);
        double mg = Double.parseDouble(mgText);
        double k = Double.parseDouble(kText);

        // Create a NutritionalValues object
        ValeurNutritionnelEntity nutritionalValues = new ValeurNutritionnelEntity(pb, fb, adf, ndf, ms, eb, ca, p, mg, k);
        System.out.println(nutritionalValues);
        serviceValeurNutritionnel.ajouter(nutritionalValues);
    }

    @FXML
    void addBesoinNutritionnel(ActionEvent event) throws IOException {
        page_tableau_bord.setVisible(false);
        page_ingredient_main.setVisible(false);
        popup_ingredient_managment.setVisible(false);
        //
        anchor_valeur_nutritionnelles1.setVisible(false);
        anchor_valeur_nutritionnelles2.setVisible(false);
        //
        page_besoin_nutritionnels_management.setVisible(true);
        //
        popup_besoin_nutritionnels_management.setVisible(true);
        //
        anchor_besoin_nutritionnel.setVisible(true);
        anchor_valeur_nutritionnelles02.setVisible(false);
        anchor_btn_enregistrer_besoin_nutritionnel.setVisible(true);
        anchor_btn_modify_delete_besoin_nutritionnel.setVisible(false);
        //
        page_ration_managemnt.setVisible(false);
        //
        popup_ration_management.setVisible(false);
        //
        anchor_ration_selection_ingredient.setVisible(false);
        anchor_ration_management.setVisible(false);

        //
        page_animaux_management.setVisible(false);
        //
        popup_animal_management.setVisible(false);
        //
        anchor_animaux_management.setVisible(false);
        System.out.println("Database instance connection");
        System.out.println(Database.getInstance().getConnection());
        ServiceBesoinNutritionnel serviceBesoinNutritionnel
                = new ServiceBesoinNutritionnel(Database.getInstance().getConnection());

        // Retrieve values from UI elements
        String espece = popup_espece_besoin_nutritionnel.getValue();
        String statutProduction = popup_status_production_besoin_nutritionnel.getValue();
        String sexe = popup_sexe_besoin_nutritionnel.getText();
        double poidsMin = popup_slider_poids_min_besoin_nutritionnel.getValue();
        double poidsMax = popup_poids_max_slider_besoin_nutritionnel.getValue();
        String buteProduction = popup_combox_bute_producion.getValue();

        // Create a BesoinNutritionnelEntity object
        BesoinNutritionnelsEntity besoinNutritionnel = new BesoinNutritionnelsEntity(
                espece, statutProduction, sexe, poidsMin, poidsMax, buteProduction);

        System.out.println(besoinNutritionnel);
        serviceBesoinNutritionnel.ajouter(besoinNutritionnel);

    }

    //supprimer
    @FXML
    private void deleteSelectedBesoinNutritionnel() {
        // Récupérez l'élément sélectionné dans la table
        BesoinNutritionnelsEntity selectedBesoinNutritionnel = table_besoin_nutritionnel.getSelectionModel().getSelectedItem();

        if (selectedBesoinNutritionnel != null) {
            int idBesoinNutritionnel = selectedBesoinNutritionnel.getIdBesoinNutritionnel(); // Remplacez cela par le vrai moyen d'obtenir l'ID

            // Appelez la méthode de suppression du service
            ServiceBesoinNutritionnel service = new ServiceBesoinNutritionnel(Database.getInstance().getConnection());
            service.supprimer(idBesoinNutritionnel);

            // Mettez à jour la table après la suppression
            table_besoin_nutritionnel.getItems().remove(selectedBesoinNutritionnel);
        } else {
            // Aucun élément sélectionné, affichez un message d'erreur
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez sélectionner un élément à supprimer.");
            alert.showAndWait();
        }
    }
// filtrage et recherche 
    
   

}
