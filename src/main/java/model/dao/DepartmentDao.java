package model.dao;

import model.entities.Department;

import java.util.List;

public interface DepartmentDao {

    void insert(Department obj); // Inserir no banco de dados esse obj que eu enviar como parâmetro
    void update(Department obj); // Atualiza o banco de dados com esse obj que eu enviar como parâmetro
    void deleteById(Integer id);
    Department findById(Integer id); // Pega o id, consulta o banco de dados e retorna o obj com esse id, se n existir retorna null
    List<Department> findAll(); // Retorna todos os obj

}
