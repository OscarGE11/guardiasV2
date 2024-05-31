package com.proyectoGuardiasOscar.guardias.controladores;

import com.proyectoGuardiasOscar.guardias.modelo.Ausencias;
import com.proyectoGuardiasOscar.guardias.modelo.Usuarios;
import com.proyectoGuardiasOscar.guardias.servicios.UsuariosServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins="http://localhost:4200")
public class UsuarioController{

    @Autowired
    private UsuariosServiceImpl usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuarios>> obtenerTodosUsuarios() {
        List<Usuarios> usuarios = usuarioService.obtenerTodos();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> obtenerUsuarioPorId(@PathVariable("id") Integer id) {
        Usuarios usuario = usuarioService.obtenerUno(id);
        if (usuario != null) {
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Usuarios> crearUsuario(@RequestBody Usuarios usuario) {
        Usuarios nuevoUsuario = usuarioService.insertar(usuario);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuarios> actualizarUsuario(@PathVariable("id") Integer id, @RequestBody Usuarios usuario) {
        Usuarios usuarioExistente = usuarioService.obtenerUno(id);
        if (usuarioExistente != null) {
            usuario.setId_usuario(id);
            Usuarios usuarioActualizado = usuarioService.modificar(usuario);
            return new ResponseEntity<>(usuarioActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable (name = "id") Integer id) throws SQLException, ClassNotFoundException{
        Usuarios usuarios = usuarioService.obtenerUno(id);
        if (usuarios == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        usuarioService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

