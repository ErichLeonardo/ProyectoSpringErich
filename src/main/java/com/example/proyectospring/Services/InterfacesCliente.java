package com.example.proyectospring.Services;

import com.example.proyectospring.Model.Cliente;

import java.util.List;
import java.util.Optional;

public interface InterfacesCliente {
    void save(Cliente cliente);
    List<Cliente> findAll();
    Optional<Cliente> findClienteByEvery(String nombre, String telefono);
    void editCliente(int id, String nombre, String telefono);
    void deleteCliente(int id);
    void insertCliente(String nombre, String telefono);

    Optional<Cliente> findClienteById(long id);
}
