package com.proyectoGuardiasOscar.guardias.controladores;

import com.proyectoGuardiasOscar.guardias.modelo.Sustituciones;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sustituciones")
public class SustitucionesController extends CrudController<Sustituciones, Integer> {
}
