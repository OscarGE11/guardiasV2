package com.proyectoGuardiasOscar.guardias.controladores;

import com.proyectoGuardiasOscar.guardias.modelo.Ausencias;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ausencias")
public class AusenciasController extends CrudController<Ausencias, Integer> {
}
