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

    public void salvar(Cliente cliente){
        String sql = "INSERT INTO tbcliente (nome, sobrenome, cpf, endereco, telefone) VALUES (?,?,?,?,?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getSobrenome());
            preparedStatement.setString(3, cliente.getCpf());
            preparedStatement.setString(4, cliente.getEndereco());
            preparedStatement.setString(5, cliente.getTelefone());

            preparedStatement.execute();
            System.out.println("Salvo com sucesso!");
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
    }

    public void alterar (Integer id, String nome, String sobrenome, String cpf, String endereco, String telefone) throws SQLException {
        String sql = "UPDATE tbcliente c SET c.nome = ?, c.sobrenome = ?, c.cpf = ?, c.endereco = ?, c.telefone = ? WHERE id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, sobrenome);
            preparedStatement.setString(3, cpf);
            preparedStatement.setString(4, endereco);
            preparedStatement.setString(5, telefone);
            preparedStatement.setInt(6, id);

            preparedStatement.execute();
        } catch (SQLException e) {
            connection.rollback();
            throw new RuntimeException(e);
        }
    }

    public void buscar(Integer id){
        String sql = "SELECT * FROM tbcliente WHERE id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            preparedStatement.execute();

            try(ResultSet resultSet = preparedStatement.getResultSet()){
                while(resultSet.next()){
                    Cliente cliente = new Cliente(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6)
                    );
                    System.out.println(cliente);
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void buscar(String cpf){
        String sql = "SELECT * FROM tbcliente WHERE cpf = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, cpf);
            preparedStatement.execute();

            try(ResultSet resultSet = preparedStatement.getResultSet()){
                while (resultSet.next()){
                    Cliente cliente = new Cliente(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6)
                    );
                    System.out.println(cliente);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Cliente> buscarPorNome(String nome){
        List<Cliente> listaNomes = new ArrayList<Cliente>();
        String sql = "SELECT * FROM tbcliente WHERE nome = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, nome);
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
                    listaNomes.add(cliente);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaNomes;
    }

    public void deletar(Integer id) throws SQLException {
        String sql = "DELETE FROM tbcliente WHERE id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            connection.rollback();
            throw new RuntimeException(e);

        }
    }

    public void deletar(String cpf) throws SQLException {
        String sql = "DELETE FROM tbcliente WHERE cpf = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, cpf);
            preparedStatement.execute();
        } catch (SQLException e){
            connection.rollback();
            throw new RuntimeException();
        }
    }

}
