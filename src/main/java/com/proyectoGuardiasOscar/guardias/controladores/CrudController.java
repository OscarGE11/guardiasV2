package com.proyectoGuardiasOscar.guardias.controladores;

import com.proyectoGuardiasOscar.guardias.servicios.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public abstract class CrudController<T, ID> {

    @Autowired
    private CrudService<T, ID> service;

    @GetMapping
    public List<T> getAll() {
        return service.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<T> getById(@PathVariable ID id) {
        return service.obtenerUno(id);
    }

    @PostMapping
    public T create(@RequestBody T entity) {
        return service.guardar(entity);
    }

    @PutMapping("/{id}")
    public T update(@PathVariable ID id, @RequestBody T entity) {

        if (service.obtenerUno(id).isPresent()) {
            return service.guardar(entity);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable ID id) {
        service.borrar(id);
    }
}