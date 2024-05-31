package com.proyectoGuardiasOscar.guardias.repositorios;

import com.proyectoGuardiasOscar.guardias.modelo.Ausencias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


public interface IAusenciasRepository extends IGenericoRepositorio<Ausencias,Integer> {
}
