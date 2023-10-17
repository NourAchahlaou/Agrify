/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agrify.services;

import agrify.entities.Animal;
import agrify.entities.BesoinNutritionnelsEntity;
import agrify.utils.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alien kami sama
 */
public class ServiceAnimal implements IServiceAnimal<Animal> {

    private Connection connect;
    private Database database; // Add a dataSource field

    public ServiceAnimal(Connection connection) {
        this.connect = connection;
    }

    public ServiceAnimal(Database database) {
        this.database = database;

    }

    public List<Animal> getSpecificColumnsFromDatabase() {
        List<Animal> specificColumnsData = new ArrayList<>();

        try {
            // Create a SQL query to select specific columns
            String query = "SELECT `idAnimal`, `especeAnimal`, `sexeRation`, `poidsmaxRation`, `poidsminRation`, `ageAnimal`, `nombreAnimal` FROM `animal`";

            // Create a prepared statement
            PreparedStatement statement = connect.prepareStatement(query);

            // Execute the query and get the result set
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // Retrieve the specific columns from the result set and create Animal objects
                int idAnimal = resultSet.getInt("idAnimal");
                String especeAnimal = resultSet.getString("especeAnimal");
                String sexeRation = resultSet.getString("sexeRation");
                double poidsmaxRation = resultSet.getDouble("poidsmaxRation");
                double poidsminRation = resultSet.getDouble("poidsminRation");
                int ageAnimal = resultSet.getInt("ageAnimal");
                int nombreAnimal = resultSet.getInt("nombreAnimal");

                // Create a new Animal and add it to the list
                Animal animal = new Animal(idAnimal, especeAnimal, sexeRation, poidsmaxRation, poidsminRation, ageAnimal, nombreAnimal);

                specificColumnsData.add(animal);

            }

            // Close the statement and result set
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exceptions appropriately
        }

        return specificColumnsData;
    }
}
