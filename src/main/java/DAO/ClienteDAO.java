package DAO;

import model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private Connection connection;

    public ClienteDAO(Connection connection){
        this.connection = connection;
    }

    public List<Cliente> listar(){
        List<Cliente> listaCliente = new ArrayList<Cliente>();
        String sql = "SELECT * FROM tbcliente";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.execute();

            try(ResultSet resultSet = preparedStatement.getResultSet()) {
                while(resultSet.next()){
                    Cliente cliente = new Cliente(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6)
                    );
                    listaCliente.add(cliente);
                }
                return listaCliente;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




}
