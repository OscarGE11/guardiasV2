package com.proyectoGuardiasOscar.guardias.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")

public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;

    @Column()
    private String nombre;

    @Column
    private String email;

    @Column
    @Enumerated(EnumType.STRING)
    private Rol rol;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Guardias> guardias;
    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Ausencias> ausencias;
    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Sustituciones> sustituciones;


}
