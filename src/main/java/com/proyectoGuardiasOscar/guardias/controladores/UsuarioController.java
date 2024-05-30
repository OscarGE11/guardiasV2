package com.proyectoGuardiasOscar.guardias.controladores;

import com.proyectoGuardiasOscar.guardias.modelo.Usuarios;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController extends CrudController<Usuarios,Integer> {
}
