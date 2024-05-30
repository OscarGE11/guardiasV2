package com.proyectoGuardiasOscar.guardias.repositorios;

import com.proyectoGuardiasOscar.guardias.modelo.Guardias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGuardiasRepository extends JpaRepository<Guardias,Integer> {
}
