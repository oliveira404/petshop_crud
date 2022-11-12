package model;

public class Animal {
    private Integer id;
    private String nome;
    private String animal;
    private String raca;
    private Integer idade;
    private Integer fkCliente;


    public Animal(Integer id, String nome, String animal, String raca, Integer idade, Integer fkCliente) {
        this.id = id;
        this.nome = nome;
        this.animal = animal;
        this.raca = raca;
        this.idade = idade;
        this.fkCliente = fkCliente;
    }

    public Animal() {

    }

    public Animal(String string, String string1, int anInt) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Integer getFkCliente() {
        return fkCliente;
    }

    public void setFkCliente(Integer fkCliente) {
        this.fkCliente = fkCliente;
    }

    @Override
    public String toString() {
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        return "ID: " + id + " NOME: " + nome + " ANIMAL " + animal + " RAÇA " + raca + " IDADE: " + idade + " ID_CLIENTE: " + fkCliente;
    }
}
