package com.proyectoGuardiasOscar.guardias.controladores;

import com.proyectoGuardiasOscar.guardias.modelo.Guardias;
import com.proyectoGuardiasOscar.guardias.servicios.GuardiasServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guardias")
@CrossOrigin(origins="http://localhost:4200")
public class GuardiasController {

    @Autowired
    private GuardiasServiceImpl guardiasService;

    @GetMapping
    public ResponseEntity<List<Guardias>> obtenerTodasGuardias() {
        List<Guardias> guardias = guardiasService.obtenerTodos();
        return new ResponseEntity<>(guardias, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guardias> obtenerGuardiaPorId(@PathVariable("id") Integer id) {
        Guardias guardia = guardiasService.obtenerUno(id);
        if (guardia != null) {
            return new ResponseEntity<>(guardia, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Guardias> crearGuardia(@RequestBody Guardias guardia) {
        Guardias nuevaGuardia = guardiasService.insertar(guardia);
        return new ResponseEntity<>(nuevaGuardia, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Guardias> actualizarGuardia(@PathVariable("id") Integer id, @RequestBody Guardias guardia) {
        Guardias guardiaExistente = guardiasService.obtenerUno(id);
        if (guardiaExistente != null) {
            guardia.setId_guardias(id);
            Guardias guardiaActualizada = guardiasService.modificar(guardia);
            return new ResponseEntity<>(guardiaActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarGuardia(@PathVariable("id") Integer id) {
        Guardias guardia = guardiasService.obtenerUno(id);
        if (guardia != null) {
            guardiasService.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
