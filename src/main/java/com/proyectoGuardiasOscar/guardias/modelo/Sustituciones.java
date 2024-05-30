package com.proyectoGuardiasOscar.guardias.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "sustituciones")
public class Sustituciones {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_sustitucion;

    @ManyToOne
    @JoinColumn(name = "guardia_id", nullable = false)
    private Guardias guardia;

    @ManyToOne
    @JoinColumn(name = "profesor_sustituido_id", nullable = false)
    private Usuarios usuario;

     @Column()
    private String motivo;
}
