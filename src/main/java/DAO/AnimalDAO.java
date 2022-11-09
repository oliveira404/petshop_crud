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

    public void salvar(Animal animal){
        String sql = "INSERT INTO tbanimal (nome, animal, raca, idade, fk_cliente) VALUES (?,?,?,?,?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, animal.getNome());
            preparedStatement.setString(2, animal.getAnimal());
            preparedStatement.setString(3, animal.getRaca());
            preparedStatement.setInt(4, animal.getIdade());
            preparedStatement.setInt(5, animal.getFkCliente());

            preparedStatement.execute();
        } catch (SQLException e){
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
