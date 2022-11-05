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
        cliente.setNome("Jonny");
        cliente.setSobrenome("Blaize");
        cliente.setCpf("12345678912");
        cliente.setEndereco("Rua olivia marcos Barbacena - MG");
        cliente.setTelefone("31798702147");

        //clienteDAO.salvar(cliente);

        clienteDAO.alterar(6, "Carlinho", "Sacana", "12345678912", "Rua berlim", "78457802144");

        List<Cliente> listarTodosClientes = clienteDAO.listar();
        listarTodosClientes.forEach(c -> System.out.println(c));

    }
}
