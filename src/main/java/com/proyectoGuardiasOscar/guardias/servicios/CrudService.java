package com.proyectoGuardiasOscar.guardias.servicios;

import java.util.List;
import java.util.Optional;

public interface CrudService<T,ID>{

    List<T> obtenerTodos();

    Optional<T> obtenerUno(ID id);

    T guardar(T t);

    T actualizar(T t);

    void borrar(ID id);
}
