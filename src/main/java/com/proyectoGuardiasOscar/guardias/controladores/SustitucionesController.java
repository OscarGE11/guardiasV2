package com.proyectoGuardiasOscar.guardias.controladores;

import com.proyectoGuardiasOscar.guardias.modelo.Sustituciones;
import com.proyectoGuardiasOscar.guardias.servicios.SustitucionesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sustituciones")
@CrossOrigin(origins="http://localhost:4200")
public class SustitucionesController{
    @Autowired
    private SustitucionesServiceImpl sustitucionesService;

    @GetMapping
    public ResponseEntity<List<Sustituciones>> obtenerTodasSustituciones() {
        List<Sustituciones> sustituciones = sustitucionesService.obtenerTodos();
        return new ResponseEntity<>(sustituciones, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sustituciones> obtenerSustitucionPorId(@PathVariable("id") Integer id) {
        Sustituciones sustitucion = sustitucionesService.obtenerUno(id);
        if (sustitucion != null) {
            return new ResponseEntity<>(sustitucion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Sustituciones> crearSustitucion(@RequestBody Sustituciones sustitucion) {
        Sustituciones nuevaSustitucion = sustitucionesService.insertar(sustitucion);
        return new ResponseEntity<>(nuevaSustitucion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sustituciones> actualizarSustitucion(@PathVariable("id") Integer id, @RequestBody Sustituciones sustitucion) {
        Sustituciones sustitucionExistente = sustitucionesService.obtenerUno(id);
        if (sustitucionExistente != null) {
            sustitucion.setId_sustitucion(id);
            Sustituciones sustitucionActualizada = sustitucionesService.modificar(sustitucion);
            return new ResponseEntity<>(sustitucionActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSustitucion(@PathVariable("id") Integer id) {
        Sustituciones sustitucion = sustitucionesService.obtenerUno(id);
        if (sustitucion != null) {
            sustitucionesService.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
