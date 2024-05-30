package com.proyectoGuardiasOscar.guardias.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class CrudServiceImpl<T,ID> implements CrudService<T,ID>{

    @Autowired
    private JpaRepository<T, ID> repository;

    @Override
    public List<T> obtenerTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<T> obtenerUno(ID id) {
        return repository.findById(id);
    }

    @Override
    public T guardar(T t) {
        return repository.save(t);
    }

    @Override
    public T actualizar(T t) {
        return repository.save(t);
    }

    @Override
    public void borrar(ID id) {
        repository.deleteById(id);
    }
}
