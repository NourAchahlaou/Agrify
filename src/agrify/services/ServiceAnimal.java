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

    @Override
    public void ajouter(Animal animal) {
        try {
            System.out.println(connect);
            PreparedStatement statement = connect.prepareStatement("INSERT INTO `animal`(`idAnimal`, `especeAnimal`, `sexeRation`, `poidsmaxRation`, `poidsminRation`, `ageAnimal`, `nombreAnimal`) VALUES (?, ?, ?, ?, ?, ?, ?)");

            statement.setInt(1, animal.getIdAnimal());
            statement.setString(2, animal.getEspeceAnimal());
            statement.setString(3, animal.getSexeRation());
            statement.setDouble(4, animal.getPoidsmaxRation());
            statement.setDouble(5, animal.getPoidsminRation());
            statement.setInt(6, animal.getAgeAnimal());
            statement.setInt(7, animal.getNombreAnimal());

            statement.executeUpdate();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void update(Animal animal) {
        try {
            // Prepare the SQL update statement
            String updateQuery = "UPDATE `animal` SET `especeAnimal`=?, `sexeRation`=?, `poidsmaxRation`=?, `poidsminRation`=?, `ageAnimal`=?, `nombreAnimal`=? WHERE `idAnimal`=?";

            PreparedStatement statement = connect.prepareStatement(updateQuery);
            statement.setString(1, animal.getEspeceAnimal());
            statement.setString(2, animal.getSexeRation());
            statement.setDouble(3, animal.getPoidsmaxRation());
            statement.setDouble(4, animal.getPoidsminRation());
            statement.setInt(5, animal.getAgeAnimal());
            statement.setInt(6, animal.getNombreAnimal());
            statement.setInt(7, animal.getIdAnimal());

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exceptions appropriately
        }
    }

    @Override
    public void supprimer(int idAnimal) {
        try {
            String deleteQuery = "DELETE FROM `animal` WHERE `idAnimal`=?";

            PreparedStatement preparedStatement = connect.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, idAnimal);

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Animal> getAllAnimal() {
    List<Animal> animals = new ArrayList<>();
    try {
        String query = "SELECT * FROM animal";

        // Create a prepared statement
        PreparedStatement statement = connect.prepareStatement(query);

        // Execute the query and get the result set
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            // Use a constructor or factory method to create Animal instances
            Animal animal = new Animal(
                resultSet.getInt("idAnimal"),
                resultSet.getString("especeAnimal"),
                resultSet.getDouble("poidsmaxRation")
            );

            animals.add(animal);
        }
    } catch (SQLException e) {
        // Handle any potential database exceptions
        e.printStackTrace();
    }

    return animals;
}


}
