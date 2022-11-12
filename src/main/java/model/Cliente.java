package model;

public class Cliente {

    private Integer id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String endereco;
    private String telefone;




    public Cliente(Integer id, String nome, String sobrenome, String cpf, String endereco, String telefone){
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public Cliente (){}

    public Cliente(String string, String string1, String string2, String string3) {
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
        return "ID: " + id + "\tNOME: " + nome + "\tSOBRENOME: " + sobrenome + "\tCPF: " + cpf + "\tENDERECO: " + endereco + "\tTELEFONE: " + telefone;

    }
}
