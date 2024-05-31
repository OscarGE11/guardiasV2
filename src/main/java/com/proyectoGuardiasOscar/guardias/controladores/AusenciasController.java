package com.proyectoGuardiasOscar.guardias.controladores;

import com.proyectoGuardiasOscar.guardias.modelo.Ausencias;
import com.proyectoGuardiasOscar.guardias.servicios.AusenciasServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ausencias")
@CrossOrigin(origins="http://localhost:4200")
public class AusenciasController {

    @Autowired
    private AusenciasServiceImpl ausenciasService;


    @GetMapping
    public ResponseEntity<List<Ausencias>> obtenerTodos(){
        List<Ausencias> ausencias = ausenciasService.obtenerTodos();
        return new ResponseEntity<>(ausencias, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ausencias> obtenerUno(@PathVariable(name = "id") Integer idAusencias) throws SQLException, ClassNotFoundException {
        Ausencias ausencia = ausenciasService.obtenerUno(idAusencias);
        if (ausencia == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ausencia, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Ausencias> insertar(@RequestBody Ausencias ausencia) throws SQLException, ClassNotFoundException{
        ausencia = ausenciasService.insertar(ausencia);
        return new ResponseEntity<>(ausencia, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ausencias> modificar(@PathVariable(name = "id") Integer idAusencias, @RequestBody Ausencias ausencia) throws SQLException, ClassNotFoundException{
        Ausencias ausenciaExistente = ausenciasService.obtenerUno(idAusencias);
        if(ausenciaExistente == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ausencia.setId_ausencia(idAusencias);
        ausencia = ausenciasService.modificar(ausencia);
        return new ResponseEntity<>(ausencia, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable (name = "id") Integer idAusencias) throws SQLException, ClassNotFoundException{
        Ausencias ausencia = ausenciasService.obtenerUno(idAusencias);
        if (ausencia == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ausenciasService.eliminar(idAusencias);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
