package DAO;

import model.Animal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnimalDAO {
    private Connection connection;

    public AnimalDAO(Connection connection){
        this.connection = connection;

    }

    public List<Animal> listar(){
        List<Animal> listaAnimal = new ArrayList<Animal>();
        String sql = "SELECT * FROM tbanimal";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.execute();

             try(ResultSet resultSet = preparedStatement.getResultSet()){
                 while(resultSet.next()){
                     Animal animal = new Animal(
                             resultSet.getInt(1),
                             resultSet.getString(2),
                             resultSet.getString(3),
                             resultSet.getString(4),
                             resultSet.getInt(5),
                             resultSet.getInt(6)
                     );
                     listaAnimal.add(animal);
                 }
                 return listaAnimal;
             }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
