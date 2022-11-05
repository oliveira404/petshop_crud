import DAO.ClienteDAO;
import factory.ConnectionFactory;
import model.Cliente;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recoveryConnection();


        ClienteDAO clienteDAO = new ClienteDAO(connection);

        Cliente cliente = new Cliente();
        cliente.setNome("João");
        cliente.setSobrenome("Felipe");
        cliente.setCpf("12345678914");
        cliente.setEndereco("Rua olivia marcos Barbacena - MG");
        cliente.setTelefone("31798702147");

        //clienteDAO.salvar(cliente);

        //clienteDAO.alterar(6, "Carlinho", "Sacana", "12345678912", "Rua berlim", "78457802144");

        //clienteDAO.buscar(3);
        //clienteDAO.buscar("12345678911");
        //List<Cliente> buscarClienteNomes = clienteDAO.buscarPorNome("joão");
        //buscarClienteNomes.forEach(nomeCliente -> System.out.println(nomeCliente));

        //clienteDAO.deletar(6);
        //clienteDAO.deletar("12345678910");

        List<Cliente> listarTodosClientes = clienteDAO.listar();
        listarTodosClientes.forEach(c -> System.out.println(c));

    }
}
