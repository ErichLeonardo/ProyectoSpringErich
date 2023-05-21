package com.example.proyectospring.Services;

import com.example.proyectospring.Model.Cliente;
import com.example.proyectospring.Repository.RepositoryCliente;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements InterfacesCliente {

    private final RepositoryCliente repositoryCliente;

    public ClienteService(RepositoryCliente repositoryCliente) {
        this.repositoryCliente = repositoryCliente;
    }

    @Override
    public void save(Cliente cliente) {
        repositoryCliente.save(cliente);
    }

    @Override
    public List<Cliente> findAll() {
        return repositoryCliente.findAll();
    }

    @Override
    public Optional<Cliente> findClienteByEvery(String nombre, String telefono) {
        return repositoryCliente.findClienteByEvery(nombre, telefono);
    }

    @Override
    public void editCliente(int id, String nombre, String telefono) {
        repositoryCliente.editCliente(id, nombre, telefono);
    }

    @Override
    public void deleteCliente(int id) {
        repositoryCliente.deleteCliente(id);
    }

    @Override
    public void insertCliente(String nombre, String telefono) {
        repositoryCliente.insertCliente(nombre, telefono);
    }

    @Override
    public Optional<Cliente> findClienteById(long id) {
        return repositoryCliente.findById(id);
    }
}
