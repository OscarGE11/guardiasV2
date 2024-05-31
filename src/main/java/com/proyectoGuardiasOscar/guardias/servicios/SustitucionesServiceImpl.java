package com.proyectoGuardiasOscar.guardias.servicios;

import com.proyectoGuardiasOscar.guardias.modelo.Guardias;
import com.proyectoGuardiasOscar.guardias.modelo.Sustituciones;
import com.proyectoGuardiasOscar.guardias.repositorios.IGenericoRepositorio;
import com.proyectoGuardiasOscar.guardias.repositorios.IGuardiasRepository;
import com.proyectoGuardiasOscar.guardias.repositorios.ISustitucionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SustitucionesServiceImpl extends CRUDImpl<Sustituciones,Integer> implements ISustitucionesService {

    @Autowired
    ISustitucionesRepository repo;

    @Override
    protected IGenericoRepositorio<Sustituciones, Integer> getRepo() {
        return repo;
    }
}
