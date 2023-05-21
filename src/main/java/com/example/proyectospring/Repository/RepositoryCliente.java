package com.example.proyectospring.Repository;

import com.example.proyectospring.Model.Cliente;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositoryCliente extends JpaRepository<Cliente,Long> {
    @Query(value="SELECT * FROM Clientes", nativeQuery = true)
    public List<Cliente> findAll();

    @Query(value="SELECT * FROM Clientes WHERE nombre=?1 and telefono=?2", nativeQuery = true)
    Optional<Cliente> findClienteByEvery(String nombre, String telefono);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Clientes SET nombre = :nombre, telefono = :telefono WHERE id = :id", nativeQuery = true)
    void editCliente(@Param("id") int id, @Param("nombre") String nombre, @Param("telefono") String telefono);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Clientes WHERE id = :id", nativeQuery = true)
    void deleteCliente(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Clientes (nombre, telefono) VALUES (:nombre, :telefono)", nativeQuery = true)
    void insertCliente(@Param("nombre") String nombre, @Param("telefono") String telefono);

    Optional<Cliente> findById(Long id);


}


