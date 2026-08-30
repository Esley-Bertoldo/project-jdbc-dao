# Project DAO JDBC

Sistema de gerenciamento de vendedores e departamentos desenvolvido em **Java**, utilizando **JDBC** para integração com banco de dados **MySQL** e o padrão de projeto **DAO (Data Access Object)**.

## 📌 Sobre o Projeto

O **Project DAO JDBC** é uma aplicação desenvolvida para praticar a integração entre uma aplicação Java e um banco de dados relacional utilizando JDBC.

O sistema trabalha com **vendedores (Seller)** e **departamentos (Department)**, permitindo realizar operações de persistência como cadastro, consulta, atualização e exclusão de registros.

O projeto também demonstra a utilização do padrão **DAO**, separando as regras de acesso ao banco de dados das entidades da aplicação.

## 🚀 Funcionalidades

* Cadastro de vendedores
* Cadastro de departamentos
* Busca de vendedor por ID
* Listagem de vendedores
* Busca de vendedores por departamento
* Atualização de vendedores
* Exclusão de vendedores
* Busca de departamento por ID
* Listagem de departamentos
* Atualização de departamentos
* Exclusão de departamentos
* Integração com banco de dados MySQL
* Tratamento de exceções relacionadas ao banco de dados
* Relacionamento entre vendedores e departamentos

---

# 🏗️ Arquitetura

O projeto utiliza uma estrutura baseada no padrão **DAO**, separando as responsabilidades entre entidades, interfaces DAO, implementações JDBC e conexão com o banco de dados.

```text
src/
└── main/
    ├── java/
    │   ├── application/
    │   │   └── Program.java
    │   │
    │   ├── db/
    │   │   ├── DB.java
    │   │   ├── DbException.java
    │   │   └── DbIntegrityException.java
    │   │
    │   └── model/
    │       ├── dao/
    │       │   ├── DaoFactory.java
    │       │   ├── DepartmentDao.java
    │       │   ├── SellerDao.java
    │       │   │
    │       │   └── impl/
    │       │       ├── DepartmentDaoJDBC.java
    │       │       └── SellerDaoJDBC.java
    │       │
    │       └── entities/
    │           ├── Department.java
    │           └── Seller.java
    │
    └── resources/
        └── db.properties
```

## 🔄 Padrão DAO

O padrão **DAO (Data Access Object)** é utilizado para separar o acesso ao banco de dados das entidades da aplicação.

```text
Application
     │
     ▼
   DAO
     │
     ▼
DAO JDBC
     │
     ▼
   JDBC
     │
     ▼
   MySQL
```

Essa abordagem facilita a organização e manutenção do código, além de permitir que a lógica de persistência fique concentrada nas classes DAO.

---

# 🧩 Entidades

## Seller

Representa um vendedor cadastrado no sistema.

```text
id: Integer
name: String
email: String
birthDate: Date
baseSalary: Double
department: Department
```

Um vendedor pertence a um departamento.

## Department

Representa um departamento da empresa.

```text
id: Integer
name: String
```

### Relacionamento

```text
Department
    │
    │ 1
    │
    └──────────< N
              Seller
```

Um departamento pode possuir vários vendedores, enquanto cada vendedor pertence a um departamento.

---

# 🗄️ Persistência de Dados

O acesso ao banco de dados é realizado utilizando **JDBC (Java Database Connectivity)**.

As operações de persistência são implementadas nas classes:

* `SellerDaoJDBC`
* `DepartmentDaoJDBC`

Entre as operações disponíveis estão:

```text
INSERT
SELECT
UPDATE
DELETE
```

As consultas também utilizam `PreparedStatement`, contribuindo para uma comunicação mais segura e organizada com o banco de dados.

---

# 🛠️ Tecnologias Utilizadas

* **Java**
* **JDBC**
* **MySQL**
* **Maven**
* **SQL**
* **POO (Programação Orientada a Objetos)**
* **DAO Pattern**
* **Generics**
* **Collections Framework**
* **Exception Handling**

---

# 📦 Dependência Principal

O projeto utiliza o driver JDBC oficial do MySQL através do Maven:

```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>26.7.0</version>
</dependency>
```

---

# ⚙️ Como Executar

## Pré-requisitos

Antes de executar o projeto, tenha instalado:

* Java
* Maven
* MySQL
* IntelliJ IDEA, Eclipse ou VS Code

## 1. Clone o repositório

```bash
git clone https://github.com/Esley-Bertoldo/Project-Dao-Jdbc.git
```

Entre na pasta:

```bash
cd Project-Dao-Jdbc
```

## 2. Configure o banco de dados

Crie o banco de dados MySQL utilizado pelo projeto:

```sql
CREATE DATABASE coursejdbc;
```

Configure as credenciais no arquivo:

```text
src/main/resources/db.properties
```

Exemplo:

```properties
user=seu_usuario
password=sua_senha
dburl=jdbc:mysql://localhost:3306/coursejdbc
useSSL=false
```

> **Importante:** não publique senhas reais no GitHub. Utilize valores locais ou variáveis de ambiente.

## 3. Execute o projeto

Como o projeto utiliza Maven, pode ser executado pela IDE ou através do Maven.

Na IDE, execute:

```text
src/main/java/application/Program.java
```

---

# 📚 Conceitos Praticados

Este projeto foi desenvolvido com foco nos seguintes conceitos:

### Programação Orientada a Objetos

* Classes e objetos
* Encapsulamento
* Associação entre objetos
* Interfaces
* Sobrescrita de métodos
* `equals()` e `hashCode()`
* `toString()`

### Banco de Dados

* SQL
* CRUD
* Chaves primárias
* Chaves estrangeiras
* Relacionamentos
* JOIN
* PreparedStatement
* ResultSet

### Java + JDBC

* `Connection`
* `PreparedStatement`
* `ResultSet`
* `SQLException`
* Gerenciamento de recursos
* Integração com MySQL

### Padrões e Estruturas

* DAO Pattern
* Factory Pattern
* Interfaces
* Collections
* Generics

---

# 📁 Principais Classes

| Classe                 | Responsabilidade                           |
| ---------------------- | ------------------------------------------ |
| `Program`              | Ponto de entrada da aplicação              |
| `DB`                   | Gerenciamento da conexão com o banco       |
| `DaoFactory`           | Criação das implementações DAO             |
| `SellerDao`            | Interface de acesso aos vendedores         |
| `SellerDaoJDBC`        | Implementação JDBC do DAO de vendedores    |
| `DepartmentDao`        | Interface de acesso aos departamentos      |
| `DepartmentDaoJDBC`    | Implementação JDBC do DAO de departamentos |
| `Seller`               | Entidade vendedor                          |
| `Department`           | Entidade departamento                      |
| `DbException`          | Exceções relacionadas ao banco             |
| `DbIntegrityException` | Exceções de integridade do banco           |

---

# 🎯 Objetivo

O projeto tem como objetivo consolidar conhecimentos de **Java, JDBC, SQL e Programação Orientada a Objetos**, aplicando uma arquitetura organizada para comunicação entre uma aplicação Java e um banco de dados MySQL.

---

# 👨‍💻 Autor

**Esley Bertoldo**

GitHub: [Esley-Bertoldo](https://github.com/Esley-Bertoldo)

LinkedIn: [Esley Bertoldo](https://www.linkedin.com/in/esley-bertoldo)
