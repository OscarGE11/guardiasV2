package com.proyectoGuardiasOscar.guardias.repositorios;

import com.proyectoGuardiasOscar.guardias.modelo.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUsuariosRepository extends IGenericoRepositorio<Usuarios,Integer> {

    Optional<Usuarios> findByEmail(String email);

}
