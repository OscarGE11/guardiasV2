package com.proyectoGuardiasOscar.guardias.servicios;

import com.proyectoGuardiasOscar.guardias.modelo.Usuarios;
import com.proyectoGuardiasOscar.guardias.repositorios.IGenericoRepositorio;
import com.proyectoGuardiasOscar.guardias.repositorios.IUsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosServiceImpl extends CRUDImpl<Usuarios,Integer> implements IUsuariosService {

    @Autowired
    private IUsuariosRepository repo;

    @Override
    protected IGenericoRepositorio<Usuarios, Integer> getRepo() {
        return repo;
    }

    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String nombre) {
                return repo.findByEmail(nombre)
                        .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
            }
        };

    }


    public Optional<Usuarios> buscarPorCorreo (String correo) {
        return repo.findByEmail(correo);
    }
}
