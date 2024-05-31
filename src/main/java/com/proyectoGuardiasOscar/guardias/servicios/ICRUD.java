package com.proyectoGuardiasOscar.guardias.servicios;

import java.util.List;

public interface ICRUD<T,ID> {
    T insertar(T t);
    T modificar(T t);
    void eliminar(ID id);
    T obtenerUno(ID id);
    List<T> obtenerTodos();
}
