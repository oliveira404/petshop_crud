import DAO.AnimalDAO;
import DAO.ClienteDAO;
import factory.ConnectionFactory;
import model.Animal;
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
        AnimalDAO animalDAO = new AnimalDAO(connection);

        Cliente cliente = new Cliente();
        cliente.setNome("João");
        cliente.setSobrenome("Felipe");
        cliente.setCpf("12345678914");
        cliente.setEndereco("Rua olivia marcos Barbacena - MG");
        cliente.setTelefone("31798702147");

        Animal animal = new Animal();
        animal.setNome("tumtum");
        animal.setAnimal("Peixe");
        animal.setRaca("Golden Fish");
        animal.setIdade(1);
        animal.setFkCliente(1);


        //clienteDAO.salvar(cliente);
        //animalDAO.salvar(animal);

        //clienteDAO.alterar(6, "Carlinho", "Sacana", "12345678912", "Rua berlim", "78457802144");
        //animalDAO.alterar(1, "miguel", "cavalo", "lobato", 12, 1);

        //clienteDAO.buscar(3);
        //animalDAO.buscar(1);

        //clienteDAO.buscar("12345678911");

        //List<Cliente> buscarClienteNomes = clienteDAO.buscarPorNome("joão");
        //buscarClienteNomes.forEach(nomeCliente -> System.out.println(nomeCliente));
        //List<Animal> buscarAnimalNomes = animalDAO.buscarAnimalNome("tumtum");
        //buscarAnimalNomes.forEach(nomeAnimal -> System.out.println(nomeAnimal));



        //clienteDAO.deletar(6);
        //clienteDAO.deletar("12345678910");

        //List<Animal> listaTodosAnimais = animalDAO.listar();
        //listaTodosAnimais.forEach(todosAnimais -> System.out.println(todosAnimais));

        System.out.println("\n");

        List<Cliente> listarTodosClientes = clienteDAO.listar();
        listarTodosClientes.forEach(c -> System.out.println(c));

    }
}
