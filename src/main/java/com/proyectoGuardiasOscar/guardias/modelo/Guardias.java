package com.proyectoGuardiasOscar.guardias.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "guardias")

public class Guardias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_guardias;

    @Column()
    private String dia_semana;

    @Column()
    private String hora;

    @Column()
    private String aula;


    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuarios usuario;


}
