package com.example.proyectospring.Services;

import com.example.proyectospring.Model.Plato;
import com.example.proyectospring.Repository.RepositoryPlato;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlatoService implements InterfacesPlato {

    private final RepositoryPlato repositoryPlato;

    public PlatoService(RepositoryPlato repositoryPlato) {
        this.repositoryPlato = repositoryPlato;
    }

    @Override
    public void save(Plato plato) {
        this.repositoryPlato.save(plato);
    }

    @Override
    public List<Plato> findAll() {
        return repositoryPlato.findAll();
    }

    @Override
    public Optional<Plato> findPlatoByEvery(String nombre, double precio) {
        return repositoryPlato.findClienteByEvery(nombre, precio);
    }

    @Override
    public void editPlato(long id, String nombre, double precio) {
        repositoryPlato.editPlato(id, nombre, precio);
    }

    @Override
    public void deletePlato(long id) {
        repositoryPlato.deletePlato(id);
    }

    @Override
    public void insertPlato(String nombre, double precio) {
        repositoryPlato.insertPlato(nombre, precio);
    }

    @Override
    public List<Plato> findAllById(List<Long> ids) {
        return repositoryPlato.findAllByIdIn(ids);
    }


}
