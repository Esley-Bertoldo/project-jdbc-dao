# Project DAO JDBC

A seller and department management system developed in **Java**, using **JDBC** for **MySQL** database integration and the **DAO (Data Access Object)** design pattern.

## 📌 About the Project

**Project DAO JDBC** is an application developed to practice the integration between a Java application and a relational database using JDBC.

The system works with **sellers (Seller)** and **departments (Department)**, allowing persistence operations such as creating, retrieving, updating, and deleting records.

The project also demonstrates the use of the **DAO pattern**, separating database access logic from the application's entities.

## 🚀 Features

* Seller registration
* Department registration
* Find seller by ID
* List all sellers
* Find sellers by department
* Update sellers
* Delete sellers
* Find department by ID
* List all departments
* Update departments
* Delete departments
* MySQL database integration
* Database exception handling
* Relationship between sellers and departments

---

# 🏗️ Architecture

The project follows a structure based on the **DAO pattern**, separating responsibilities between entities, DAO interfaces, JDBC implementations, and database connection management.

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

---

# 🔄 DAO Pattern

The **DAO (Data Access Object)** pattern is used to separate database access from the application's entities.

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

This approach improves code organization and maintainability while keeping persistence logic centralized in the DAO classes.

---

# 🧩 Entities

## Seller

Represents a seller registered in the system.

```text
id: Integer
name: String
email: String
birthDate: Date
baseSalary: Double
department: Department
```

A seller belongs to a department.

## Department

Represents a department within the company.

```text
id: Integer
name: String
```

### Relationship

```text
Department
    │
    │ 1
    │
    └──────────< N
              Seller
```

A department can have multiple sellers, while each seller belongs to one department.

---

# 🗄️ Data Persistence

Database access is performed using **JDBC (Java Database Connectivity)**.

Persistence operations are implemented in the following classes:

* `SellerDaoJDBC`
* `DepartmentDaoJDBC`

The available operations include:

```text
INSERT
SELECT
UPDATE
DELETE
```

The queries also use `PreparedStatement`, contributing to safer and more organized communication with the database.

---

# 🛠️ Technologies Used

* **Java**
* **JDBC**
* **MySQL**
* **Maven**
* **SQL**
* **Object-Oriented Programming (OOP)**
* **DAO Pattern**
* **Generics**
* **Collections Framework**
* **Exception Handling**

---

# 📦 Main Dependency

The project uses the official MySQL JDBC driver through Maven:

```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>26.7.0</version>
</dependency>
```

---

# ⚙️ How to Run

## Prerequisites

Before running the project, make sure you have the following installed:

* Java
* Maven
* MySQL
* IntelliJ IDEA, Eclipse, or VS Code

## 1. Clone the repository

```bash
git clone https://github.com/Esley-Bertoldo/Project-Dao-Jdbc.git
```

Enter the project directory:

```bash
cd Project-Dao-Jdbc
```

## 2. Configure the database

Create the MySQL database used by the project:

```sql
CREATE DATABASE coursejdbc;
```

Configure your database credentials in:

```text
src/main/resources/db.properties
```

Example:

```properties
user=your_username
password=your_password
dburl=jdbc:mysql://localhost:3306/coursejdbc
useSSL=false
```

> **Important:** Never publish real passwords or sensitive credentials on GitHub. Use local values or environment variables.

## 3. Run the project

Since the project uses Maven, it can be run through an IDE or using Maven.

In your IDE, run:

```text
src/main/java/application/Program.java
```

---

# 📚 Concepts Practiced

This project was developed with a focus on the following concepts:

### Object-Oriented Programming

* Classes and objects
* Encapsulation
* Object association
* Interfaces
* Method overriding
* `equals()` and `hashCode()`
* `toString()`

### Database

* SQL
* CRUD
* Primary keys
* Foreign keys
* Relationships
* JOIN
* PreparedStatement
* ResultSet

### Java + JDBC

* `Connection`
* `PreparedStatement`
* `ResultSet`
* `SQLException`
* Resource management
* MySQL integration

### Patterns and Structures

* DAO Pattern
* Factory Pattern
* Interfaces
* Collections
* Generics

---

# 📁 Main Classes

| **Class**              | **Responsibility**                        |
| ---------------------- | ----------------------------------------- |
| `Program`              | Application entry point                   |
| `DB`                   | Database connection management            |
| `DaoFactory`           | Creates DAO implementations               |
| `SellerDao`            | Seller data access interface              |
| `SellerDaoJDBC`        | JDBC implementation of the seller DAO     |
| `DepartmentDao`        | Department data access interface          |
| `DepartmentDaoJDBC`    | JDBC implementation of the department DAO |
| `Seller`               | Seller entity                             |
| `Department`           | Department entity                         |
| `DbException`          | Database-related exceptions               |
| `DbIntegrityException` | Database integrity exceptions             |

---

# 🎯 Objective

The project's goal is to consolidate knowledge of **Java, JDBC, SQL, and Object-Oriented Programming**, applying an organized architecture for communication between a Java application and a MySQL database.

---

# 👨‍💻 Author

**Esley Bertoldo**

GitHub: **Esley-Bertoldo**

LinkedIn: **Esley Bertoldo**
