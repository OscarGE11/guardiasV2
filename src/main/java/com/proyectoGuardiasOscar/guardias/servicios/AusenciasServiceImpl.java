package com.proyectoGuardiasOscar.guardias.servicios;

import com.proyectoGuardiasOscar.guardias.modelo.Ausencias;
import com.proyectoGuardiasOscar.guardias.modelo.Sustituciones;
import com.proyectoGuardiasOscar.guardias.repositorios.IAusenciasRepository;
import com.proyectoGuardiasOscar.guardias.repositorios.IGenericoRepositorio;
import com.proyectoGuardiasOscar.guardias.repositorios.ISustitucionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AusenciasServiceImpl extends CRUDImpl<Ausencias,Integer> implements IAusenciasService {
    @Autowired
    IAusenciasRepository repo;

    @Override
    protected IGenericoRepositorio<Ausencias, Integer> getRepo() {
        return repo;
    }
}
