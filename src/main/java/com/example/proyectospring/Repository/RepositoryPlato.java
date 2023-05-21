package com.example.proyectospring.Repository;

import com.example.proyectospring.Model.Cliente;
import com.example.proyectospring.Model.Plato;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositoryPlato extends JpaRepository<Plato, Long> {
    @Query(value="SELECT * FROM Platos", nativeQuery = true)
    public List<Plato> findAll();

    @Query(value="SELECT * FROM Platos WHERE nombre=?1 and precio=?2", nativeQuery = true)
    Optional<Plato> findClienteByEvery(String nombre, double precio);

    @Modifying
    @Transactional
    @Query(value="UPDATE Platos SET nombre = :nombre, precio = :precio WHERE id = :id", nativeQuery = true)
    void editPlato(@Param("id") long id, @Param("nombre") String nombre, @Param("precio") double precio);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Platos WHERE id = :id", nativeQuery = true)
    void deletePlato(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO platos (nombre, precio) VALUES (:nombre, :precio)", nativeQuery = true)
    void insertPlato(@Param("nombre") String nombre, @Param("precio") double precio);

    List<Plato> findAllByIdIn(List<Long> ids);

}
