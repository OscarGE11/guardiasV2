package com.proyectoGuardiasOscar.guardias.repositorios;

import com.proyectoGuardiasOscar.guardias.modelo.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuariosRepository extends JpaRepository<Usuarios,Integer> {

}
