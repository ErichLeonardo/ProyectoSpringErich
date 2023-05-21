package com.example.proyectospring.Services;

import com.example.proyectospring.Model.Cliente;
import com.example.proyectospring.Model.Plato;

import java.util.List;
import java.util.Optional;

public interface InterfacesPlato {
    void save(Plato plato);
    List<Plato> findAll();
    Optional<Plato> findPlatoByEvery(String nombre, double precio);
    void editPlato(long id, String nombre, double precio);
    void deletePlato(long id);
    void insertPlato(String nombre, double precio);
    List<Plato> findAllById (List<Long> ids);
}

