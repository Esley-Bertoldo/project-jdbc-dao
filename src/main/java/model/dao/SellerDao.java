package model.dao;


import model.entities.Department;
import model.entities.Seller;

import java.util.List;

public interface SellerDao {

    void insert(Seller obj); // Inserir no banco de dados esse obj que eu enviar como parâmetro
    void update(Seller obj); // Atualiza o banco de dados com esse obj que eu enviar como parâmetro
    void deleteById(Integer id);
    Seller findById(Integer id); // Pega o id, consulta o banco de dados e retorna o obj com esse id, se n existir retorna null
    List<Seller> findAll(); // Retorna todos os obj
    List<Seller> findByDepartment(Department department); // buscar os vendedores dado o departamento

}
