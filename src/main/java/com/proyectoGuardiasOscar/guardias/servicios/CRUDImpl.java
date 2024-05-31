package com.proyectoGuardiasOscar.guardias.servicios;

import com.proyectoGuardiasOscar.guardias.repositorios.IGenericoRepositorio;

import java.util.List;

public abstract class CRUDImpl<T,ID> implements ICRUD<T,ID>{
    protected abstract IGenericoRepositorio<T,ID> getRepo();
    @Override
    public T insertar(T t){return getRepo().save(t); }

    @Override
    public T modificar(T t) {return getRepo().save(t);}

    @Override
    public void eliminar(ID id) {

        getRepo().deleteById(id);
    }

    @Override
    public T obtenerUno(ID id){return getRepo().findById(id).orElse(null);}

    @Override
    public List<T> obtenerTodos(){return getRepo().findAll();}
}
