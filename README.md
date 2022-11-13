<h1 align="center" style="font-weight:bold">CRUD - PetShop</h1>

<p align="center">
<img src="https://img.shields.io/badge/STATUS-completo-blue?style=for-the-badge">
</p>

<br>

# **Tópicos**


* [Descrição do Projeto](#descrição-do-projeto)
* [Funcionalidades](#funcionalidades)
* [Aplicação](#aplicação)
* [Técnicas e tecnologias utilizadas](#técnicas-e-tecnologias-utilizadas)
* [Acesso ao Projeto](#acesso-ao-projeto)
* [Abrir e rodar o projeto](#abrir-e-rodar-o-projeto)
* [Extras](#extras)


<br>

## **Descrição do projeto**
<p>O projeto foi criado para consolidar meus conhecimentos adquiridos em Java e SQL, onde aprendi a fazer manipulações e modelagem no banco de dados, utilizando Java para fazer operações com CRUD.</p>
<br>
<img src="https://i.imgur.com/cJWJOeL.png">

<br>

## **Funcionalidades**

1. Realizar operação de (criar, ler, deletar, alterar.)
2. Permite fazer buscas das mais variadas formas, tanto por id, cpf nome...
3. Permite que possa ser extendido, ou agregado em outros projetos como base.

<br>

## **Aplicação**
<br>

![](https://i.imgur.com/ZXVpKK2.gif)

<br>

## **Técnicas e tecnologias utilizadas**
- Java
- MariaDB
- Paradigma de orientação a objetos
- InteliJ IDEA
- MySQL Workbench
- Biblioteca C3P0 para pull de conexão

<br>

## **Acesso ao projeto**
Você pode <a href="https://github.com/oliveiradeigor/petshop_crud">acessar o código fonte do projeto</a> ou <a href="https://github.com/oliveiradeigor/petshop_crud/archive/refs/heads/main.zip">baixá-lo</a>

<br>

## **Abrir e rodar o projeto**
Antes de rodar o projeto vamos construir a base de dados.

1. Abra sua ferramenta para manipulação do banco, copie e execulte o código SQL abaixo. Visando que seu banco está ativo.

- **Modelo entidade relacional**

<img src="https://i.imgur.com/ix1EQ1R.png">

<br>

- **Passo a passo**

<img src="https://i.imgur.com/EFGXzjB.gif">

```sql
-- DROP SCHEMA petshop_db;
CREATE DATABASE petshop_db;

USE petshop_db;

CREATE TABLE tbcliente(
	id INT AUTO_INCREMENT NOT NULL,
    nome VARCHAR(50) NOT NULL,
    sobrenome VARCHAR(255) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    endereco VARCHAR(255) NOT NULL,
    telefone VARCHAR(11) NOT NULL,
    PRIMARY KEY(id)
);

ALTER TABLE tbcliente ADD CONSTRAINT UNIQUE KEY (cpf);

INSERT INTO tbcliente(
	nome, 
    sobrenome, 
    cpf,
    endereco, 
    telefone) 
VALUES (
	'João',
    'Fernandes',
    '12345678910',
    'Rua costa sete, JUAREMA-SP',
    '11998970217'
);

INSERT INTO tbcliente(
	nome, 
    sobrenome, 
    cpf,
    endereco, 
    telefone) 
VALUES (
	'Pedro',
    'Felipe',
    '12345678912',
    'Rua costa sete, JUAREMA-SP',
    '11998970217'
);

INSERT INTO tbcliente(
	nome, 
    sobrenome, 
    cpf,
    endereco, 
    telefone) 
VALUES (
	'Rodrigo',
    'Castanha',
    '12345678913',
    'Rua costa sete, JUAREMA-SP',
    '11998970217'
);

CREATE TABLE tbanimal(
	id INT NOT NUll AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    animal VARCHAR(255) NOT NULL,
    raca VARCHAR(255) NOT NULL,
    idade INT(150) NOT NULL,
    fk_cliente INT NOT NULL,
    PRIMARY KEY(id)
);
  
ALTER TABLE tbanimal ADD FOREIGN KEY(fk_cliente) REFERENCES tbcliente(id);


INSERT INTO tbanimal(
	nome,
    animal,
    raca,
    idade,
    fk_cliente
) VALUES (
	'lady',
    'gato',
    'persa',
    2,
    1
);

INSERT INTO tbanimal(
	nome,
    animal,
    raca,
    idade,
    fk_cliente
) VALUES (
	'jonh',
    'cachorro',
    'Husky siberiano',
    7,
    1
);


INSERT INTO tbanimal(
	nome,
    animal,
    raca,
    idade,
    fk_cliente
) VALUES (
	'lasquinha',
    'hamster',
    'hamster-sírio',
    7,
    1
);

INSERT INTO tbanimal(
	nome,
    animal,
    raca,
    idade,
    fk_cliente
) VALUES (
	'black',
    'cobra',
    'Cobra Real Californiana',
    3,
    2
);

INSERT INTO tbanimal(
	nome,
    animal,
    raca,
    idade,
    fk_cliente
) VALUES (
	'sirius',
    'Aranha',
    'Armadeira',
    1,
    3
);
```
2. Após baixar o projeto Java, você pode abrir com o `InteliJ IDEA` Para isso, na tela de launcher clique em:




- `Open an Existing Project` (ou alguma opção similar);
- Procure o local onde o projeto está e o selecione (Caso o projeto seja baixado via zip, é necessário extraí-lo antes de procurá-lo);
- Após abrir o projeto vá na classe `ConnectionFactory` e siga os passos a passos para fazer sua conexão corretamente passando suas credenciais do seu banco.
<img src="https://i.imgur.com/0IKl0Zj.gif">
3. Com tudo feito, você pode abrir a classe `Main` e lidar com os métodos disponíveis.

<br>

## **Extras**
O projeto conta com relacionamento de tabelas caso lhe interesse você testar e criar modificações do mesmo.
```sql
SELECT animal.nome, animal, raca, idade, cli.nome AS Dono, cli.id 
FROM tbanimal AS animal 
INNER JOIN tbcliente AS cli 
ON animal.fk_cliente = cli.id WHERE cli.id = 1;


SELECT c.nome, c.sobrenome, c.cpf, c.telefone, a.animal, a.nome, a.fk_cliente 
FROM tbcliente 
AS c 
INNER JOIN tbanimal 
AS a 
ON c.id = a.fk_cliente;
```