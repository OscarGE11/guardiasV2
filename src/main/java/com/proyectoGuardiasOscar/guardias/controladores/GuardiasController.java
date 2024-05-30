package com.proyectoGuardiasOscar.guardias.controladores;

import com.proyectoGuardiasOscar.guardias.modelo.Guardias;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guardias")
public class GuardiasController extends CrudController<Guardias, Integer> {
}
