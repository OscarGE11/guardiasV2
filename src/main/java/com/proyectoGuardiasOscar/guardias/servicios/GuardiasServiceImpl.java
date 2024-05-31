package com.proyectoGuardiasOscar.guardias.servicios;

import com.proyectoGuardiasOscar.guardias.modelo.Guardias;
import com.proyectoGuardiasOscar.guardias.repositorios.IGenericoRepositorio;
import com.proyectoGuardiasOscar.guardias.repositorios.IGuardiasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuardiasServiceImpl extends CRUDImpl<Guardias,Integer> implements IGuardiasService{

    @Autowired

    IGuardiasRepository repo;

    @Override
    protected IGenericoRepositorio<Guardias, Integer> getRepo() {
        return repo;
    }
}
