import DAO.ClienteDAO;
import factory.ConnectionFactory;
import model.Cliente;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recoveryConnection();


        ClienteDAO clienteDAO = new ClienteDAO(connection);
        Cliente cliente = new Cliente();

        List<Cliente> listarTodosClientes = clienteDAO.listar();
        listarTodosClientes.forEach(c -> System.out.println(c));



    }
}
