package com.proyectoGuardiasOscar.guardias.repositorios;

import com.proyectoGuardiasOscar.guardias.modelo.Ausencias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAusenciasRepository extends JpaRepository<Ausencias,Integer> {
}
